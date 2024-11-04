# runner to run all codes in the given directory

import os, argparse, logging
from enum import Enum
from utils import log_execution_time
from abc import ABC, abstractmethod

logger = logging.getLogger(__name__)
MAX_TIMEOUT = 5  # seconds

class CodeExtension(Enum):
    JAVA = ".java"
    PYTHON = ".py"

class CodeType(Enum):
    JAVA = "java"
    PYTHON = "python"

class FallbackPaths(Enum):
    JAVA = [
        "java", "Java",
        "javaCode", "JavaCode", 
        "java_code", "Java_Code",
        "JavaSolution", "javaSolution", 
        "java_solution", "Java_Solution",
    ]
    PYTHON = [
        "python", "Python",
        "pythonCode", "PythonCode", 
        "python_code", "Python_Code",
        "PythonSolution", "pythonSolution",
        "python_solution", "Python_Solution"
    ]


class Validator:
    @classmethod
    def exists(cls, path: str, throw_error: bool=False) -> bool:
        prefix = "Directory" if os.path.isdir(path) else "File"
        if not os.path.exists(path):
            if throw_error:
                raise FileNotFoundError(f"{prefix} {path} does not exist")
            return False
        return True
    
    @classmethod
    def contains_file(cls, source_dir: str, file_extention: str) -> bool:
        # check if the directory contains any java files
        if not any(file.endswith(file_extention) for file in os.listdir(source_dir)):
            raise FileNotFoundError(f"Directory {source_dir} does not contain any {file_extention} files")


class CodeRunner(ABC):
    def __init__(self, source_directory_abs: str, debug: bool=False, extension: CodeExtension=None):
        self.source_directory_abs = source_directory_abs
        self.DEBUG = debug
        logging.basicConfig(
            level=logging.DEBUG if self.DEBUG else logging.INFO
        )
        self.extension = extension
    

    @abstractmethod
    def run(self, executable_file):
        """
        implement logic to run the code
        """
        pass
    

    def process_directory(self):
        # check if the directory exists
        Validator.exists(self.source_directory_abs)
        Validator.contains_file(self.source_directory_abs, self.extension.value)
        
        # change the working directory to the java directory
        os.chdir(self.source_directory_abs)
        logger.debug(f"Current directory: {os.getcwd()}")
        try:
            for file in os.listdir(self.source_directory_abs):
                if file.endswith(self.extension.value):
                    self.run(file)
        except Exception as e:
            logger.error(f"Error: {e}", exc_info=True)


class PythonRunner(CodeRunner):
    def __init__(self, source_directory_abs, debug=False):
        super().__init__(
            source_directory_abs, 
            debug,
            extension=CodeExtension.PYTHON
        )
    
    def _execute(self, python_file):
        print(f"Running {python_file}")
        os.system(f"python {python_file}")

    def run(self, python_file):
        if not Validator.exists(python_file):
            raise FileNotFoundError(f"Python file {python_file} does not exist")
        log_execution_time(self._execute, timeout=MAX_TIMEOUT)(python_file)


class JavaRunner(CodeRunner):
    def __init__(self, source_directory_abs, debug=False):
        super().__init__(
            source_directory_abs, 
            debug,
            extension=CodeExtension.JAVA
        )


    def _compile_java(self, file):
        class_name = file.split('.')[0]
        # check if the java file does not exist
        Validator.exists(file, throw_error=True)
        logger.debug(f"Compiling {file}")
        os.system(f"javac {file}")
        return class_name


    def _clean_up(self, class_name):
        logger.debug(f"Cleaning up {class_name}")
        # remove all class files with the given class name
        os.system(f"rm -f {class_name}*.class")


    def _execute(self, class_name):
        # check if the class file does not exist
        if not Validator.exists(f"{class_name}.class"):
            raise FileNotFoundError(f"Class file {class_name}.class does not exist")
        print(f"Running {class_name}")
        os.system(f"java {class_name}")


    def run(self, java_file):
        class_name = self._compile_java(java_file)
        log_execution_time(self._execute, timeout=MAX_TIMEOUT)(class_name)
        self._clean_up(class_name)


class RunnerFactory:
    @classmethod
    def get_runner(cls, code_type: str):
        logger.info(f"Code type: {code_type}")
        if code_type == CodeType.JAVA.value:
            return JavaRunner
        if code_type == CodeType.PYTHON.value:
            return PythonRunner
        raise ValueError(f"Invalid code type: {code_type}")
    

class Helper:
    @classmethod
    def get_suggestive_paths(cls, runner: CodeRunner) -> FallbackPaths:
        return FallbackPaths[runner.extension.name]


# if the given directory does not contain any java files, 
# search for the suggestive paths inside the given directory
def execute_with_suggestive_paths(runner: CodeRunner):
    s_dir_abs = runner.source_directory_abs
    suggestive_paths = Helper.get_suggestive_paths(runner).value
    logger.debug(f"Suggestive paths: {suggestive_paths}")

    counter = 0
    while counter < len(suggestive_paths):
        try:
            runner.process_directory()
            break
        except FileNotFoundError as e:
            logger.error(f"Error: {e}")
            logger.info(f"Searching for /{suggestive_paths[counter]} nested directory")
            runner.source_directory_abs = os.path.join(s_dir_abs, suggestive_paths[counter])
            counter += 1
            # print logs if no suggestive paths are found
            if counter == len(suggestive_paths):
                logger.error("No suggestive paths found for %s", s_dir_abs)
                logger.info(
                    "Try placing your code in one of the following directories: \n%s",
                    "\n".join(suggestive_paths)
                )
        except Exception as e:
            logger.error(f"Error: {e}")
            raise e


def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('--type', type=str, required=True, help='Type of code to run')
    parser.add_argument('--path', type=str, required=True, help='Path to java files directory')
    parser.add_argument('--debug', type=bool, required=False, help='enable debug mode')
    args = parser.parse_args()
    return vars(args)


def main(cli_args: dict):
    source_directory_abs = os.path.abspath(cli_args['path'])  # convert path to absolute path
    debug_mode = cli_args.get('debug', False)  # enable debug mode if the debug flag is set
    # get runner instance with the given type
    runner = RunnerFactory.get_runner(cli_args['type'])(source_directory_abs, debug_mode)
    # execute the runner with suggestive paths
    execute_with_suggestive_paths(runner)


if __name__ == "__main__":
    # execute the runner with suggestive paths
    main(cli_args=parse_args())
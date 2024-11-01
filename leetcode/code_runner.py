# runner to run all the java files in the given directory

import os, argparse, logging
from enum import Enum
from utils import log_execution_time

logger = logging.getLogger(__name__)

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


class CodeRunner:
    def __init__(self, source_directory_abs: str, debug: bool=False, extension: CodeExtension=None):
        self.source_directory_abs = source_directory_abs
        self.DEBUG = debug
        logging.basicConfig(
            level=logging.DEBUG if self.DEBUG else logging.INFO
        )
        self.extension = extension
    
    def run(self, executable_file):
        pass
    
    def process_files(self):
        pass

class PythonRunner(CodeRunner):
    def __init__(self, source_directory_abs, debug=False):
        super().__init__(
            source_directory_abs, 
            debug,
            extension=CodeExtension.PYTHON
        )

    @log_execution_time
    def run(self, executable_file):
        # check if the class file does not exist
        if not Validator.exists(executable_file):
            raise FileNotFoundError(f"Python file {executable_file} does not exist")
        logger.info(f"Running {executable_file}")
        os.system(f"python {executable_file}")

    
    def process_files(self):
        for file in os.listdir(self.source_directory_abs):
            if file.endswith(self.extension.value):
                self.run(file)
    

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
        os.system(f"rm -f {class_name}.class")


    @log_execution_time
    def run(self, executable_file):
        # check if the class file does not exist
        if not Validator.exists(f"{executable_file}.class"):
            raise FileNotFoundError(f"Class file {executable_file}.class does not exist")
        logger.info(f"Running {executable_file}")
        os.system(f"java {executable_file}")


    def process_files(self):
        for file in os.listdir(self.source_directory_abs):
            if file.endswith(self.extension.value):
                class_name = self._compile_java(file)
                self.run(class_name)
                self._clean_up(class_name)


class Helper:
    @classmethod
    def get_suggestive_paths(cls, runner: CodeRunner) -> FallbackPaths:
        return FallbackPaths[runner.extension.name]


class RunnerFactory:
    @classmethod
    def get_runner(cls, code_type: str):
        logger.info(f"Code type: {code_type}")
        if code_type == CodeType.JAVA.value:
            return JavaRunner
        if code_type == CodeType.PYTHON.value:
            return PythonRunner
        raise ValueError(f"Invalid code type: {code_type}")


class Main:
    @classmethod
    def parse_args(cls):
        parser = argparse.ArgumentParser()
        parser.add_argument('--type', type=str, required=True, help='Type of code to run')
        parser.add_argument('--path', type=str, required=True, help='Path to java files directory')
        parser.add_argument('--debug', type=bool, required=False, help='enable debug mode')
        args = parser.parse_args()
        return vars(args)
    
    @classmethod
    def process_directory(cls, runner: CodeRunner):
        # check if the directory exists
        Validator.exists(runner.source_directory_abs)
        Validator.contains_file(runner.source_directory_abs, runner.extension.value)
        
        # change the working directory to the java directory
        os.chdir(runner.source_directory_abs)
        logger.debug(f"Current directory: {os.getcwd()}")
        try:
            runner.process_files()
        except Exception as e:
            logger.error(f"Error: {e}", exc_info=True)


    # if the given directory does not contain any java files, 
    # search for the suggestive paths inside the given directory
    @classmethod
    def execute_with_suggestive_paths(cls, runner: CodeRunner):
        s_dir_abs = runner.source_directory_abs
        suggestive_paths = Helper.get_suggestive_paths(runner).value
        logger.debug(f"Suggestive paths: {suggestive_paths}")

        counter = 0
        while counter < len(suggestive_paths):
            try:
                cls.process_directory(runner)
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

    @classmethod
    def main(cls, source_directory_abs: str, DEBUG: bool):
        runner = RunnerFactory.get_runner(cli_args['type'])(source_directory_abs, DEBUG)
        cls.execute_with_suggestive_paths(runner)


if __name__ == "__main__":
    cli_args = Main.parse_args()
    # convert the path to absolute path
    source_directory_abs = os.path.abspath(cli_args['path'])
    # enable debug mode if the debug flag is set
    debug_mode = cli_args.get('debug', False)
    Main.main(source_directory_abs, debug_mode)
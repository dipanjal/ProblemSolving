# runner to run all the java files in the given directory

import os, argparse, logging

logger = logging.getLogger(__name__)
class JavaRunner:
    def __init__(self, source_directory_abs, debug=False):
        self.source_directory_abs = source_directory_abs
        self.DEBUG = debug
        logging.basicConfig(
            level=logging.DEBUG if self.DEBUG else logging.INFO
        )
        

    def compile_java(self, file):
        class_name = file.split('.')[0]
        # check if the java file does not exist
        if not os.path.exists(file):
            logger.error(f"File {file} does not exist")
            exit(1)
        logger.debug(f"Compiling {file}")
        os.system(f"javac {file}")
        return class_name


    def run_java(self, class_name):
        # check if the class file does not exist
        if not os.path.exists(f"{class_name}.class"):
            logger.error(f"Class file {class_name}.class does not exist")
            exit(1) 
        logger.info(f"Running {class_name}")
        os.system(f"java {class_name}")


    def clean_up(self, class_name):
        logger.debug(f"Cleaning up {class_name}")
        os.system(f"rm -f {class_name}.class")


    def process_java_files(self):
        for file in os.listdir(self.source_directory_abs):
            if file.endswith(".java"):
                class_name = self.compile_java(file)
                self.run_java(class_name)
                self.clean_up(class_name)
                print("--------------------------------")

    def process_directory(self):
        # check if the directory exists
        if not os.path.exists(self.source_directory_abs):
            raise FileNotFoundError(f"Directory {self.source_directory_abs} does not exist")
        # check if the directory contains any java files
        if not any(file.endswith(".java") for file in os.listdir(self.source_directory_abs)):
            raise FileNotFoundError(f"Directory {self.source_directory_abs} does not contain any java files")
        
        # change the working directory to the java directory
        os.chdir(self.source_directory_abs)
        logger.debug(f"Current directory: {os.getcwd()}")
        self.process_java_files()



def parse_args():
        parser = argparse.ArgumentParser()
        parser.add_argument('--path', type=str, required=True, help='Path to java files directory')
        parser.add_argument('--debug', type=bool, required=False, help='enable debug mode')
        args = parser.parse_args()
        return vars(args)

def main():
    cli_args = parse_args()
    # taking the path from the command line
    source_directory = cli_args['path']
    # enable debug mode if the debug flag is set
    DEBUG = cli_args.get('debug', False)
    # convert the path to absolute path
    source_directory_abs = os.path.abspath(source_directory)

    runner = JavaRunner(source_directory_abs, DEBUG)
    suggestive_paths = [
        "java", "Java",
        "javaCode", "JavaCode", "java_code",
        "JavaSolution", "javaSolution", "java_solution"
    ]
    counter = 0
    while counter < len(suggestive_paths):
        try:
            runner.process_directory()
            break
        except Exception as e:
            logger.error(f"Error: {e}")
            logger.info(f"Searching for /{suggestive_paths[counter]} nested directory")
            runner.source_directory_abs = os.path.join(runner.source_directory_abs, suggestive_paths[counter])
            counter += 1

if __name__ == "__main__":
    main()
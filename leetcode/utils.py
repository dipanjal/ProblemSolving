import timeit
from functools import wraps
import multiprocessing

class TimeLimitExceeded(Exception):
    """Custom exception to indicate a timeout."""
    def __init__(self, message="Time limit exceeded!"):
        super().__init__(message)

def run_with_timeout(func, timeout: int, *args, **kwargs):
    process = multiprocessing.Process(target=func, args=args, kwargs=kwargs)
    process.start()
    process.join(timeout)
    if process.is_alive():
        process.terminate()
        process.join()
        raise TimeLimitExceeded(f"exceeded the timeout of {timeout} seconds")

def log_execution_time(func, timeout: int = 1, throw: bool = False):
    @wraps(func)
    def wrapper(*args, **kwargs):
        # classified_function_name = f"{args[0].__class__.__name__}.{func.__name__}"
        print(f"-------- Executing {func.__name__} --------")
        start = timeit.default_timer()
        try:
            result = run_with_timeout(func, timeout, *args, **kwargs)
        except TimeLimitExceeded as e:
            if throw:
                raise e
            print(e)
            return

        elapsed_time_ms = (timeit.default_timer() - start) * 1000
        formatted_time = format_execution_time(elapsed_time_ms)
        print(f"{func.__name__} executed in {formatted_time}")
        print("---------------------------------------------")
        return result
    return wrapper

def format_execution_time(elapsed_time_ms):
    if elapsed_time_ms >= 1000:
        elapsed_time_sec = elapsed_time_ms / 1000
        if elapsed_time_sec >= 60:
            elapsed_time_min = elapsed_time_sec / 60
            return f"{elapsed_time_min:.2f} minutes"
        else:
            return f"{elapsed_time_sec:.2f} seconds"
    else:
        return f"{elapsed_time_ms:.3f} ms"
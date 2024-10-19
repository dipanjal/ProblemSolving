import timeit
from functools import wraps

def log_execution_time(func):
    @wraps(func)
    def wrapper(*args, **kwargs):
        start = timeit.default_timer()
        result = func(*args, **kwargs)
        elapsed_time_ms = (timeit.default_timer() - start) * 1000
        
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

        formatted_time = format_execution_time(elapsed_time_ms)
        print(f"{func.__name__} executed in {formatted_time}")
        return result
    return wrapper
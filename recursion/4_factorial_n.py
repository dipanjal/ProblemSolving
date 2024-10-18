def factorial_iterative(n):
    res = 1
    for i in range(1, n+1):
        res = res * i
    return res

# Parameterized Recursion, where the result param is being carry forwarded
# Top Down Recursion with Carry Forwording the Result to it's next recursion call
def factorial_param_recursion(n, res=1):
    if n == 1:
        # print(res)
        return res  # all the numbers are summer, it's time to return the result
    return factorial_param_recursion(n-1, res * n)


# Functional Recursion
# Top Down Recursion with Backtracking
# The previous call is wating for a result from it's immidiate recurison call
# after getting a result, the result will be summed with the current n value of that functional state
def factorial_func_recursion(n):
    if n == 1:
        return 1
    
    # Backtracking the result comming back from the immediate recursion call
    # And Multiplying with the n
    # This n * f(x) statement will until f(x) comes back with a result
    return n * factorial_func_recursion(n-1)
    
if __name__ == "__main__":
    n = 10
    print(factorial_iterative(n))
    print(factorial_param_recursion(n))
    print(factorial_func_recursion(n))
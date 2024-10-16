def sum_iterative(n):
    res = 0
    for i in range(1, n+1):
        res = res + i
    print(res)
    return res

# Top Down Recursion with Carry Forwording the Result to it's next recursion call
def sum_param_recursion(n, res=0):
    if n == 0:
        # print(res)
        return res  # all the numbers are summer, it's time to return the result
    return sum_param_recursion(n-1, res + n)


# Top Down Recursion with Backtracking
# The previous call is wating for a result from it's immidiate recurison call
# after getting a result, the result will be summed with the current n value of that functional state
def sum_func_recursion(n):
    if n == 0:
        return 0
    
    # Backtracking the result comming back from the immediate recursion call
    res = sum_func_recursion(n-1)
    # adding with the n
    return res + n
    
if __name__ == "__main__":
    sum_iterative(4)
    print(sum_param_recursion(4, 0))
    print(sum_func_recursion(4))
def fun(x, y):
    if x == 0:
        return y
    else:
        return fun(x - 1, x + y)

print(fun(5, 2))
# print 1 to N numbers using recursion & backtracking
def print_n_to_1(i, end):
    if i > end:
        return  # reached at the bottom, time to backtrack
    print_n_to_1(i + 1, end)
    print(i)


# print 1 to N numbers using recursion & backtracking
def print_1_to_n(i, end):
    if i == 0:
        return  # reached at the bottom, time to backtrack
    print_1_to_n(i - 1, end)
    print(i)

if __name__ == "__main__":
    n = 4
    print("print_1_to_n")
    print_1_to_n(n, n)
    print("print_n_to_1")
    print_n_to_1(1, n)

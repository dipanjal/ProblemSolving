# print N to 1 numbers using recursion 
# here start will be bigger than end
def print_n_to_1(start, end):
    if start < end:
        return
    print(start)
    print_n_to_1(start - 1, end)

# print 1 to N numbers using recursion 
def print_1_to_n(start, end):
    if start > end:
        return  # we are done printing all of the values
    print(start)
    print_1_to_n(start + 1, end)

if __name__ == "__main__":
    print("print_1_to_n")
    print_1_to_n(start=1, end=4)
    print("print_n_to_1")
    print_n_to_1(start=4, end=1)
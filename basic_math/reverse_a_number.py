import math
def reverse_num(n: int) -> int:
    sum = 0
    while n:
        last_digit = int(math.fmod(n , 10))
        sum = (sum * 10) + last_digit
        n = int(n / 10)
    return sum

if __name__ == "__main__":
    n = 9800
    print(reverse_num(n))
    n = -1234
    print(reverse_num(n))
    n = 0
    print(reverse_num(n))
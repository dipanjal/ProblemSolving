import math 

# Time Complexity: O(log n)
def count_digits(n: int):
    """
    Counts the number of digits in an integer n.

    This function works by repeatedly dividing the number n by 10 until it becomes 0,
    counting how many times this division occurs. The time complexity is O(log n)
    because the number of iterations is proportional to the number of digits in n,
    which is determined by the base-10 logarithm of n.

    Special cases:
    - If n is 0, the function returns 1 since 0 has one digit.
    - If n is negative, the function takes the absolute value of n before counting.

    Args:
        n (int): The input integer.

    Returns:
        int: The number of digits in the input integer.
    """
    if n == 0:
        return 1  # Special case for 0, which has 1 digit
    if n < 0:
        n = -n  # Handle negative numbers by taking the absolute value
    
    count = 0
    while n > 0:
        n = int(n / 10)
        count += 1
    return count

# Time Complexity: O(1)
def count_digits_opt(n: int) -> int:
    if n == 0:
        return 1  # Special case for 0, which has 1 digit
    if n < 0:
        n = -n  # Handle negative numbers by taking the absolute value
    power = int(math.log10(n))  # O(1)
    return power + 1 # 0(1)

# Test the function
if __name__ == "__main__":
    n = 12345
    digit_count = count_digits(n)
    assert digit_count == count_digits_opt(n)
    print(f"The number of digits in {n} is: {digit_count}")
    # Output: The number of digits in 12345 is: 5

    # Test with a negative number
    n = -6789
    digit_count = count_digits(n)
    assert digit_count == count_digits_opt(n)
    print(f"The number of digits in {n} is: {digit_count}")
    # Output: The number of digits in -6789 is: 4

    # Test with zero
    n = 0
    digit_count = count_digits(n)
    assert digit_count == count_digits_opt(n)
    print(f"The number of digits in {n} is: {digit_count}")
    # Output: The number of digits in 0 is: 1
    
    # Test with a large number
    n = 12345678901234567890
    digit_count = count_digits(n)
    assert digit_count == count_digits_opt(n)
    print(f"The number of digits in {n} is: {digit_count}")
    # Output: The number of digits in 12345678901234567890 is: 20

    # Test with a single digit
    n = 7
    digit_count = count_digits(n)
    assert digit_count == count_digits_opt(n)
    print(f"The number of digits in {n} is: {digit_count}")
    # Output: The number of digits in 7 is: 1

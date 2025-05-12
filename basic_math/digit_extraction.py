def extract_digits(n: int):
    # The function extract_digits takes an integer n as input and returns a list of its digits.
    digits = []
    while n > 0:
        # The function works by repeatedly taking the last digit of n using the modulus operator (%)
        last_digit = n % 10
        # and appending it to the list of digits.
        digits.append(last_digit)
        # and then removing that digit from n using integer division. 
        n = int(n / 10)
    
    # The digits are collected in a list in reverse order, 
    # so we need to reverse the list before returning it.
    # reverse the digits to get them in the correct order
    digits.reverse()
    return digits

# Test the function
if __name__ == "__main__":
    n = 12345
    digits = extract_digits(n)
    print(f"The digits of {n} are: {digits}")
# Output: The digits of 12345 are: [1, 2, 3, 4, 5]

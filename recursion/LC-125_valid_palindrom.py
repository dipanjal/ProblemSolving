# https://leetcode.com/problems/valid-palindrome/description/

# iterative solution
import timeit


class SolutionIter:    
    def isPalindrome(self, s: str) -> bool:
        # we will use two pointers one starts from the 0th index
        # another one starts from the last index of the string
        l, r = 0, len(s) - 1

        # the left index will keep moving forward
        # and the right index will be moving backward
        # as long as left is less than right
        # (because we don't want the left pointer goes beyond right pointer)
        while(l < r):
            if not s[l].isalnum():
                l += 1
                continue
            if not s[r].isalnum():
                r -= 1
                continue
            if s[l].lower() != s[r].lower():
                return False
            l += 1
            r -= 1
        return True
    

class SolutionRecur:
    def isPalindrome(self, s: str) -> bool:
        def check(l, r) -> bool:
            # Base case: If left index crosses the right, 
            # that means all the characters have been checked
            # it's a palindrome
            if l >= r:
                return True
            
            # If the character at left index is not alphanumeric, move forward with l + 1
            if not s[l].isalnum():
                return check(l + 1, r)
            
            # If the character at right index is not alphanumeric, move backward with r - 1
            if not s[r].isalnum():
                return check(l, r - 1)
            
            # If the characters at left and right don't match, return False
            if s[l].lower() != s[r].lower():
                return False
            
            # Recurse for the next pair of characters
            return check(l+1, r-1)
        
        # Start checking from both ends
        return check(l=0, r=len(s)-1)


# -------------- Boilerplate Codes ---------------
def runIterativeTest(test_suites: list[dict]):
    print("Running test for iterative approach")
    si = SolutionIter()
    for suite in test_suites:
        actual = si.isPalindrome(suite["input"])
        print(f"input: {suite['input']} = output: {actual}")
        assert actual == suite["expected"], f"expected: {suite['expected']}, got: {actual}"


def runRecursiveTest(test_suites: list[dict]):
    print("Running test for Recursive approach")
    sr = SolutionRecur()
    for suite in test_suites:
        actual = sr.isPalindrome(suite["input"])
        print(f"input: {suite['input']} = output: {actual}")
        assert actual == suite["expected"], f"expected: {suite['expected']}, got: {actual}"


def exec(test_suites: list[dict]):
    start = timeit.default_timer()
    runIterativeTest(test_suites)
    elapsed_time_ms = (timeit.default_timer() - start) * 1000
    print("All assertions passed in %0.3fms"% elapsed_time_ms)
    
    start = timeit.default_timer()
    runRecursiveTest(test_suites)
    elapsed_time_ms = (timeit.default_timer() - start) * 1000
    print("All assertions passed in %0.3fms"% elapsed_time_ms)
        

def main():
    inputs = [
        { "input": "Madam", "expected": True },
        { "input": "Racecar", "expected": True },
        { "input": "Raceacar", "expected": False },
        { "input": "A man, a plan, a canal: Panama", "expected": True },
        
    ]
    exec(inputs)

if __name__ == "__main__":
    main()
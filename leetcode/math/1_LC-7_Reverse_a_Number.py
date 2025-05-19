# https://leetcode.com/problems/reverse-integer/
MAX = 2147483647
MIN = -2147483648
class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        while x:
            last_digit = int(math.fmod(x, 10))
            
            # check upper limit of 32Bit Int value
            if (
                res > int(MAX/10) or 
                (res == int(MAX/10) and last_digit > math.fmod(MAX, 10))
            ):
                return 0
            
            # check lower limit of 32Bit Int value
            if (
                res < int(MIN/10) or 
                (res == int(MIN/10) and last_digit < math.fmod(MIN, 10))
            ):
                return 0

            res = (res * 10) + last_digit
            x = int(x/10)
            
        return res
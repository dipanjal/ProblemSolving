from math import fmod, pow
class Solution:
    def is_armstrong(self, n: int) -> bool:
        res = 0
        given_number = n
        while n:
            last_digit = int(fmod(n, 10))
            res += last_digit ** 3
            n = int(n / 10)
        print("Result ", res)
        return res == given_number

if __name__ == "__main__":
    s = Solution()
    assert s.is_armstrong(153) is True
    assert s.is_armstrong(370) is True
    assert s.is_armstrong(371) is True
    assert s.is_armstrong(407) is True
    assert s.is_armstrong(1634) is False

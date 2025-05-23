from math import sqrt
class Solution:
    def div_sum(self, x: int) -> int:
        sum = 0
        for i in range(1, x + 1):
            if x % i == 0:
                sum += i
        return sum
    
    def div_sum_optimized(self, x: int) -> int:
        sum = 0
        pivot_point = int(sqrt(x))
        for i in range(1, pivot_point + 1):
            if x % i == 0:
                div_2 = int(x / i)
                if i == div_2:
                    sum = sum + i
                else:
                    sum = sum + i + div_2
        return sum

if __name__ == "__main__":
    s = Solution()
    print(s.div_sum(16))
    print(s.div_sum_optimized(16))

    
from typing import List

class Solution:
    def get_min(self, nums: List[int]) -> int:
        curr_min = (2**31)-1
        for num in nums:
            curr_min = min(num, curr_min)
        return curr_min
    
    def get_max(self, nums: List[int]) -> int:
        curr_max = -(2**31)
        for num in nums:
            curr_max = max(num, curr_max)
        return curr_max
    
    def gcd(self, num1: int, num2: int) -> int:
        # Euclidian Algorithm
        while num1 > 0 and num2 > 0:
            if num1 > num2:
                num1 = num1 % num2
            else:
                num2 = num2 % num1
            
            return num2 if num1 == 0 else num1
    
    def findGCD(self, nums: List[int]) -> int:
        return self.gcd(
            num1=self.get_min(nums),
            num2=self.get_max(nums)
        )
    

if __name__ == "__main__":
    s = Solution()
    nums = [5,9,7,10,2]
    gcd = s.findGCD(nums)
    print(gcd)
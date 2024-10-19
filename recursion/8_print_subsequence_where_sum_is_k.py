# Print Subsequences where Sumation is K
# https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=8

# TC: O(2^N)
# SC: O(N) where n is the length of the array so the depth of the recursion tree
def printAllSubsequence(nums: list[int], k: int):
    def printSub(i, sub: list[int], sum):
        # [optimization]
        # since all the numbers are positive int
        # we can say it's unnecessary to try when the sum is already grater than k
        if sum > k:
            return

        # base case: as we crossed the last index,
        # we are done with making a subsequence of nums
        if i >= len(nums):
            # print(f"sub: {sub} | sum: {sum}")
            if sum == k:
                print(sub)
            return
        
        # first append current item from nums
        sub.append(nums[i])
        # add current number with the sum
        sum += nums[i]
        # following left path of the recursion tree to create subsequence
        # until i pointer crossed the last index
        printSub(i + 1, sub, sum)
        
        # now a left path is covered, time to remove current item
        sub.remove(nums[i])
        # subtract current number from the sum
        sum -= nums[i]
        # following right path of the recursion tree to create another subsequence
        # until i pointer crossed the last index
        printSub(i + 1, sub, sum)

    
    # starting from 0 index, empty subsequence array, zero sum
    printSub(0, [], 0)


# Print Any One Subsequence where Sumation is K
def printAnySubsequence(nums: list[int], k: int):
    def printSub(i, sub: list[int], sum):
        if sum > k:
            return False
        
        if i >= len(nums):
            if sum == k:
                print(f"sub: {sub} | sum: {sum}")
                return True
            return False
        
        # first append current item from nums
        sub.append(nums[i])
        # add current number with the sum
        sum += nums[i]
        # following left path of the recursion tree to create subsequence
        # until i pointer crossed the last index
        
        # isPrinted = printSub(i + 1, sub, sum)
        # if isPrinted:
        #     return isPrinted
        if printSub(i + 1, sub, sum):
            return True
        
        # now a left path is covered, time to remove current item
        sub.remove(nums[i])
        # subtract current number from the sum
        sum -= nums[i]
        # following right path of the recursion tree to create another subsequence
        # until i pointer crossed the last index
        
        # isPrinted = printSub(i + 1, sub, sum)
        # if isPrinted:
        #     return isPrinted
        if printSub(i + 1, sub, sum):
            return True
        
        # return false if none of these recursion call gives you the answere
        return False

    # starting from 0 index, empty subsequence array, zero sum
    printSub(0, [], 0)


if __name__ == "__main__":
    printAllSubsequence(nums=[1, 2, 1], k=2)
    printAnySubsequence(nums=[1, 2, 1], k=2)
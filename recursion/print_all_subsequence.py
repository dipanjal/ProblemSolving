def printAllSubsequence(nums: list[int]):
    def printSub(i, sub: list[int]):
        
        # base case: as we crossed the last index,
        # we are done with making a subsequence of nums
        if i >= len(nums):
            print(sub)
            return
    
        # first append current item from nums
        sub.append(nums[i])
        # following left path of the recursion tree to create subsequence
        # until i pointer crossed the last index
        printSub(i + 1, sub)
        
        # now a left path is covered, time to remove current item
        sub.remove(nums[i])
        # following right path of the recursion tree to create another subsequence
        # until i pointer crossed the last index
        printSub(i + 1, sub)

    
    # starting from 0 index and empty subsequence array
    printSub(0, [])
        
if __name__ == "__main__":
    printAllSubsequence(nums=[1, 2, 3])
# How many possible subsequences are there where the sum of the subsequence is K

# https://youtu.be/eQCS_v3bw0Q?feature=shared&t=1395
# For every index there are 2 possibilities (take | not take)
# The size of the array nums = n which is also the depth of the recursion tree

# so the Time Complexity = O(2^n) because we are making two calls for each element
# we are either including or excluding the current element in the subsequence
# this is the take and not take approach

# Space Complexity = O(n) where n is the depth of recursion tree

def countNumOfSubsequence(nums: list[int], k: int):
    # i = is the index of the current element in the nums array
    # sub = is a list that will store the subsequence, 
    # it will be used to print the subsequence nothing else, not required for the solution
    # sum = is the sum of the subsequence
    def count(i, sub: list[int], sum: int):
        # all numbers are positive, so we can say when the sum is already grater that K
        # that subsequence can never be the appropriate one
        # so it's better to terminate it
        if sum > k:
            return 0
        
        if i >= len(nums):
            if sum == k:
                print(f"sub: {sub} | sum: {sum}")
                return 1
            return 0
        
        # pick current number
        sub.append(nums[i])
        # add current number with sum
        sum += nums[i]
        # recurse
        l_count = count(i + 1, sub, sum)

        # or not pick the item | remove the current number from the subsequence
        sub.remove(nums[i])
        # subtract current number from the sum
        sum -= nums[i]
        # recurse
        r_count = count(i + 1, sub, sum)

        # return the total count of subsequences
        return l_count + r_count
    
    return count(0, [], 0)


if __name__ == "__main__":
    print(f"No of Subsequences: {countNumOfSubsequence(nums=[1, 2, 1], k=2)}")
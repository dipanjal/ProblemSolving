nums = [1, 2, 3, 4, 5, 6]

def swap(left, right):
    left_val = nums[left]
    nums[left] = nums[right]
    nums[right] = left_val

def reverse_iter():
    l, r = 0, len(nums) - 1
    while (l < r):
        swap(l, r)
        l += 1
        r -= 1

def reverse(i=0):
    # we are calculating the right index
    right_index = len(nums) - i - 1
    
    # base case | when left met or go beyond right pointer
    # unlike while loop we are checking a negative condition.
    # 1. when the array length is odd, both of the pointers can be at the middle (meeting each others)
    # 2. when the array length is even, left pointer can go beyond the left pointer
    if i >= right_index:
        return
    
    # swap
    swap(left=i, right=right_index)
    reverse(i + 1)

if __name__ == '__main__':
    print("----iterative approach-----")
    print(nums)
    reverse_iter()
    print("after reverse")
    print(nums)

    print("----recursive approach-----")
    print(nums)
    reverse()
    print("after reverse")
    print(nums)

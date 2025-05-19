class Solution:
    # bruteforce
    def GCD(self, n1, n2):
        gcd = 1
        # i = 1
        # while i < n1 and i < n2:
        #     if n1 % i == 0 and n2 % i == 0:
        #         gcd = i
        #     i += 1
        # can also automate it like this
        start = 1
        end = min(n1, n2) + 1 # adding plus 1 because we have started from 1
        for i in range(start, end):
            if n1 % i == 0 and n2 % i == 0:
                gcd = i
        return gcd
    

if __name__ == "__main__":
    s = Solution()
    assert s.GCD(9, 12) == 3
    assert s.GCD(4, 6) == 2
    assert s.GCD(9, 8) == 1
    print(s.GCD(9, 9))

    # n1 = 9 
    # n2 = 12
    # min_val = min(n1, n2)
    # gcd = 1
    # for i in range(1, min_val + 1):
    #     if n1 % i == 0 and n2 % i == 0:
    #         gcd = i

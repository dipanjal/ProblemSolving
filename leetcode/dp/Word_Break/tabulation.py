# Recursive bruteforce solution
# TC: O(n)
# SC: set: O(n) + memo: O(n^2)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)  # O(1)
        n = len(s)

        memo = [[False] * n for _ in range(n)]
        # start => col
        # end => row
        for start in range(n):
            memo[n-1][start] = s[start:n] in wordSet
        
        for end in range(n-2, -1, -1):
            for start in range(n):
                not_match = memo[end+1][start] # canBreak(start, end+1)
                match = False
                if s[start:end+1] in wordSet:
                    match = memo[end+1][end+1] # canBreak(start=end+1, end=end+1)
                memo[end][start] = not_match or match

        return memo[0][0]
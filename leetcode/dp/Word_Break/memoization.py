# Recursive bruteforce solution
# TC: O(n)
# SC: stack: O(n) + set: O(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)  # O(1)
        n = len(s)

        # unique combo: n * n -> O(n*n)
        # memo: [n] * [n] -> O(n*n)
        memo = [[-1] * n for _ in range(n)]

        def canBreak(start: int, end: int) -> bool:
            # is it an overlapping sub
            if memo[start][end] != -1:
                return memo[start][end]

            # base case
            if end == n-1:
                memo[start][end] = s[start:end+1] in wordSet
                return memo[start][end]
            
            # expanding the window
            not_match = canBreak(start, end+1)
            match = False
            if s[start:end+1] in wordSet:
                match = canBreak(start=end+1, end=end+1)
            
            memo[start][end] = not_match or match
            return memo[start][end]
        
        return canBreak(0, 0)
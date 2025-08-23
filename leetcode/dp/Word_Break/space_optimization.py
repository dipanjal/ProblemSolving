# Recursive bruteforce solution
# TC: O(n)
# SC: set: O(n) + memo: O(n) + O(n) ~ O(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)  # O(1)
        n = len(s)
        
        # start => col
        # end => row
        next_row = [False] * n
        for start in range(n):
            next_row[start] = s[start:n] in wordSet
        
        # end=3
        for end in range(n-2, -1, -1):
            curr = [False] * n
            for start in range(n):
                not_match = next_row[start]  # canBreak(start, end+1)
                match = False
                if s[start:end+1] in wordSet:
                    match = next_row[end+1]  # canBreak(start=end+1, end=end+1)
                curr[start] = not_match or match
            next_row = curr

        return next_row[0]
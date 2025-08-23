# Recursive bruteforce solution
# TC: O(2^n)
# SC: stack: O(n) + set: O(m) where m = number of words
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)

        maxLen = 0
        for word in wordSet:
            maxLen = max(maxLen, len(word))

        def canBreak(start: int, end: int) -> bool:
            if end == len(s) - 1:
                return s[start:end+1] in wordSet
            
            # exceeded the max window limit but we couldn't break
            if (end - start) + 1 > maxLen:
                return False

            
            not_match = canBreak(start, end+1)
            match = False
            if s[start:end+1] in wordSet:
                match = canBreak(start=end+1, end=end+1)
            return match or not_match
        
        return canBreak(0, 0)
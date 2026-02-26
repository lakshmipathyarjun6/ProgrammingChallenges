import numpy as np

class Solution: 
    def totalFruit(self, fruits: List[int]) -> int:
        uniqueCount = np.unique(fruits).size

        if uniqueCount <= 2:
            return len(fruits)

        totalTrees = len(fruits)

        maxSubsequenceLength = 0

        windowStart = 0
        windowEnd = 1

        while windowEnd < totalTrees:
            subsequence = fruits[windowStart:windowEnd+1]
            uniqueCount = np.unique(subsequence).size

            subsequenceLen = len(subsequence)

            if uniqueCount > 2:
                while np.unique(fruits[windowStart:windowEnd+1]).size > 2:
                    windowStart += 1

                subsequenceLen = len(fruits[windowStart:windowEnd+1])

            else:
                windowEnd += 1

            if subsequenceLen > maxSubsequenceLength:
                maxSubsequenceLength = subsequenceLen

        return maxSubsequenceLength

import math
import numpy as np

class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        glasses = np.zeros((100,100))

        rowIndex = 0
        leftoverFlow = poured
        excess = np.array([leftoverFlow])

        while leftoverFlow > 0:
            glassesInRow = rowIndex + 1
            glassesToFill = glasses[rowIndex,:glassesInRow]

            glassesToFill = excess
            cappedGlasses = np.clip(glassesToFill, 0, 1)
            glasses[rowIndex,:glassesInRow] = cappedGlasses

            if(rowIndex >= query_row):
                break

            excessInCurrentRow = glassesToFill - cappedGlasses

            halfExcess = excessInCurrentRow / 2
            excessInNextRowLeft = np.array(halfExcess.tolist() + [0])
            excessInNextRowRight = np.array([0] + halfExcess.tolist())

            excess = excessInNextRowLeft + excessInNextRowRight
            leftoverFlow = np.sum(excess)

            rowIndex += 1

        return glasses[query_row][query_glass]

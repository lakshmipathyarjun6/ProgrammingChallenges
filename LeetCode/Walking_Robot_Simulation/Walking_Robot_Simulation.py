import numpy as np

# Correct only, not time limit performant

class Solution:
    def checkForObstaclesAndClamp(self, currentPosition: List[int], proposedPosition: List[int], obstacles: List[List[int]]) -> List[int]:
        cp = np.array(currentPosition)
        pp = np.array(proposedPosition)

        dir = pp - cp

        obstacleCandidates = []

        for obs in obstacles:
            if dir[0] != 0 and obs[1] != cp[1]:
                continue
            elif dir[1] != 0 and obs[0] != cp[0]:
                continue
            elif dir[0] < 0 and obs[0] >= cp[0]:
                continue
            elif dir[0] > 0 and obs[0] <= cp[0]:
                continue
            elif dir[1] < 0 and obs[1] >= cp[1]:
                continue
            elif dir[1] > 0 and obs[1] <= cp[1]:
                continue
            elif dir[0] > 0 and obs[0] > (cp[0] + dir[0]):
                continue
            elif dir[1] > 0 and obs[1] > (cp[1] + dir[1]):
                continue
            elif dir[0] < 0 and obs[0] < (cp[0] + dir[0]):
                continue
            elif dir[1] < 0 and obs[1] < (cp[1] + dir[1]):
                continue
            obstacleCandidates.append(obs)

        if len(obstacleCandidates) == 0:
            return proposedPosition

        # Find closest obstacle
        closestObstacleDist = np.inf
        closestObstacle = [0,0]

        for obs in obstacleCandidates:
            op = np.array(obs)
            diff = np.linalg.norm(op - cp)

            if diff < closestObstacleDist:
                closestObstacle = obs
                closestObstacleDist = diff

        if closestObstacle == currentPosition:
            return proposedPosition
        
        clampPoint = np.array(closestObstacle) - dir / np.linalg.norm(dir)
        
        return clampPoint.tolist()

    def computePathEndpoint(self, currentPosition: List[int], currentDirection: List[int], command: int, obstacles: List[List[int]]) -> List[int]:
        dirMovement = np.array(currentDirection)
        proposedPosition = np.array(currentPosition) + command * dirMovement

        return self.checkForObstaclesAndClamp(currentPosition, proposedPosition.tolist(), obstacles)

    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:

        currentPosition = [0,0]
        currentDirection = [0,1]

        path = []

        for command in commands:
            path.append(currentPosition)

            if command == -2:
                cd = np.array(currentDirection)

                # Counter-clockwise rotation (90°)
                cd = np.array([-cd[1], cd[0]])
                currentDirection = cd.tolist()

            if command == -1:
                cd = np.array(currentDirection)

                # Counter-clockwise rotation (90°)
                cd = np.array([cd[1], -cd[0]])
                currentDirection = cd.tolist()

            if command > 0:
                currentPosition = self.computePathEndpoint(currentPosition, currentDirection, command, obstacles)

        path.append(currentPosition)

        maxDist = 0.0

        for pos in path:
            diff = pos[0]**2 + pos[1]**2

            if diff > maxDist:
                maxDist = diff

        return int(maxDist)

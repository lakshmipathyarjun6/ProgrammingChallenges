class State:
    def __init__(self):
        self.direction = 'N'
        self.location = (0,0)
    
    def __str__(self):
        return 'Location: ' + str(self.location) + ' Direction: ' + self.direction

    def update(self, instruction):
        if instruction == 'L':
            if self.direction == 'N':
                self.direction = 'W'
            elif self.direction == 'S':
                self.direction = 'E'
            elif self.direction == 'E':
                self.direction = 'N'
            elif self.direction == 'W':
                self.direction = 'S'
        elif instruction == 'R':
            if self.direction == 'N':
                self.direction = 'E'
            elif self.direction == 'S':
                self.direction = 'W'
            elif self.direction == 'E':
                self.direction = 'S'
            elif self.direction == 'W':
                self.direction = 'N'
        elif instruction == 'G':
            if self.direction == 'N':
                self.location = (self.location[0]+1,self.location[1])
            elif self.direction == 'S':
                self.location = (self.location[0]-1,self.location[1])
            elif self.direction == 'E':
                self.location = (self.location[0],self.location[1]+1)
            elif self.direction == 'W':
                self.location = (self.location[0],self.location[1]-1)
                
    def getResultVec():
        return self.location, self.direction

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        
        s = State()
        
        for instruction in instructions:
            s.update(instruction)
        
        noMovement = s.location[0] == 0 and s.location[1] == 0
        differentDirection = s.direction != 'N'
        
        result = noMovement or differentDirection
            
        return result
        
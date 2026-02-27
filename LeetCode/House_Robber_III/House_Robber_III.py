# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        elif root.left is None and root.right is None:
            root.bestSum = root.val
            return root.bestSum
        
        elif hasattr(root, "bestSum"):
            return root.bestSum
        
        else:
            excludePathSum = self.rob(root.left) + self.rob(root.right)

            leftleftGrandchild = root.left.left if root.left is not None else None
            leftrightGrandchild = root.left.right if root.left is not None else None

            rightleftGrandchild = root.right.left if root.right is not None else None
            rightrightGrandchild = root.right.right if root.right is not None else None

            includePathSum = root.val + self.rob(leftleftGrandchild) + self.rob(leftrightGrandchild) + self.rob(rightleftGrandchild) + self.rob(rightrightGrandchild)

            root.bestSum = max(excludePathSum, includePathSum)

            return root.bestSum

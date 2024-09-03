from collections import deque
from tree_utils import TreeNode, TreeBuilder

# Traversing Tree and Return the result as a List
class TreeTraversal:
    # A DFS function to print the tree in order (left-root-right)
    @classmethod
    def in_order(cls, root: TreeNode):
        result = []
        
        def traverse(node):
            if node:
                traverse(node.left)
                result.append(node.data)
                traverse(node.right)
        
        traverse(root)
        return result
    
    # A DFS function to print the tree in order (root-left-right)
    @classmethod
    def pre_order(cls, root: TreeNode):
        result = []
    
        def traverse(node):
            if node:
                result.append(node.data)
                traverse(node.left)
                traverse(node.right)
        
        traverse(root)
        return result
    
    # A DFS function to print the tree in order (left-right-root)
    @classmethod
    def post_order(cls, root: TreeNode):
        result = []

        def traverse(node):
            if node:
                traverse(node.left)
                traverse(node.right)
                result.append(node.data)

        traverse(root)
        return result

    
    @classmethod
    # BFS 
    def level_order(cls, root: TreeNode):
        if not root:
            return
        result = []
        # creating a queue with the root node
        queue = deque([root])
        while queue:
            node: TreeNode = queue.popleft()
            result.append(node.data)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return result


class Main:
    if __name__ == "__main__":
        input = [
                {"parent": 1, "left": 2, "right": 3},
                {"parent": 2, "left": 4, "right": 5},
                {"parent": 3, "left": 6, "right": 7}
            ]
        root = TreeBuilder(input).build()
        # print(root.data)
        print("In-order Traversal")
        result = TreeTraversal.in_order(root)
        print(result)
        print("Pre-order Travelsal")
        result = TreeTraversal.pre_order(root)
        print(result)
        print("Post-order Travelsal")
        result = TreeTraversal.post_order(root)
        print(result)
        print("Level-order Travelsal")
        result = TreeTraversal.level_order(root)
        print(result)


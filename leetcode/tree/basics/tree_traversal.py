from collections import deque

from leetcode.tree.basics.tree_utils import TreeBuilder, TreeNode


class TreeTraversal:
    # A DFS function to print the tree in order (left-root-right)
    @classmethod
    def in_order(cls, root: TreeNode):
        if root:
            cls.in_order(root.left)
            print(root.data, end=' ')
            cls.in_order(root.right)
    
    # A DFS function to print the tree in order (root-left-right)
    @classmethod
    def pre_order(cls, root: TreeNode):
        if root:
            print(root.data, end=" ")
            cls.pre_order(root.left)
            cls.pre_order(root.right)
    
    # A DFS function to print the tree in order (left-right-root)
    @classmethod
    def post_order(cls, root: TreeNode):
        if root:
            cls.post_order(root.left)
            cls.post_order(root.right)
            print(root.data, end=" ")

    
    @classmethod
    # BFS 
    def level_order(cls, root: TreeNode):
        if not root:
            return
        # creating a queue with the root node
        queue = deque([root])
        while queue:
            node: TreeNode = queue.popleft()
            print(node.data, end=" ")
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)


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
        TreeTraversal().in_order(root)
        print("")
        print("Pre-order Travelsal")
        TreeTraversal().pre_order(root)
        print("")
        print("Post-order Travelsal")
        TreeTraversal().post_order(root)
        print("")
        print("Level-order Travelsal")
        TreeTraversal().level_order(root)
        print("")


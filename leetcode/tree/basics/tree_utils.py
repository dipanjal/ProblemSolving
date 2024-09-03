class TreeNode:
    def __init__(self, data: int) -> None:
        self.data = data
        self.left = None
        self.right = None

class TreeBuilder:
    def __init__(self, treeMaps: dict) -> None:
        self.treeMaps = treeMaps
        
    
    def build(self) -> TreeNode:
        # Dictionary to store created nodes
        nodes = {}
        for entry in self.treeMaps:
            parent_data = entry["parent"]
            left_data = entry.get("left")
            right_data = entry.get("right")
            if parent_data and parent_data not in nodes:
                nodes[parent_data] = TreeNode(parent_data)
            if left_data and left_data not in nodes:
                nodes[left_data] = TreeNode(left_data)
            if right_data and right_data not in nodes:
                nodes[right_data] = TreeNode(right_data)
            
            nodes[parent_data].left = nodes[left_data]
            nodes[parent_data].right = nodes[right_data]

        
        return nodes[self.treeMaps[0]["parent"]]
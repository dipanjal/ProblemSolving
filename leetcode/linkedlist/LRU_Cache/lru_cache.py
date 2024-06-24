# Leetcode 146 | LRU Cache
# Difficulty: Medium
# Problem: https://leetcode.com/problems/lru-cache/description/
# Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/lru-cache/

class Node:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None

class DoublyLinkedList:
    def __init__(self):
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def remove(self, node: Node):
        prevNode = node.prev
        nextNode = node.next
        prevNode.next = nextNode
        nextNode.prev = prevNode
    
    def addBeforeTail(self, node: Node):
        nextNode = self.tail
        prevNode = self.tail.prev
        
        node.next = nextNode
        node.prev = prevNode
        
        prevNode.next = node
        nextNode.prev = node

    def removeAfterHead(self) -> Node:
        firstNode = self.head.next
        if firstNode == self.tail:
            return None
        self.remove(firstNode)
        return firstNode

    # Necessary if you run the code Locally
    def printList(self):
        current = self.head.next
        while current != self.tail:
            print(f"({current.key}, {current.val})", end=" <-> ")
            current = current.next
        print("TAIL")


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {}
        self.list = DoublyLinkedList()
    
    def getNode(self, key: int) -> Node:
        if key not in self.map:
            return None
        
        node = self.map[key]
        # move to the most recent position
        self.list.remove(node)
        self.list.addBeforeTail(node)
        return node

    def get(self, key: int) -> int:
        node = self.getNode(key)
        return node.val if node else -1
	
    def put(self, key: int, value: int):
        nodeExisted = self.getNode(key)
        if nodeExisted:
            # update node value
            nodeExisted.val = value
        else:
            self.writeInCache(key, value)
    
    def writeInCache(self, key, value):
        newNode = Node(key, value)
        self.map[key] = newNode
        self.list.addBeforeTail(newNode)
        
        if len(self.map) > self.capacity:
            self.evictLRU()
    
    def evictLRU(self):
        nodeRemoved = self.list.removeAfterHead()
        if nodeRemoved and nodeRemoved.key in self.map:
            del self.map[nodeRemoved.key]

    # Necessary if you run the code Locally
    def printCache(self):
        self.list.printList()

# Necessary if you run the code Locally
def main():
    # Test case
    cache = LRUCache(2)

    cache.put(1, 1)
    cache.printCache()  # Should display the cache

    cache.put(2, 2)
    cache.printCache()  # Should display the cache

    print(cache.get(1))  # Should return 1
    cache.printCache()  # Should display the cache

    cache.put(3, 3)
    cache.printCache()  # Should display the cache

    print(cache.get(2))  # Should return -1 (not found)
    cache.printCache()  # Should display the cache

    cache.put(4, 4)
    cache.printCache()  # Should display the cache

    print(cache.get(1))  # Should return -1 (not found)
    cache.printCache()  # Should display the cache

    print(cache.get(3))  # Should return 3
    cache.printCache()  # Should display the cache

    print(cache.get(4))  # Should return 4
    cache.printCache()  # Should display the cache

if __name__ == "__main__":
    main()

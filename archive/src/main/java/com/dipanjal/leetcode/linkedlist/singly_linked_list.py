# https://leetcode.com/problems/design-linked-list/description/
# solved singly linked list. Will solve double next


class ListNode:
    def __init__(self, val, next_node=None):
        self.val = val
        self.next = next_node


class MyLinkedList(object):
    def __init__(self):
        self.head = ListNode(-1)  # dummy node
        self.tail = self.head
        self.size = 0

    def get(self, index):
        # handling edge case
        if index < 0 or index >= self.size:
            return -1

        curr = self.head.next
        for _ in range(index):
            curr = curr.next
        return curr.val

    def addAtHead(self, val):
        self.addAtIndex(0, val)

    def addAtTail(self, val):
        # addAtIndex(self.size, val) was taking O(n)
        # Optimization: adding at tail is now O(1)
        self.tail.next = ListNode(val)
        self.tail = self.tail.next
        self.size += 1

    def addAtIndex(self, index, val):
        # tail = when the index is equal to the size, we can add to tail
        # but can not add when the index is more than the last or you can call it size
        if index > self.size:
            return

        # pointing to the dummy node
        # because to insert a new node, we need to stop at the predecessor node
        # basically, [prev -> next] will be [prev -> new_node -> the old next of prev]
        prev = self.head  # the dummy head
        for _ in range(index):
            prev = prev.next

        new_node = ListNode(val, prev.next)
        prev.next = new_node

        # eventually if the new node has no next node
        # we can call it tail of the linkedlist
        if not new_node.next:
            self.tail = new_node

        self.size += 1

    def deleteAtHead(self):
        self.deleteAtIndex(0)

    def deleteAtTail(self):
        # can not optimize this without double linked list.
        # because in single linked list it takes O(n) time
        # to reach the predecessor node of the tail
        self.deleteAtIndex(self.size - 1)

    def deleteAtIndex(self, index):
        if index < 0 or index >= self.size:
            return

        # same as insertion
        prev = self.head
        for _ in range(index):
            prev = prev.next

        node_to_delete = prev.next
        # in case we want to delete the tail where (index = size -1)
        if self.tail == node_to_delete:
            self.tail = prev

        # at this point the pred will be hopped wil to the next.next
        prev.next = prev.next.next
        self.size -= 1


def lc_runner(func_list: list, arg_list: list, exp_out_list: list) -> None:
    obj = MyLinkedList()
    if not len(func_list) == len(arg_list) == len(exp_out_list):
        raise Exception("Invalid args length")
    i = 1
    for fn_name, args, exp_res in zip(func_list, arg_list, exp_out_list):
        func = getattr(obj, fn_name)
        actual_res = func(*args)
        if exp_res != actual_res:
            print(f"execution: {i} -> {fn_name}({args}) -> actual: {actual_res}, exp: {exp_res}")
        i += 1


if __name__ == '__main__':
    # obj = MyLinkedList()
    # obj.addAtHead(5)
    # obj.addAtHead(8)
    # obj.addAtHead(6)
    # obj.addAtIndex(3, 9)
    # obj.addAtTail(10)
    # print(obj.get(4))

    lc_runner(
        func_list=["addAtHead", "addAtIndex", "addAtTail", "addAtTail", "addAtTail", "addAtIndex", "addAtTail",
                   "addAtHead", "deleteAtIndex", "deleteAtIndex", "deleteAtIndex", "addAtIndex", "addAtTail", "get",
                   "get", "addAtHead", "addAtTail", "addAtTail", "get", "addAtTail", "addAtTail", "deleteAtIndex",
                   "deleteAtIndex", "addAtHead", "addAtTail", "addAtIndex", "get", "addAtTail", "addAtIndex",
                   "addAtHead", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtTail", "addAtIndex", "addAtHead",
                   "addAtIndex", "addAtTail", "addAtHead", "addAtIndex", "addAtTail", "addAtHead", "deleteAtIndex",
                   "get", "addAtIndex", "get", "addAtIndex", "addAtTail", "addAtTail", "get", "deleteAtIndex", "get",
                   "addAtHead", "addAtTail", "addAtIndex", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail",
                   "addAtIndex", "deleteAtIndex", "addAtHead", "addAtHead", "addAtTail", "get", "addAtTail",
                   "addAtIndex", "addAtHead", "deleteAtIndex", "addAtHead", "deleteAtIndex", "get", "get", "addAtTail",
                   "addAtIndex", "get", "deleteAtIndex", "deleteAtIndex", "addAtHead", "addAtHead", "addAtIndex", "get",
                   "addAtTail", "addAtHead", "addAtIndex", "get", "addAtHead", "deleteAtIndex", "deleteAtIndex",
                   "deleteAtIndex", "addAtHead", "addAtTail", "get", "addAtHead", "addAtTail", "addAtHead", "addAtHead",
                   "deleteAtIndex", "get", "addAtHead"],
        arg_list=[[55], [1, 90], [51], [91], [12], [2, 72], [17], [82], [4], [7], [7], [5, 75], [54], [6], [2], [8],
                  [35], [36], [10], [40], [43], [12], [3], [78], [89], [3, 41], [10], [96], [5, 37], [51], [26],
                  [16, 91], [18], [11], [66], [22, 20], [44], [17, 16], [95], [2], [14, 2], [99], [51], [1], [11],
                  [22, 99], [20], [25, 42], [72], [45], [2], [4], [32], [55], [84], [32, 64], [26, 14], [30, 80], [88],
                  [51], [27, 71], [15], [8], [60], [37], [25], [96], [25, 53], [36], [8], [85], [42], [20], [34], [78],
                  [42, 76], [26], [30], [39], [27], [93], [19, 75], [8], [24], [32], [25, 98], [21], [95], [18], [45],
                  [24], [38], [8], [20], [83], [71], [78], [55], [29], [11], [84]],
        exp_out_list=[None, None, None, None, None, None, None, None, None, None, None, None, None, 12, 90, None,
                      None, None, 35, None, None, None, None, None, None, None, 54, None, None, None, None, None, 96,
                      None, None, None, None, None, None, None, None, None, None, None, 91, None, 43, None, None, None,
                      11, None, -1, None, None, None, None, None, None, None, None, None, None, None, None, 89, None,
                      None, None, None, None, None, 35, 20, None, None, 53, None, None, None, None, None, 51, None,
                      None, None, 12, None, None, None, None, None, None, 75, None, None, None, None, None, 8, None]

    )

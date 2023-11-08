# https://leetcode.com/problems/design-linked-list/description/
# solved with doubly linked list
# improved: deleteAtTail -> TC O(1)

class ListNode:
    def __init__(self, val, left_node=None, right_node=None):
        self.val = val
        self.prev = left_node
        self.next = right_node


class MyLinkedList(object):
    def __init__(self):
        self.left = ListNode(-1)  # dummy head
        self.right = ListNode(-1)  # dummy tail

        # initiate the dummy linking
        self.left.next = self.right
        self.right.prev = self.left

        self.size = 0

    def get(self, index):
        # handling edge case
        if index < 0 or index >= self.size:
            return -1

        curr = self.left.next
        for _ in range(index):
            curr = curr.next
        return curr.val

    def addAtHead(self, val):
        self.addAtIndex(0, val)

    def addAtTail(self, val):
        # addAtIndex(self.size, val) was taking O(n)
        # Optimization: adding at tail is now O(1)
        curr_right = self.right  # tail node
        curr_left = curr_right.prev

        self.__insertNode(left=curr_left, val=val, right=curr_right)

    def addAtIndex(self, index, val):
        if index > self.size:
            return

        if index == self.size:  # if we want to add right before the dummy tail
            self.addAtTail(val)
        else:
            curr_left = self.left  # head node
            for _ in range(index):
                curr_left = curr_left.next

            curr_right = curr_left.next

            self.__insertNode(left=curr_left, val=val, right=curr_right)

    def __insertNode(self, left, val, right) -> None:
        # create a new_node and link with the current left and right
        new_node = ListNode(val, left_node=left, right_node=right)

        # now update our curr_left and curr_right nodes with the new_node
        left.next = new_node
        right.prev = new_node

        # increment the size
        self.size += 1

    def deleteAtHead(self):
        self.deleteAtIndex(0)

    def deleteAtTail(self):
        # deletion in O(1) time
        # initialization
        node_to_delete = self.right.prev
        next_left = node_to_delete.prev

        self.__deleteNode(
            left=next_left,
            node=node_to_delete,
            right=self.right  # tail node
        )

    def deleteAtIndex(self, index):
        if index < 0 or index >= self.size:
            return

        if index == self.size - 1:  # want to delete right before the dummy tail
            self.deleteAtTail()
        else:
            # same as insertion
            curr_left = self.left
            for _ in range(index):
                curr_left = curr_left.next

            # initialization
            node_to_delete = curr_left.next
            next_right = node_to_delete.next

            self.__deleteNode(
                left=curr_left,
                node=node_to_delete,
                right=next_right
            )

    def __deleteNode(self, left, node, right) -> None:
        # swap the link
        left.next = right
        right.prev = left

        # cleanup orphan node
        node.prev = None
        node.next = None
        del node

        # decrement the size
        self.size -= 1


def lc_runner(func_list: list, arg_list: list, exp_out_list: list) -> None:
    obj = MyLinkedList()
    if not len(func_list) == len(arg_list):
        raise Exception("Invalid args length")
    if not len(func_list) == len(exp_out_list):
        raise Exception("Invalid outputs length")
    i = 1
    for fn_name, args, exp_res in zip(func_list, arg_list, exp_out_list):
        func = getattr(obj, fn_name)
        actual_res = func(*args)
        if exp_res != actual_res:
            print(f"execution: {i} -> {fn_name}({args}) -> actual: {actual_res}, exp: {exp_res}")
        i += 1


if __name__ == '__main__':
    obj = MyLinkedList()

    # lc_runner(
    #     func_list=[
    #         "addAtHead", "addAtHead", "addAtHead", "addAtIndex", "get", "get", "get", "get",
    #         "addAtTail", "get",
    #         "deleteAtIndex", "get", "get",
    #         "deleteAtHead", "get"
    #     ],
    #     arg_list=[
    #         [5], [8], [6], [3, 9], [0], [1], [2], [3],
    #         [20], [4],
    #         [4], [4], [3],
    #         [], [0]
    #     ],
    #     exp_out_list=[
    #         None, None, None, None, 6, 8, 5, 9,
    #         None, 20,
    #         None, -1, 9,
    #         None, 8
    #     ]
    # )

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
  

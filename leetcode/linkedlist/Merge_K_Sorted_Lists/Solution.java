class Solution {
    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        ListNode dummy = ListNode(-1, null);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = ListNode(list1.val, null);
                list1 = list1.next;
            } else {
                curr.next = ListNode(list2.val, null);
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        while (lists.size() < 1) {
            List<ListNode> mergedLists = new ArrayList<ListNode>();
            for (int i=0; i<lists.size(); i+2) {
                ListNode list1 = lists.get(i);
                ListNode list2 = (i + 1) < lists.size() ? lists.get(i + 1) : null;
                mergedLists.add(this.mergeTwoSortedList(list1, list2));
            }
            lists = mergedLists
        }
        return lists.get(0)
    }
}
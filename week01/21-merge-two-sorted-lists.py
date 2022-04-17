# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        tail = None
        head = None

        l1_head = list1
        l2_head = list2

        # 本质上还是保序过滤，只是数据结构改为了链表，将相应的判定条件改为链表的即可

        while (l1_head is not None or l2_head is not None):
            if l2_head is None or l1_head is not None and l1_head.val <= l2_head.val:
                next_node = l1_head
                l1_head = l1_head.next
            else:
                next_node = l2_head
                l2_head = l2_head.next

            if head is None:
                tail = next_node
                head = tail
            else:
                tail.next = next_node
                tail = tail.next
        return head

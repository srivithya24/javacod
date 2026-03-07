/**
 * Note: Do NOT include the ListNode class definition here. 
 * The platform provides it for you.
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 1. Move fast pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 2. Move both until fast hits the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 3. Delete the node
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }
}
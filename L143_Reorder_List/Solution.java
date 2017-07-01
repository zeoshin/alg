package L143_Reorder_List;

public class Solution {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfHead = slow.next;
        slow.next = null;
        // reverse second half
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = secondHalfHead;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr = head;
        head = head.next;
        boolean firstHalf = false;
        while (head != null && prev != null) {
            if (firstHalf) {
                curr.next = head;
                head = head.next;
                firstHalf = false;
            }
            else {
                curr.next = prev;
                prev = prev.next;
                firstHalf = true;
            }
            curr = curr.next;
        }
        if (head != null) curr.next = head;
        if (prev != null) curr.next = prev;
    }
	public static void main(String[] args) {
		ListNode N1 = new ListNode(5);
		N1.next = new ListNode(2);
		N1.next.next = new ListNode(3);
		N1.next.next.next = new ListNode(1);
		N1.next.next.next.next = new ListNode(0);


		ListNode temp = N1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
		reorderList(N1);
		temp = N1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}

package ReverseNodeK;

import ReverseNodeK.ListNode;

public class reverseNodeK {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        return helper(head, k, length);
    }
    public static ListNode helper(ListNode head, int k, int leftNum) {
        if (head == null || head.next == null || leftNum < k) return head;
        ListNode temp = head;
        ListNode next = null;
        ListNode curr = head;
        ListNode prev = null;
        int counter = k;
        while (counter > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter--;
        }
        temp.next = helper(next, k, leftNum - k);
        return prev;
    }
	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		N1.next = new ListNode(2);
		N1.next.next = new ListNode(3);
		N1.next.next.next = new ListNode(4);

		ListNode result = reverseKGroup(N1, 1);
		ListNode temp = result;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}

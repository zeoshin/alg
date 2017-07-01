package L360_Plus_One_Linked_List;

public class Solution {
	public static ListNode plusOne(ListNode head) {
		if (head == null) return head;
		head = reverse(head, 0);
		head = reverse(head, 1);
		return head;
	}
	public static ListNode reverse(ListNode head, int x) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		int carry = 0;
		int sum = 0;
		while (curr != null) {
			if(curr == head) sum = curr.val + x;
			else sum = curr.val + carry;
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr.val = sum % 10;
			carry = sum / 10;
			curr = next;
		}
		if (carry == 1) {
			ListNode newHead = new ListNode(1);
			newHead.next = prev;
			return newHead;
		}
		return prev;
	}
	public static void main(String[] args) {
		ListNode NA = new ListNode(5);
		//NA.next = new ListNode(0);
		//NA.next.next = new ListNode(9);
		//NA.next.next.next = new ListNode(0);

		ListNode result = plusOne(NA);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
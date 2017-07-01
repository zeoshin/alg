package ReverseRange;

import ReverseRange.ListNode;

public class reverseRange {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        int reverseNum = n - m + 1;
        ListNode curr = head;
        ListNode prev = null;
        int counter = m;
        while (counter > 1) {
            prev = curr;
            curr = curr.next;
            counter--;
        }
        // start reversing
        ListNode firstHalfTail = prev;
        prev = null;
        ListNode next = null;
        ListNode secondHalfTail = curr;
        while (reverseNum > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            reverseNum--;
        }
        
        if (firstHalfTail != null) firstHalfTail.next = prev;
        secondHalfTail.next = curr;
        
        if (m > 1) return head;
        else return prev;
    }
    
	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		N1.next = new ListNode(2);
		N1.next.next = new ListNode(3);
		N1.next.next.next = new ListNode(4);

		ListNode result = reverseBetween(N1, 2, 3);
		ListNode temp = result;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}

package SwapPair;

import java.util.Arrays;

public class SwapPair {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode nextPairHead = head.next.next;
        newHead.next = head;
        head.next = swapPairs(nextPairHead);
        return newHead;
    }
	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		N1.next = new ListNode(2);
		N1.next.next = new ListNode(3);
		N1.next.next.next = new ListNode(4);

		ListNode result = swapPairs(N1);
		ListNode temp = result;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}

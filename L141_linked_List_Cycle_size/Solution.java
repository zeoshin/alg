package L141_linked_List_Cycle_size;

import L141_linked_List_Cycle_size.ListNode;

public class Solution {
    public static int hasCycle(ListNode head) {
        if (head == null || head.next == null) return 0;
        int result = 0;
        ListNode slow = head;
        ListNode fast = head;
        boolean hasMet = false;
        while (fast != null && fast.next != null && fast.next.next != null) {
        	if (hasMet) {
        		slow = slow.next;
        		result++;
	            if (slow == fast) return result;
        	}
        	else {
	            slow = slow.next;
	            fast = fast.next.next;
	            if (slow == fast) hasMet = true;
        	}
        }
        return result;
    }
    
	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		N1.next = N2;
		ListNode N3  = new ListNode(3);
		N2.next = N3;
		ListNode N4 = new ListNode(4);
		N3.next = N4;
		//N4.next = N4;
		int result = hasCycle(N1);
		System.out.println("The cycle size is: " + result);
	}
}

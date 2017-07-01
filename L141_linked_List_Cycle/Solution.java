package L141_linked_List_Cycle;

import java.util.HashSet;

import L141_linked_List_Cycle.ListNode;

public class Solution {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        HashSet<ListNode> hash = new HashSet<ListNode>();
        while (head != null) {
        	if (hash.contains(head)) return true;
        	else hash.add(head);
        	head = head.next;
        }
        return false;
    }
    
	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		N1.next = N2;
		ListNode N3  = new ListNode(3);
		N2.next = N3;
		ListNode N4 = new ListNode(4);
		N3.next = N4;
		N2.next = N1;
		boolean result = hasCycle(N1);
		if (result) System.out.println("has cycle");
		else System.out.println("does not have cycle");
	}
}

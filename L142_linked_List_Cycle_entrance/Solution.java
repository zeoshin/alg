package L142_linked_List_Cycle_entrance;

import java.util.HashSet;

import L142_linked_List_Cycle_entrance.ListNode;

public class Solution {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
            	ListNode temp = head;
            	if (slow == head) return head;
            	while (temp != slow) {
            		temp = temp.next;
            		slow = slow.next;
            		if (temp == slow) return temp;
            	}
            }
        }
        return null;
    }
    
    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        HashSet<ListNode> hash = new HashSet<ListNode>();
        while (head != null) {
        	if (hash.contains(head)) return head;
        	else hash.add(head);
        	head = head.next;
        }
        return null;
    }
    
	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		N1.next = N2;
		ListNode N3  = new ListNode(3);
		N2.next = N3;
		ListNode N4 = new ListNode(4);
		N3.next = N4;
		N4.next = N2;
		ListNode result = detectCycle(N1);
		System.out.println("The entrance is: " + result);
	}
}

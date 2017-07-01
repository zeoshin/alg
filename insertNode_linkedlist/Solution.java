package insertNode_linkedlist;

import insertNode_linkedlist.ListNode;

public class Solution {
	public static ListNode insertNode(ListNode head, int target) {
		ListNode newNode = new ListNode(target);
		if (head == null) return newNode;
		if (newNode.val <= head.val) {
		newNode.next = head;
		return newNode;
		}
		else {
			ListNode curr = head;
			while (curr.next != null && curr.next.val < newNode.val) {
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next = newNode;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		N1.next = N2;
		ListNode N3  = new ListNode(3);
		N2.next = N3;
		ListNode N4 = new ListNode(6);
		N3.next = N4;
		ListNode temp = N1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
		ListNode result = insertNode(N1, 4);
		temp = result;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}

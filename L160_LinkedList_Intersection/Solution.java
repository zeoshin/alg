package L160_LinkedList_Intersection;

import L160_LinkedList_Intersection.ListNode;

public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;
        int nullCounter = 0;
        while (! (currA == null && nullCounter == 1)) {
            if (currA == currB && currA != null) return currA;
            if (currA == null) {
                nullCounter++;
                currA = headB;
            }
            else if (currB == null) {
                currB = headA;
            }
            else {
                currA = currA.next;
                currB = currB.next;
            }
        }
        return null;
    }
	public static void main(String[] args) {
		ListNode NA = new ListNode(1);
		NA.next = new ListNode(2);
		NA.next.next = new ListNode(3);
		NA.next.next.next = new ListNode(4);

		ListNode NB = new ListNode(1);
		NB.next = new ListNode(2);
		NB.next.next = new ListNode(3);
		//NB.next.next.next = NA.next;

		ListNode result = getIntersectionNode(NA, NB);
		System.out.println("The intersection node is: " + result);
	}
}

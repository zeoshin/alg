package L148_Sort_List;

import L148_Sort_List.ListNode;

public class Solution {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }
    public static ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode currLeft = leftHead;
        ListNode currRight = rightHead;
        ListNode result = null;
        ListNode currResult = null;
        if (leftHead.val < rightHead.val) {
        	result = currLeft;
        	currLeft = currLeft.next;
        }
        else {
        	result = currRight;
            currRight = currRight.next;

        }
        currResult = result;
        while (currLeft != null && currRight != null) {
            if (currLeft.val < currRight.val) {
                currResult.next = currLeft;
                currLeft = currLeft.next;
            }
            else {
                currResult.next = currRight;
                currRight = currRight.next;
            }
            currResult = currResult.next;
        }
        if (currLeft != null) currResult.next = currLeft;
        if (currRight != null) currResult.next = currRight;
        return result;
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
		ListNode result = sortList(N1);
		temp = result;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}
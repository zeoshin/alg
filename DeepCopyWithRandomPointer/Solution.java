package DeepCopyWithRandomPointer;

import java.util.HashMap;

public class Solution {
	public static ListNode DeepCopyWithRandomPointer(ListNode head) {
		if (head == null) return null;
		ListNode resultDummy = new ListNode(0);
		ListNode currOrig = head;
		ListNode prevResult = resultDummy;
		HashMap<ListNode, ListNode> hash = new HashMap<ListNode, ListNode>();
		while (currOrig != null) {
			ListNode newNode = new ListNode(currOrig.val);
			if (!hash.containsKey(currOrig)) {				
				prevResult.next = newNode;
				hash.put(currOrig, newNode);
			}
			else {
				prevResult.next = hash.get(currOrig);
			}
			if (currOrig.rand != null && !hash.containsKey(currOrig.rand)) {
				ListNode newRandNode = new ListNode(currOrig.rand.val);
				prevResult.next.rand = newRandNode;
				hash.put(currOrig.rand, newRandNode);
			}
			else if (currOrig.rand != null && hash.containsKey(currOrig.rand)) {
				prevResult.next.rand = hash.get(currOrig.rand);
			}
			prevResult = prevResult.next;
			currOrig = currOrig.next;
		}
		return resultDummy.next;
	}
	public static void main(String[] args) {
		
		System.out.println("Test case 0:");
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node0.rand = node2;
		node1.rand = node4;
		node2.rand = node2;
		node3.rand = node0;

		ListNode result = DeepCopyWithRandomPointer(node0);
		int i = 0;
		while(result != null) {
			System.out.print("Node " + i + " has value " + result.val + ", ");
			String randval = new String();
			if (result.rand != null) randval = Integer.toString(result.rand.val);
			else randval = "null";
			System.out.println("random node is node " + randval);
			i++;
			result = result.next;
		}
		
		System.out.println("Test case 1:");
		node0 = new ListNode(0);
		node0.rand = node0;

		result = DeepCopyWithRandomPointer(node0);
		i = 0;
		while(result != null) {
			System.out.print("Node " + i + " has value " + result.val + ", ");
			String randval = new String();
			if (result.rand != null) randval = Integer.toString(result.rand.val);
			else randval = "null";
			System.out.println("random node is node " + randval);
			i++;
			result = result.next;
		}
		
		System.out.println("Test case 2:");
		node0 = new ListNode(0);
		node1 = new ListNode(1);
		node0.next = node1;
		node0.rand = node1;
		node1.rand = node0;

		result = DeepCopyWithRandomPointer(node0);
		i = 0;
		while(result != null) {
			System.out.print("Node " + i + " has value " + result.val + ", ");
			String randval = new String();
			if (result.rand != null) randval = Integer.toString(result.rand.val);
			else randval = "null";
			System.out.println("random node is node " + randval);
			i++;
			result = result.next;
		}
	}
}

package DeepCopyWithRandomPointer;

public class ListNode {
	int val;
	ListNode next;
	ListNode rand;
	ListNode(int value) {
		next = null;
		rand = null;
		val = value;
	}
}

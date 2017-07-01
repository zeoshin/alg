package TreeToDLL;

public class Solution {

	public static TreeNode inOrder(TreeNode root) {
		if (root == null) return null;
		TreeNode[] prev = new TreeNode[]{null};
		TreeNode[] head = new TreeNode[]{null};
		inOrder(root, prev, head);
		return head[0];
	}
	private static void inOrder (TreeNode root, TreeNode[] prev, TreeNode[] head) {
		if (root == null) return;
		inOrder(root.left, prev, head);
		if (prev[0] == null) head[0] = root;
		else prev[0].right = root;
		root.left = prev[0];
		prev[0] = root;
		inOrder(root.right, prev, head);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(12);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(30);
		root.right.left = new TreeNode(36);
		
		TreeNode head = inOrder(root);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.right;
		}
	}
}

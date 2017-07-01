package ReconstructBinaryTree;

public class Solution {

	public static TreeNode Reconstruct(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) return null;
		return Reconstruct(pre, in, 0, 0, in.length - 1, in.length - 1);
	}
	
	public static TreeNode Reconstruct(int[] pre, int[] in, int preLeft, int inLeft, int preRight, int inRight) {
		if (inLeft == inRight) return new TreeNode(in[inLeft]);
		int idx = 0;
		for (int i = inLeft; i <= inRight; i++) {
			if (pre[preLeft] == in[i]) idx = i;
		}
		TreeNode newNode = new TreeNode(in[idx]);
		newNode.left = Reconstruct(pre, in, preLeft + 1, inLeft, preLeft + idx - inLeft, idx - 1);
		newNode.right = Reconstruct(pre, in, preLeft + idx - inLeft + 1, idx + 1, preRight, inRight);
		return newNode;
	}
	
	public static void inOrder(TreeNode root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}
	public static void main(String[] args) {
		int[] in = new int[]{3, 5, 16, 15, 18, 20, 23};
		int[] pre = new int[]{15, 5, 3, 16, 20, 18, 23};
		TreeNode root = Reconstruct(pre, in);
		inOrder(root);
	}
}

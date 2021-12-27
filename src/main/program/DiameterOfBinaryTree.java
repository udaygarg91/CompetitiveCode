package main.program;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class DiameterOfBinaryTree extends TreeNode {
	public int diameterOfBinaryTree(TreeNode root) {
		return diameterOfBTree(root).getValue() - 1;
	}

	void a() {
	}
	
	public DiameterOfBinaryTree() {
		System.out.println("aaa");
		// TODO Auto-generated constructor stub
	}

	static  {
		System.out.println("a");
	}

	public Entry<Integer, Integer> diameterOfBTree(TreeNode root) {
		if (root == null)
			return new SimpleEntry<>(0, 0);
		Entry<Integer, Integer> lst = diameterOfBTree(root.left);
		Entry<Integer, Integer> rst = diameterOfBTree(root.right);
		int h = 1 + Math.max(lst.getKey(), rst.getKey());
		int d = Math.max(1 + lst.getKey() + rst.getKey(), Math.max(lst.getValue(), rst.getValue()));
		return new SimpleEntry<>(h, d);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		TreeNode t = new DiameterOfBinaryTree();
	}

	public static int[] mergeArrays(int[] arr1, int[] arr2) {
		int ans[] = new int[arr1.length + arr2.length];
		int i = 0, j = 0, c = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				ans[c++] = arr1[i++];
			} else if (arr2[j] <= arr1[i]) {
				ans[c++] = arr2[j++];
			}
		}
		while (i < arr1.length) {
			ans[c++] = arr1[i++];
		}
		while (j < arr2.length) {
			ans[c++] = arr2[j++];
		}
		return ans;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
		System.out.println("aa");
	}

	TreeNode(int val) {
		this.val = val;
	}
	static  {
		System.out.println("b");
	}
	void a() {
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	

}

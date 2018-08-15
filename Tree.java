package com.ocp.ocptest;

import java.util.Scanner;

public class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	public boolean searchInTree(TreeNode root, int searchData) {
		int root_val;
		boolean left, right;
		if (root != null) {
			root_val = root.data;
			if (root_val == searchData)
				return true;
			left = searchInTree(root.left, searchData);
			if (left == true)
				return true;
			else {
				right = searchInTree(root.right, searchData);
				if (right == true)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new TreeNode(2);
		tree.root.left = new TreeNode(7);
		tree.root.left.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(9);
		tree.root.right.right.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(6);
		tree.root.left.right.left = new TreeNode(5);
		tree.root.left.right.right = new TreeNode(11);
		String input = "Y";
		Scanner sc = new Scanner(System.in);
		int number;
		do {
			System.out.print("Enter the element to search :");
			try {
				number = sc.nextInt();
				if (tree.searchInTree(tree.root, number))
					System.out.println("Number is present in tree");
				else
					System.out.println("Number is not present in tree");

			} catch (Exception e) {
				System.out.println("Please enter valid integer number");
				input = sc.next();
			}
			System.out.print("Press Y to continue with search or press any other charcter to exit:");
			input = sc.next();

		} while (input.equals("Y"));
	}

}

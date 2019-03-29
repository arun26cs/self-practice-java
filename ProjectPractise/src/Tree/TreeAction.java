package Tree;

import java.util.Scanner;

public class TreeAction {

	Node root;
	public static void main(String[] args) {
		TreeAction ta = new TreeAction();
		Scanner sc =new Scanner(System.in);
		String[] numString = sc.nextLine().split(" ");
		for(int i=0;i<numString.length;i++) {
			ta.root = ta.addNode(ta.root ,Integer.parseInt(numString[i]));
		}
		ta.InOrderTraversal(ta.root);
		ta.preOrderTraversal(ta.root);
		ta.postOrderTraversal(ta.root);
	}

	private void postOrderTraversal(Node root2) {
		if(root2==null) {
			return;
		}
		postOrderTraversal(root2.left);
		postOrderTraversal(root2.right);
		System.out.println("Post"+root2.a);
		
	}

	private void preOrderTraversal(Node root2) {
		if(root2==null) {
			return;
		}
		System.out.println("pre"+root2.a);
		preOrderTraversal(root2.left);
		preOrderTraversal(root2.right);
		
	}

	private void InOrderTraversal(Node root2) {
		if(root2==null) {
			return;
		}
		InOrderTraversal(root2.left);
		System.out.println(root2.a);
		InOrderTraversal(root2.right);
		
	}

	private Node addNode(Node root,int numberNode) {
		if(root==null) {
			return new Node(numberNode);
		}
		if(numberNode<root.a) {
			root.left = addNode(root.left,numberNode);
		}else if(numberNode>root.a) {
			root.right = addNode(root.right,numberNode);
		}else {
			return root;
		}
		return root;
		
	}
}
class Node{
	
	int a;
	Node right;
	Node left;
	public Node(int a) {
		this.a=a;
	}
}

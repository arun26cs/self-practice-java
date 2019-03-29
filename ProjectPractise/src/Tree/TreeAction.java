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
		//tree node deletion
		ta.root=ta.deleteNode(ta.root,15);
		ta.InOrderTraversal(ta.root);
		System.out.println("size"+ta.treeSize(ta.root));
		System.out.println("height"+ta.treeheight(ta.root));
	}

	private int treeheight(Node root2) {
		//height is max of the left or the right tree and a 1 added to the current position
		if(root2!=null) {
			return 1+Math.max(treeheight(root2.left),treeheight(root2.right));
		}
		return 0;
	}

	private int treeSize(Node root2) {
		//if null then 0
		//if not null then 1
		//finally 1+left+right
		 
		if(root2!=null) {
			return 1+treeSize(root2.left)+treeSize(root2.right);
		} 
		return 0;
	}

	private Node deleteNode(Node root2, int delNode) {
		// till end not found? return root2
		// current is just to make manipulation not touching root2
		//Node current=root2;
		if(root2==null) {
			return root2;
		}
		//find node
		//action on the find node
		if(delNode==root2.a) {
			if(root2.left==null && root2.right==null) {
				return null;
			}else if(root2.left!=null && root2.right!=null) {
				//case of 15 both left and right child is there
				//travel right tree of that node to get the min by left traversal
				//then delete that node
				Node tempNode=root2;
				Node minNode=findRightMin(root2.right);
				root2.right=deleteNode(root2.right,minNode.a);//very imp to place this here since before altering the node change since its mandatory to maintain the state of the tree nodes else two times 17 would be found and we would fall in loop always
				//apply new changes here
				root2=minNode;
				root2.left=tempNode.left;
				root2.right=tempNode.right;
				
				return root2;
			}else {
				return (root2.left==null)? root2.right: root2.left;
			}
		}
		//not found ? then travel again and again 
		if(delNode<root2.a) {
			root2.left=deleteNode(root2.left,delNode);
		}else if(delNode>root2.a) {
			root2.right=deleteNode(root2.right,delNode);
		} 
		return root2;
	}

	private Node findRightMin(Node root) {
		while(root.left!=null) {
			root=root.left;
		}
		return root;
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

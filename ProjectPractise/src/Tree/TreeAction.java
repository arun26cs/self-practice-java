package Tree;

import java.util.Scanner;
import java.util.Stack;
//common practise in a recursion
//they are stack wise events
//each stack has a return type and 
//we have to record the returntype by assigning the function to a variable that is compatible
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
		/*ta.root=ta.deleteAllTree(ta.root);
		ta.root=ta.mirrorTree(ta.root);
		ta.InOrderTraversal(ta.root);*/
		String paths =new String();
		ta.allPathFromRoot(ta.root,paths);
		//System.out.println(ta.LCAofTree(0,0));
		System.out.println(ta.isBST(ta.root));
	}

	

	private boolean isBST(Node root2) {
		
		if(root2==null||root2.left==null||root2.right==null) {
			return true;
		}
		boolean stat = false;
		if(root2.left.a<root2.a && root2.right.a>root2.a) {
			return true;
		}
		stat=isBST(root2.left);
		stat=isBST(root2.right);
		return stat; 
		
	}



	/*private int LCAofTree(int i, int j) {
		// get level order list
		// compare prev
		// take for first only
		return null;
	}
*/
	private void allPathFromRoot(Node root2,String paths) {
		// for the current stack take all path from passed parm and add new path
		// perform right side also same way
		if(root2==null) {
			System.out.println(paths);
			return;
		}
		if(root2!=null) {
			paths+=root2.a+" ";
			allPathFromRoot(root2.left,paths);
			allPathFromRoot(root2.right,paths);
		}
		
		
	}

	private Node mirrorTree(Node root2) {
		// go till last of the tree 
		// if null return null
		// if not null then root.left is root.right
		// temp will hold previous state of the root.left before assigning root.left = root.right
		// root.right= temp
		// its in one recursion stack then the modified stack is returned 
		
		if(root2!=null) {
			Node temp=root2.left;
			root2.left=mirrorTree(root2.right);
			root2.right=mirrorTree(temp);
			return root2;
		}
		return null;
	}

	private Node deleteAllTree(Node root2) {
		
		// postirder traversal
		// delete childrens before deleting parent
		// each stack items are returned as null as part of delete operation
		if(root2==null) {
			return null;
		}
		deleteAllTree(root2.left);
		deleteAllTree(root2.right);
		System.out.println("deleting: "+root2.a);
		return null;
		
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
		System.out.println("in: "+root2.a);
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

package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StringTree {

	TreeNode root;
	public static void main(String[] args) {
		StringTree st = new StringTree();
		st.root = st.StringRepOfTree(st.root,"4(2(3)(1(7)(5)))(6(5))");
		st.preOrder(st.root);
		st.levelorder(st.root);
		System.out.println("Height: "+st.treeHeight(st.root));
	}
	
	private int treeHeight(TreeNode root2) {
		if(root2==null) {
			return 0;
		}
		return 1+Math.max(treeHeight(root2.left), treeHeight(root2.right));
		
	}

	private void levelorder(TreeNode root2) {
		Queue<Character> levelQ = new LinkedList<Character>();
		levelQ.add(root2.nodename);
		levelQ.add(null);
		boolean goTraversal=true;
		while(goTraversal) {
			 if(levelQ.peek()==null) {
				 levelQ.remove();
				 levelQ.add(null);
				 System.out.println();
				 if(levelQ.peek()==null) {
					 goTraversal=false;
				 }
			 }
			 if(goTraversal) {
				 char front=levelQ.peek();
				 System.out.println(levelQ.remove());
				 TreeNode node=getNode(root2,front);
				 if(node.left!=null) {
					 levelQ.add(node.left.nodename);
				 }
				 if(node.right!=null){
					 levelQ.add(node.right.nodename);
				 }
			 }
			
			 
		}
		
	}

	private TreeNode getNode(TreeNode root2, char front) {
		if(root2==null) {
			return null;
		} 
		if(root2.nodename==front) {
			return root2;
		}else {
			TreeNode rootval = getNode(root2.left,front);//lhs is treenode type since the above if condition will return a node so we will catch and store it in the lhs
			if(rootval==null) {//if in left nothing found we will go to the right
				rootval=getNode(root2.right,front);
			}
			return rootval;
		}
		
	}

	private void preOrder(TreeNode root2) {
		// TODO Auto-generated method stub
		if(root2==null) {
			return;
		}
		System.out.println(root2.nodename+" ");
		preOrder(root2.left);
		preOrder(root2.right);
		
	}

	private TreeNode StringRepOfTree(TreeNode root,String stringTree) {
		Stack<Character> treeStack = new Stack<Character>(); 
		Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
		char[] stlets = stringTree.toCharArray();
		for(int i=stlets.length-1;i>=0;i--) {
			treeStack.push(stlets[i]); 
		}
		root=new TreeNode(treeStack.pop());
		treeNodeStack.push(root);
		while(!treeStack.isEmpty()) {
			char top = treeStack.pop();
			if(top=='(') {
				
			}else if(top==')') {
				TreeNode n1 = treeNodeStack.pop();
				TreeNode n2 = treeNodeStack.pop();
				if(n2.left==null) {
					n2.left=n1;
				}else {
					n2.right=n1;
				}
				treeNodeStack.push(n2);
			}else {
				treeNodeStack.push(new TreeNode(top));
			}
		} 
		return treeNodeStack.peek();
	}

}

class TreeNode{
	char nodename;
	TreeNode left;
	TreeNode right;
	public TreeNode(char nodename) {
		this.nodename = nodename;
	}
}
package Tree;

import java.util.Stack;

public class StringTree {

	TreeNode root;
	public static void main(String[] args) {
		StringTree st = new StringTree();
		st.root = st.StringRepOfTree(st.root,"4(2(3)(1))(6(5))");
		st.preOrder(st.root);
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
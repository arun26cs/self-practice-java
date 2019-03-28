import java.util.Scanner;

public class TreeHeight {

	TNode root;
	public static void main(String args[]) {
		 TreeHeight th = new TreeHeight();
		 Scanner sc = new Scanner(System.in);
		 int nodes = Integer.parseInt(sc.nextLine());
		 int i=0;
		 while(i<nodes) {
			 int value=Integer.parseInt(sc.nextLine());
			 th.root=th.createTree(th.root,value);
			 i++;
		 }
		 System.out.print("height of tree: "+th.calcHeight(th.root));
		 
	}
	private int calcHeight(TNode root) {
		int lheight,rheight,height;
		if(root==null) {
			return 0;
		}
		lheight=calcHeight(root.left);
		rheight=calcHeight(root.right);
		if(lheight>rheight) {
			height = lheight+1;
		}
		else {
			height= rheight+1;
		}
		return height;
	}
	private TNode createTree(TNode root,int value) {
		// TODO Auto-generated method stub
		if(root==null) {
			return new TNode(value);
		}
		if(value<root.val) {
			root.left=createTree(root.left, value);
		} else if(value>root.val) {
			root.right=createTree(root.right, value);
		} else {
			return root;
		}
		return root;
	}
}


class TNode{
	int val;
	public TNode(int val) {
		this.val = val;
	}
	TNode left;
	TNode right;
}
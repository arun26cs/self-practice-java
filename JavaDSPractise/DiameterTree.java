import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class DiameterTree {

	TrNode root;
	public static void main(String args[]) {
		DiameterTree dt = new DiameterTree();
		Scanner sc = new Scanner(System.in);
		int nodes=Integer.parseInt(sc.nextLine());
		int i=0;
		while(i<nodes) {
			int value = Integer.parseInt(sc.nextLine());
			dt.root = dt.createTree(dt.root,value);
			i++;
		}
		System.out.println(dt.findDiameter(dt.root));
	}
	private int findDiameter(TrNode root) {
		if(root==null) {
			return 0;
		}
		int lTreeHeight = height(root.left);
		int rTreeHeight = height(root.right);
		int diameter = lTreeHeight+rTreeHeight+1;
		int lTreeDiameter = findDiameter(root.left);
		int rTreeDiameter = findDiameter(root.right);
		return Math.max(diameter, Math.max(lTreeDiameter, rTreeDiameter));
	}
	
	private int height(TrNode root) {
		if(root==null) {
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		int h=0;
		if(lh>rh) {
			h=lh+1;
		}else {
			h=rh+1;
		}
		return h;
	}
	private TrNode createTree(TrNode root, int value) {
		if(root==null) {
			return new TrNode(value);
		}
		if(value<root.val) {
			root.left=createTree(root.left, value);
		}else if(value>root.val) {
			root.right=createTree(root.right, value);
		}else{
			return root;
		}
		return root;
		
	}
}

class TrNode{
	int val;
	TrNode left;
	TrNode right;
	public TrNode(int val) {
		this.val=val;
	}
}
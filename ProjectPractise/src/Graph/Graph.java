package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
//Vertex root;
ArrayList<Vertex> GraphDs = new ArrayList<>();
	public static void main(String args[]) {
		Graph gr = new Graph();
		gr.createNode("arun","kunju");
		gr.createNode("arun","raju");
		gr.createNode("arun","kiran");
		gr.createNode("arun","anie"); 
		gr.bfsTraversal(gr.GraphDs);
		//gr.bfsTraversalParent(gr.GraphDs);
		//dfs traversal
	}

	 

	private void bfsTraversal(ArrayList<Vertex> graphDs) {
		int nullTime=0;
		Iterator<Vertex> it = graphDs.iterator();
		Queue<Vertex> visitingNodses = new LinkedList<>();
		List<Vertex> visitedList = new ArrayList<>();
		visitingNodses.add(it.next());
		visitingNodses.add(null);
		while(!visitingNodses.isEmpty()&&nullTime<2) {
			Vertex cur = visitingNodses.remove();
			if(cur!=null&&notVisited(cur,visitedList)) {
				nullTime=0;
				visitedList.add(cur);
				visitingNodses.addAll(cur.adjList);
				System.out.println(cur.val);
			}else {
				nullTime++;
				visitingNodses.add(null);//when prev null is taken away add the new null as endpoint notification
			}
		}
		
	}

	private boolean notVisited(Vertex cur,List<Vertex> visitedList) {
		if(visitedList.contains(cur)) {
			return false;
		}
		return true;
	}

	private void createNode(String src, String dest) {
		//if(!GraphDs.isEmpty()) {
			Vertex srcVertex = nodePresent(src);
			Vertex destVertex ;
			if(srcVertex!=null) {
				Vertex destadjVertex = new Vertex(dest);
				srcVertex.adjList.add(destadjVertex);
				
			}else {
				srcVertex=new Vertex(src);
				srcVertex.adjList.add(new Vertex(dest));
				GraphDs.add(srcVertex);
			}
			
			destVertex = nodePresent(dest);
			if(destVertex!=null) {
				destVertex.adjList.add(srcVertex);
			}else {
				destVertex = new Vertex(dest);
				destVertex.adjList.add(srcVertex);
				GraphDs.add(destVertex);
			}
			
		//}
	}

	private Vertex nodePresent(String src) {
		Iterator<Vertex> it = GraphDs.iterator();
		while(it.hasNext()) {
			Vertex v = it.next();
			if(v.val.equals(src)) {
				return v;
			}
		}
		return null;
	}
}


class Vertex{
	
	String val;
	List<Vertex> adjList;
	public Vertex(String val){
		this.val=val;
		adjList=new LinkedList<>();
	}
}
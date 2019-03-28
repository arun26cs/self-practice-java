import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphDs {

	public static void main(String args[]) {
		Graph gr = new Graph();
		gr.addVertex("bob","arun");
		gr.addVertex("kiran","arun");
		gr.addVertex("bob","kiran");
		gr.addVertex("bob","anie");
		gr.addVertex("bob","kunju");
		
		//check vertex for each nodes create if not there or add if already there.
	}
}

class Graph{
	ArrayList<Vertex> graphDS;
	public Graph() {
		
		graphDS=new ArrayList<Vertex>();
		 
	}
	public void addVertex(String key, String value) {
		//check if key node is der
		//if there then - check value node is there
		//if not there - create the node - check value node
		//if value there then add value to adj nodelist and vice versa
		Vertex keyVertex;
		Vertex valueVertex;
		keyVertex=getNode(key);
		if(keyVertex!=null) {
			keyVertex.adjList.add(new Vertex(value));
		}
		else {
			keyVertex=new Vertex(key);
			keyVertex.adjList.add(new Vertex(value));
			graphDS.add(keyVertex);
		}
		valueVertex=getNode(value);
		if(valueVertex!=null) {
			valueVertex.adjList.add(new Vertex(key));//check if already the entry is there
		}else {
			valueVertex=new Vertex(key);
			valueVertex.adjList.add(new Vertex(value));
			graphDS.add(valueVertex);
		}
		 		
		
	}
	private Vertex getNode(String value) {
		//read graphDS to see if they value is there and return that object as vertex or null
		Iterator<Vertex> it = graphDS.iterator();
		while(it.hasNext()) {
			Vertex v = it.next();
			if(v.word.equalsIgnoreCase(value)) {
				return v;
			}
		}
		return null;
	}
 

	 
}

class Vertex{
	String word;
	LinkedList<Vertex> adjList;
	public Vertex(String word) {
		this.word = word;
		adjList=new LinkedList<Vertex>();
	}
	 
}
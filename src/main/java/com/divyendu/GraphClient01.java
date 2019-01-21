package com.divyendu;

import java.util.List;
import java.util.logging.Level;

import com.divyendu.exceptions.MyNullClassException;
import com.divyendu.logger.MyLogger;
import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.DepthFirstSearch;
import com.divyendu.undirectedgraph.tasks.paths.SearchPaths;

public class GraphClient01 {

	public static final int NUMBER_OF_VERTICES = 6;
	public static final int SOURCE = 4;
	public static final int DESTINATION = 0;
	
	public static void main(String[] args) {
		
		MyLogger myLogger =new MyLogger();
		//create an empty Undirected Graph with NUMBER_OF_VERTICES vertices
		UndirectedGraph udGraph = new UndirectedGraph(NUMBER_OF_VERTICES);
		//lets add edges
		udGraph.addEdge(0, 1); 
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 5);
		udGraph.addEdge(1, 2);
		udGraph.addEdge(2, 3);
		udGraph.addEdge(2, 4);
		udGraph.addEdge(3, 4);
		udGraph.addEdge(3, 5);
		
		/* Start of DFS path client*/
		try {
			SearchPaths dfsPathClient = new SearchPaths(udGraph, SOURCE,DepthFirstSearch.class);
			List<Integer> path = dfsPathClient.pathTo(DESTINATION);
			System.out.println("Path from "+SOURCE+" to "+DESTINATION+" is: ");
			System.out.print(SOURCE+" -> ");
			for(int vertex : path) {
				System.out.print(vertex+" -> ");
			}
			System.out.print(DESTINATION);
		}catch(MyNullClassException e) {
			myLogger.getLogger().log(Level.INFO, e.getMessage());
		}
	}

}

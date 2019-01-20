package com.divyendu.undirectedgraph.tasks.bfs;

import com.divyendu.logger.MyLogger;
import com.divyendu.undirectedgraph.UndirectedGraph;

import java.util.List;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.Collections;

public class BreadthFirstSearchPaths {

	//This is Has - A relationship between BreadthFirstSearchPaths & BreadthFirstSearch
	//It can't be Is - A relationship since BreadthFirstSearchPaths is not BreadthFirstSearch
	private BreadthFirstSearch bfsRunner;
	private MyLogger myLogger;	//Get instance to Logger
	
	public BreadthFirstSearchPaths(UndirectedGraph udGraph, int source) {
		myLogger = new MyLogger();
		/*Initialize the Breadth First Search instance to traverse the Graph
		* This will set values for visited[] and count in DepthFirstSearch class
		* Not performing null check on udGraph and range validation on source since this is already being performed in DepthFirstSearch()
		* and this its more DRY doing it in BreadthFirstSearch() since then we wouldn't have to do it in all the clients making use of
		* the BreadthFirstSearch API
		*/
		bfsRunner = new BreadthFirstSearch(udGraph, source);

	}
	
	/** 
	 * This method determines if there is a path from source to destination
	 * 
	 * @param destination 
	 * @return result boolean specifying whether path exists or not
	 * */
	public boolean hasPath(int destination) {
		assert destination >=0 && destination <= (bfsRunner.getMaxSize()-1) : "Please provide value of destination vertex in proper range";
		boolean result = false;
		if(bfsRunner != null) {
			result = bfsRunner.getVisitedForVertex(destination);
		}
		return result;
	}
	
	/** 
	 * This method returns the vertices in the path from source to destination
	 * 
	 * @param destination
	 * @return path
	 * */
	public List<Integer> pathTo(int destination){
		assert destination >=0 && destination <= (bfsRunner.getMaxSize()-1) : "Please provide value of destination vertex in proper range";
		int[] edgeTo = bfsRunner.getEdgeToArray();
		int sourceVertex = bfsRunner.getSourceVertex();
		List<Integer> path = new ArrayList<Integer>();
		if(!hasPath(destination)) {
			myLogger.getLogger().log(Level.INFO,"Path doesn't exist :(");
		}
		else {
			int secondLast = edgeTo[destination];
			while(sourceVertex != secondLast) {
				path.add(secondLast);
				secondLast = edgeTo[secondLast];
			}
		}
		Collections.reverse(path);
		return path;
	}
}

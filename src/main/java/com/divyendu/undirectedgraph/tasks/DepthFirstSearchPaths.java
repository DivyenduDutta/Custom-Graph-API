package com.divyendu.undirectedgraph.tasks;

import com.divyendu.undirectedgraph.UndirectedGraph;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DepthFirstSearchPaths {
	
	//This is Has - A relationship between DepthFirstSearchPaths & DepthFirstSearch
	//It can't be Is - A relationship since DepthFirstSearchPaths is not DepthFirstSearch
	private DepthFirstSearch dfsRunner;
	
	
	public DepthFirstSearchPaths(UndirectedGraph udGraph, int source) {
		/*Initialize the Depth First Search instance to traverse the Graph
		* This will set values for visited[] and count in DepthFirstSearch class
		* Not performing null check on udGraph and range validation on source since this is already being performed in DepthFirstSearch()
		* and this its more DRY doing it in DepthFirstSearch() since then we wouldn't have to do it in all the clients making use of
		* the DepthFirstSearch API
		*/
		dfsRunner = new DepthFirstSearch(udGraph, source);

	}
	
	/** 
	 * This method determines if there is a path from source to destination
	 * 
	 * @param destination 
	 * @return result boolean specifying whether path exists or not
	 * */
	public boolean hasPath(int destination) {
		assert destination >=0 && destination <= (dfsRunner.getMaxSize()-1) : "Please provide value of destination vertex in proper range";
		boolean result = false;
		if(dfsRunner != null) {
			result = dfsRunner.getVisitedForVertex(destination);
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
		assert destination >=0 && destination <= (dfsRunner.getMaxSize()-1) : "Please provide value of destination vertex in proper range";
		int[] edgeTo = dfsRunner.getEdgeToArray();
		int sourceVertex = dfsRunner.getSourceVertex();
		List<Integer> path = new ArrayList<Integer>();
		if(!hasPath(destination)) {
			System.out.println("Path doesn't exist :(");
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

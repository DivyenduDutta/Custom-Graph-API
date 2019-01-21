package com.divyendu.undirectedgraph.tasks.paths;

import java.util.List;

import com.divyendu.exceptions.MyNullClassException;
import com.divyendu.logger.MyLogger;

import java.util.logging.Level;
import java.util.ArrayList;
import java.util.Collections;

import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.factory.SearchPathsFactory;
import com.divyendu.undirectedgraph.tasks.iframes.SearchInterface;

/**
 * SearchPaths represents the API to traverse an undirected graph via algorithms like BFS and DFS
 * [Usage]: SearchPaths dfsPathClient = new SearchPaths(UndirectedGraph udGraph, int source, Class<T> searchPaths);
 * udGraph is the undirected graph, source is the source vertex in Undirected graph to start traversal,
 * searchPaths can be DepthFirstSearch.class/BreadthFirstSearch.class
 * 
 * [Methods]
 * boolean hasPath(int destination) - to determine if path exists in graph from source to destination
 * List<Integer> pathTo(int destination) - returns a list with path from source to destination.
 * 
 * @author divyendu
 *
 */
public class SearchPaths{
	
	//This is Has - A relationship between SearchPaths & BreadthFirstSearch/DepthFirstSearch
	//It can't be Is - A relationship since SearchPaths is not BreadthFirstSearch/DepthFirstSearch
	private SearchInterface searchRunner;
	private MyLogger myLogger;	//Get instance to Logger
	
	public <T extends SearchInterface> SearchPaths(UndirectedGraph udGraph, int source, Class<T> searchPaths) throws MyNullClassException{
		myLogger = new MyLogger();
		/*Initialize the Search instance to traverse the Graph
		* This will set values for visited[] and count in Search class
		* Not performing null check on udGraph and range validation on source since this is already being performed in corresponding search class
		* and this its more DRY doing it in the corr. search class since then we wouldn't have to do it in all the clients making use of
		* the Search API
		*/

		searchRunner = new SearchPathsFactory().create(searchPaths, udGraph, source);
		if(searchRunner == null) {
			throw new MyNullClassException("SearchPathsFactory couldnt create instance. Check class passed to create(). Class passed to create(): "+searchPaths.getName());
		}
	}

	/** 
	 * This method determines if there is a path from source to destination
	 * 
	 * @param destination 
	 * @return result boolean specifying whether path exists or not
	 * */
	public boolean hasPath(int destination) {
		assert destination >=0 && destination <= (searchRunner.getMaxSize()-1) : "Please provide value of destination vertex in proper range";
		boolean result = false;
		if(searchRunner != null) {
			result = searchRunner.getVisitedForVertex(destination);
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
		assert destination >=0 && destination <= (searchRunner.getMaxSize()-1) : "Please provide value of destination vertex in proper range";
		int[] edgeTo = searchRunner.getEdgeToArray();
		int sourceVertex = searchRunner.getSourceVertex();
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

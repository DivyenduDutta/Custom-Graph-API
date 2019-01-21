package com.divyendu.undirectedgraph.tasks.iframes;

/**
 * Interface to be implemented by all search classes like BreadthFirstSearch etc
 * Has following methods since its sole purpose is to be used in factory design pattern
 * These methods are declared in the interface to avoid errors in SearchPaths
 * 
 * @author divyendu
 *
 */
public interface SearchInterface {
	
	// Search class needs to have element maxSize for vertex validation purposes
	public int getMaxSize();
	
	// Search class needs to have getVisitedForVertex() to determine if vertex has been visited or not.
	public boolean getVisitedForVertex(int vertex);
	
	// Search class needs to have element edgeTo[] for vertex validation purposes
	//The edgeTo[] stores the second last vertex on the path from source to destination.
	public int[] getEdgeToArray();
	
	// Search class needs to have element source 
	public int getSourceVertex();
}

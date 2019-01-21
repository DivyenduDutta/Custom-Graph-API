package com.divyendu.undirectedgraph.tasks.factory;

import java.util.logging.Level;

import com.divyendu.logger.MyLogger;
import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.DepthFirstSearch;
import com.divyendu.undirectedgraph.tasks.bfs.BreadthFirstSearch;
import com.divyendu.undirectedgraph.tasks.iframes.SearchInterface;

/**
 * SearchPathsFactory is created to implement the factory design pattern to get an instance of the appropriate 
 * SearchPathsInterface implementation instance
 * 
 * @author divyendu
 *
 */
public final class SearchPathsFactory {
	private MyLogger myLogger = new MyLogger();
	
	public <T extends SearchInterface> SearchInterface create(Class<T> clazz,UndirectedGraph udGraph, int source) {
		myLogger.getLogger().log(Level.INFO,clazz.getName()+" is passed to create()");
		SearchInterface search =null;
		if(DepthFirstSearch.class.equals(clazz)) {
			search = new DepthFirstSearch(udGraph, source);
		} else if(BreadthFirstSearch.class.equals(clazz)) {
			search = new BreadthFirstSearch(udGraph, source);
		}
		return search;
	}
	
	//Another approach to do the above would be as below but this approach doesnt check for class passed to create
//	public Object create(Class clazz,UndirectedGraph udGraph, int source) {
//		Object object = null;
//		try {
//		Constructor<?> ctor = clazz.getConstructor();
//	    object = ctor.newInstance();
//		}catch(NoSuchMethodException e) {
//			e.printStackTrace();
//		}catch(InvocationTargetException | InstantiationException | IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return object;
//	}

}

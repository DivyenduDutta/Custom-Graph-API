package com.divyendu.queue;

import java.util.logging.Level;

import com.divyendu.logger.MyLogger;
import com.divyendu.node.Node;

/**
 * Custom Queue implementation for generic types via Linked List concept
 * 
 * @author divyendu
 *
 * @param <T>
 */
public class Queue<T> {
	//private Node<T> queueHead;
	private Node<T> queueFront;	//always points to the first element in queue
	private Node<T> queueTail;	//always points to the last element in queue
	private int maxQueueSize;
	private int currentQueueSize;
	private MyLogger myLogger;	//Get instance to Logger
	
	/**
	 * Default constructor - creates a queue with a header node
	 * 
	 * @param maxQueueSize - maximum number of elements in the queue
	 */
	public Queue(int maxQueueSize) {
		myLogger = new MyLogger();
		this.maxQueueSize = maxQueueSize;
		this.currentQueueSize = 0;
		//this.queueHead = new Node<T>();	//check in Node<T> implementation, default constructor creates an empty node pointing to itself - header node
		//Initially both front and tail point to null since queue is empty
		this.queueFront = null;
		this.queueTail = null;
		
	}
	
	/**
	 * This function inserts a new value in the queue if it isnt full
	 * 
	 * @param value - value to be inserted in the queue
	 * @return currQueueSize - the current size of the queue
	 */
	public int insertTail(T value) {
		int currQueueSize = getCurrentQueueSize();
		if(getCurrentQueueSize() == getMaxQueueSize()) {
			//Queue full - can't insert new value
			myLogger.getLogger().log(Level.INFO, "The queue is full: "+getCurrentQueueSize()+ " of "+getMaxQueueSize());
			return currQueueSize;
		}
		Node<T> tempNode = new Node<T>(value);
		if(getCurrentQueueSize() == 0) {	//no elements in queue
			queueFront = tempNode;
			queueTail = tempNode;
		}
		else {
			queueTail.setNextNode(tempNode);
			//tempNode.setPrevNode(queueTail);
			queueTail = tempNode; 
		}
		currentQueueSize += 1;
		currQueueSize = getCurrentQueueSize();
		return currQueueSize;
	}
	
	/**
	 * This function removes an element from the start of the queue only if its not empty
	 * 
	 * @return elementRemoved - value removed from Queue
	 */
	@SuppressWarnings("unchecked")
	public T removeHead() {
		T elementRemoved = (T)new Object();	//not a good way
		if(getCurrentQueueSize() == 0) { //No elements in queue - can't remove from queue
			myLogger.getLogger().log(Level.INFO, "The queue is empty - value returned by removeHead() may be wierd");
			myLogger.getLogger().log(Level.WARNING, "value returned by removeHead(): "+elementRemoved);
			return elementRemoved;
		}
		Node<T> toRemove = queueFront;
		elementRemoved = toRemove.getValue();
		myLogger.getLogger().log(Level.INFO, "Removing element with value: "+toRemove.getValue()+" from head of queue");
		queueFront = queueFront.getNextNode();
		currentQueueSize -= 1;
		
		
		return elementRemoved;
	}

	public int getCurrentQueueSize() {
		return currentQueueSize;
	}

	public int getMaxQueueSize() {
		return maxQueueSize;
	}
	
	
	
	public Node<T> getQueueFront() {
		return queueFront;
	}

	public Node<T> getQueueTail() {
		return queueTail;
	}

	@Override
	public String toString() {
		StringBuffer queue = new StringBuffer();
		if(getCurrentQueueSize() == 0) {
			queue.append("Empty queue");
			return queue.toString();
		}
		Node<T> curNode = queueFront;
		while(curNode != null) {
			queue.append(curNode.getValue()+"->");
			curNode = curNode.getNextNode();
		}
		return queue.toString();
	}
	
}

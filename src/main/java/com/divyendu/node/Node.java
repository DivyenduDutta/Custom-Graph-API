package com.divyendu.node;

/**
 * Custom Node with generic type data - To be used in Custom Queue implementation
 * 
 * @author divyendu
 *
 */
public class Node<T> {
	
	private T value;
	private Node<T> nextNode;
	
	/**
	 * Parameterised constructor which creates a node
	 * 
	 */
	public Node(T value) {
		this.value = value;
		this.nextNode = null;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	

	public Node<T> getNextNode() {
		return nextNode;
	}

	public T getValue() {
		return value;
	}
	
	
	
}

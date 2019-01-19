package com.divyendu;

import com.divyendu.queue.Queue;

public class QueueClient {
	
	private static final int MAX_QUEUE_SIZE_INT = 5;
	private static final int MAX_QUEUE_SIZE_CHAR = 6;
	
	public static void main(String[] args) {
		//Create an empty queue of Integers with capacity MAX_QUEUE_SIZE_INT
		Queue<Integer> queueClient = new Queue<Integer>(MAX_QUEUE_SIZE_INT);
		queueClient.insertTail(10);
		queueClient.insertTail(11);
		queueClient.insertTail(1);
		queueClient.insertTail(5);
		queueClient.insertTail(-1);
		queueClient.removeHead();
		queueClient.removeHead();
		queueClient.insertTail(-5);
		
		System.out.println("The queue contents are: "+queueClient);
		
		//Create an empty queue of characters with capacity MAX_QUEUE_SIZE_CHAR
		Queue<Character> queueClientChar = new Queue<Character>(MAX_QUEUE_SIZE_CHAR);
		queueClientChar.insertTail('a');
		queueClientChar.insertTail('A');
		queueClientChar.insertTail('B');
		queueClientChar.insertTail('c');
		queueClientChar.insertTail('d');
		queueClientChar.insertTail('d');
		queueClientChar.insertTail('d');	//making the queue full
		queueClientChar.removeHead();
		queueClientChar.removeHead();
		queueClientChar.insertTail('p');
		
		System.out.println("The queue contents are: "+queueClientChar);
	}

}

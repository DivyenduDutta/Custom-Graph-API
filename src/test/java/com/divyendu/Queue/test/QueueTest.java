package com.divyendu.Queue.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.divyendu.queue.Queue;

public class QueueTest {
	private static final int MAX_QUEUE_SIZE_INT = 5;
	private static final int MAX_QUEUE_SIZE_CHAR = 6;
	
	@Test
	public void addValues_int() {
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
		
		assertEquals(queueClient.getQueueFront().getValue(),new Integer(1));
	}
	
	@Test
	public void addValues_char() {
		//Create an empty queue of Characters with capacity MAX_QUEUE_SIZE_CHAR
		Queue<Character> queueClientChar = new Queue<Character>(MAX_QUEUE_SIZE_CHAR);
		queueClientChar.insertTail('a');
		queueClientChar.insertTail('A');
		queueClientChar.insertTail('B');
		queueClientChar.insertTail('c');
		queueClientChar.insertTail('d');
		queueClientChar.removeHead();
		queueClientChar.removeHead();
		queueClientChar.insertTail('p');
		
		assertEquals("Pass", queueClientChar.getQueueFront().getValue().toString(),"B");;
	}
}

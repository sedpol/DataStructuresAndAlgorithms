package tr.com.sedatpolat.datastructures.test.queue;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import tr.com.sedatpolat.datastructures.queue.Queue;
/**
 * 
 * @author sedpol
 *
 */
public class QueueTest {
	Queue<Integer> queue = null;
	
	@Before
	public void init () {
		queue = new Queue<Integer>();
		queue.enqueue(98);
		queue.enqueue(99);
		queue.enqueue(100);
		queue.enqueue(101);
	}
	
	@Test
	public void enqueueTest() {
		queue = new Queue<Integer>();
		queue.enqueue(98);
		queue.enqueue(99);
		queue.enqueue(100);
		queue.enqueue(101);
		
		assertEquals(98, queue.front().intValue());
		queue.enqueue(102);
		assertEquals(98, queue.front().intValue());
		assertEquals(102, queue.rear().intValue());
	}
	
	@Test
	public void dequeueTest() {
		queue = new Queue<Integer>();
		queue.enqueue(98);
		queue.enqueue(99);
		queue.enqueue(100);
		queue.enqueue(101);
		
		assertEquals(98, queue.front().intValue());
		assertEquals(101, queue.rear().intValue());

		queue.enqueue(700);
		queue.enqueue(999);
		queue.dequeue();
		queue.dequeue();
		assertEquals(100, queue.front().intValue());
		assertEquals(999, queue.rear().intValue());
	}
	
	@Test(expected = EmptyStackException.class)
	public void emptyStackDequeueTest () {
		Queue<Integer> stack = new Queue<Integer>();
		stack.dequeue();
	}
	
}

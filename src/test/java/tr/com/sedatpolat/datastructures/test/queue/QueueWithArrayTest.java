package tr.com.sedatpolat.datastructures.test.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tr.com.sedatpolat.datastructures.queue.QueueWithArray;

/**
 * 
 * @author sedpol
 *
 */
public class QueueWithArrayTest {
	QueueWithArray stack = null;
	
	private void init () {
		stack = new QueueWithArray(10);
		stack.enqueue(98);
		stack.enqueue(99);
		stack.enqueue(100);
		stack.enqueue(101);
	}
	
	@Test
	public void dequeueTest() {
		init();
		
		stack.dequeue(); // removes 101
		assertEquals(99, stack.front());
		assertEquals(101, stack.rear());
		stack.dequeue();
		assertEquals(100, stack.front());
		assertEquals(101, stack.rear());
	}

	@Test
	public void enqueueTest() {
		init();
		
		assertEquals(98, stack.front());
		stack.enqueue(102);
		assertEquals(98, stack.front());
		assertEquals(102, stack.rear());
	}
	
	@Test(expected = RuntimeException.class)
	public void emptyQueueEnqueueTest () {
		QueueWithArray stack = new QueueWithArray(10);
		for (int i = 0; i < 11; i++) {
			stack.enqueue(i);
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void emptyQueueDequeueTest () {
		QueueWithArray stack = new QueueWithArray(10);
		stack.dequeue();
	}
	
}

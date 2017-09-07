package tr.com.sedatpolat.datastructures.test.stack;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;

import tr.com.sedatpolat.datastructures.stack.StackWithArray;

/**
 * 
 * @author sedpol
 *
 */
public class StackWithArrayTest {

	@Test
	public void pushTest() {
		
		StackWithArray<Integer> stack = new StackWithArray<Integer>(new Integer [100]);
		stack.push(100);
		assertEquals(100, stack.peek().intValue());
		stack.push(99);
		assertEquals(99, stack.peek().intValue());

	}
	
	@Test
	public void popTest() {
		
		StackWithArray<Integer> stack = new StackWithArray<>(new Integer [100]);
		stack.push(100);
		stack.push(90);
		
		stack.pop();
		assertEquals(100, stack.peek().intValue());

		stack.push(999);
		stack.push(700);
		stack.pop();
		assertEquals(999, stack.peek().intValue());
	}
	
	@Test(expected = EmptyStackException.class)
	public void emptyStackPopTest () {
		StackWithArray<Integer> stack = new StackWithArray<Integer>(new Integer [100]);
		stack.pop();
	}
	
	@Test(expected = EmptyStackException.class)
	public void emptyStackPeekTest () {
		StackWithArray<Integer> stack = new StackWithArray<Integer>(new Integer [100]);
		stack.peek();
	}
	
	@Test (expected = StackOverflowError.class)
	public void overFlowPushTest () {
		StackWithArray<Integer> stack = new StackWithArray<Integer>(new Integer [1004]);
		for (int i = 0; i < 1005; i++) {
			stack.push(i);
		}
	}
}

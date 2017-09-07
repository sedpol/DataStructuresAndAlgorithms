package tr.com.sedatpolat.datastructures.test.stack;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;

import tr.com.sedatpolat.datastructures.stack.Stack;
/**
 * 
 * @author sedpol
 *
 */
public class StackTest {

	@Test
	public void pushTest() {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(100);
		assertEquals(100, stack.peek().intValue());
		stack.push(99);
		assertEquals(99, stack.peek().intValue());

	}
	
	@Test
	public void popTest() {
		
		Stack<Integer> stack = new Stack<Integer>();
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
		Stack<Integer> stack = new Stack<Integer>();
		stack.pop();
	}
	
}

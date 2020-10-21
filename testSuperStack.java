
public class testSuperStack {

	void testSuperStack() {
		fail("Not yet implemented");
	}

	void testIsEmpty() {
		SuperStack<Integer> stack = new SuperSTack<>(1);
		boolean result = stack.isEmpty();
		assertTrue(result);

		stack.push(new Integer(0));
		result = stack.isEmpty();
		assertFalse(result);
	}

	void testIsFull() {
		fail("Not yest implemented");
	}

}

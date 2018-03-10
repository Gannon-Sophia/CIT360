package JUnitSampleTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitSquareTest {

	@Test
	void test() {
		JUnitSample test = new JUnitSample();
		int output = test.square(5);
		assertEquals(25, output);
		
	}

}

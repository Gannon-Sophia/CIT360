package JUnitSampleTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitCountTest {

	@Test
	void test() {
		JUnitSample test = new JUnitSample();
		int output = test.countA("alphabet");
		assertEquals(2, output);
	}
	
}

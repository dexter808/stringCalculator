package stringCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	StringCalculator stringCalculator;
	@BeforeEach
	void init() {
		stringCalculator=new StringCalculator();
	}
	@Test
	@DisplayName("Testing For Upto 2 numbers(Part 1)")
	void testAddForUpto2numbers() {
		assertEquals(0, stringCalculator.Add(""),"Sum of empty string should be 0");
		assertEquals(12, stringCalculator.Add("12"),"Sum of 1 element should be the same as that element");
		assertEquals(7, stringCalculator.Add("4,3"),"Sum of 3,4 = 7");
	}

}
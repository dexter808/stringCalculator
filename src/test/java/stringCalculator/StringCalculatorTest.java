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
	void testAddForUpto2numbers() throws Exception {
		assertEquals(0, stringCalculator.Add(""),"Sum of empty string should be 0");
		assertEquals(12, stringCalculator.Add("12"),"Sum of 1 element should be the same as that element");
		assertEquals(7, stringCalculator.Add("4,3"),"Sum of 3,4 = 7");
	}
	@Test
	@DisplayName("Testing for unknown aount of numbers")
	void testAddForUnknownAmtOfNum() throws Exception {
		assertEquals(15, stringCalculator.Add("1,2,,3,4,5"),"Adding unknown amount of numbers");
		assertEquals(3, stringCalculator.Add("1,1,1"));
	}
	
	@Test
	@DisplayName("Testing for line change as a delimeter")
	void testAddWithLineChangeAlsoAsDelimeter() throws Exception {
		assertEquals(3, stringCalculator.Add("2,\n1"));
		assertEquals(5, stringCalculator.Add("3,\n1,1,"));
	}
	@Test
	@DisplayName("Testing for custom delimeters")
	void testAddForCustomDelimiter() throws Exception {
		assertEquals(6, stringCalculator.Add("//;\n4;2"));
		assertEquals(12, stringCalculator.Add("//!\n4!8"));
	}
	@Test
	@DisplayName("Testing for negative numbers not allowed")
	void testAddForNegativeNumbers() throws Exception{
		assertThrows(Exception.class, () -> stringCalculator.Add("1,2,3\n,-6"),"Expected to throw exception for negative numbers but it did not");
		assertThrows(Exception.class, () -> stringCalculator.Add("-3"));
	}
	@Test
	@DisplayName("Testing for negative numbers not allowed with a specific message including all negatives")
	void testAddForMultipleNegativeNumbers() throws Exception{
		Throwable exc=assertThrows(Exception.class, () -> stringCalculator.Add("3,2\n-2,6\n-8"));
		assertEquals(exc.getMessage(), "negatives not allowed : -2 -8");
	}
	@Test
	@DisplayName("Testing for adding numbers greater than 1000")
	void testAddForNumbersGreaterThanThousand() throws Exception{
		assertEquals(7, stringCalculator.Add("3,4\n1001"),"Expected to ignore numbers grater than 1000");
	}
	@Test
	@DisplayName("Testing for any delimiter length")
	void testAddForAnyDelimiterLength() throws Exception{
		assertEquals(6, stringCalculator.Add("//[****]\n1****2****3"));
	}
}

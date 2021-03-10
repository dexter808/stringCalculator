package stringCalculator;

public class StringCalculator {
	public int Add(String numbers) {
		numbers=numbers.trim();
		String num[]=numbers.split(",",0);
		if(numbers.length()==0)
			return 0;
		if(num.length==1)
			return Integer.parseInt(num[0]);
		return Integer.parseInt(num[0])+Integer.parseInt(num[1]);
	}
}

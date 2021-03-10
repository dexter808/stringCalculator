package stringCalculator;

public class StringCalculator {
	public int Add(String numbers) {
		numbers=numbers.trim();
		String num[]=numbers.split(",",0);
		if(numbers.length()==0)
			return 0;
		if(num.length==1)
			return Integer.parseInt(num[0]);
		int sum=0;
		for(int i=0;i<num.length;i++)
			if(num[i].length()!=0)
			sum+=Integer.parseInt(num[i]);
		return sum;
	}
}

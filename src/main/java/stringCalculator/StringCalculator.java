package stringCalculator;

public class StringCalculator {
	public int Add(String numbers) {
		numbers=numbers.trim();
		String num[]=numbers.split(",|\n",0);
		int sum=0;
		for(int i=0;i<num.length;i++)
			if(num[i].length()!=0)
			sum+=Integer.parseInt(num[i]);
		return sum;
	}
}

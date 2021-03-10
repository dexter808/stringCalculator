package stringCalculator;

public class StringCalculator {
	public int Add(String numbers) throws Exception{
		numbers=numbers.trim();
		String delimiter=",|\n";
		if(numbers.length()!=0 && numbers.charAt(0)=='/')
		{
			String number[]=numbers.split("\n",2);
			delimiter=number[0].substring(2);
			numbers=number[1];
		}
		String num[]=numbers.split(delimiter,0);
		boolean hasNegatives=false;
		String messageForNegativeNumbers="negatives not allowed :";
		int sum=0;
		for(int i=0;i<num.length;i++)
			if(num[i].length()!=0)
			{
				int n=Integer.parseInt(num[i]);
				if(n<0)
				{
					hasNegatives=true;
					messageForNegativeNumbers+=" "+n;
				}
				sum+=n;
			}
		if(hasNegatives)
		{
			throw new Exception(messageForNegativeNumbers);
		}
		return sum;
	}
}

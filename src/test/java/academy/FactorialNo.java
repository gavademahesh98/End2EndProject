package academy;

import org.testng.annotations.Test;

public class FactorialNo {
	@Test
	public void factorial() {
		int a=6;
		int b=1;
		for(int i=6;i>0;i--) {
			b=b*i;
		}
		System.out.println(b);
	}
	@Test
	public void Palindrome() {
		String c="racecar";
		String d="";
		for(int i=c.length()-1;i>=0;i--) {
			d=d+c.charAt(i);
		}
		if(d.equals(c))System.out.println("String C is Palindrome"); 
		else System.out.println("String C is Not Palindrome");
	}

}

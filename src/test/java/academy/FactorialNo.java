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

}
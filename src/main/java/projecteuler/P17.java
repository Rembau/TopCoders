package projecteuler;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" 
when writing out numbers is in compliance with British usage.
 * @author Rembau
 *
 */
public class P17 {
	public static void func(){
		int nc[] = new int[]{0,3,3,5,4,4,3,5,5,4,3,6,6,8,8,7,7,9,8,8};
		int nc_[] = new int[]{0,0,6,6,5,5,5,7,6,6};
		int c=0;
		for (int i = 1; i <= 1000; i++) {
			int r=c;
			if(i<20){
				c+=nc[i];
			} else if(i<100){
				c+=nc_[i/10];
				c+=nc[i%10];
			} else if(i<1000){
				c+=10;
				c+=nc[i/100];
				int x=i%100;
				if(x==0){
					c-=3;
				} else if(x<20){
					c+=nc[x];
				} else {
					c+=nc_[x/10];
					c+=nc[x%10];
				}
			} else{
				c+=11;
			}
			System.out.println(i+" "+(c-r));
		}
		System.out.println(c);
	}
	public static void main(String[] args) {
		func();
	}

}

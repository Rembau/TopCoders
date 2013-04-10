package projecteuler;

public class P44 {
/**
 * Pentagonal numbers are generated by the formula, Pn=n(3n-1)/2. The first ten pentagonal numbers are:
 * 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
 * 
 * It can be seen that P(4) + P(7) = 22 + 70 = 92 = P(8). However, their difference, 70 - 22 = 48, is not pentagonal.
 * Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are
 * pentagonal and D = |Pk - Pj| is minimised; what is the value of D?
 */
	public static void func(){
		long min=Integer.MAX_VALUE;
		long p[] = new long[10000];
		for (long i = 1; i < p.length; i++) {
			p[(int) i] = i*(3*i-1)/2;
			//System.out.println(i+" "+p[(int) i]);
		}
		for (int i = 1; i < p.length-1; i++) {
			for (int j = i+1; j < p.length; j++) {
				long d = p[j]-p[i];
				if(d<min && isPenta(d) && isPenta(p[j]+p[i])){
					min=d;
					System.out.println("d= "+d);
					continue;
				}
				if(d>=min){
					break;
				}
			}
		}
		System.out.println(min);
	}
	static boolean isPenta(long num){
	     float d=1+24*num;
	     float n=(float) ((Math.sqrt(d)+1)/6);
	     if((int)n!=n)
	      return false;
	     return true;
	    }
	public static boolean binarySearch(long p[],long n){
		//System.out.println(n);
		int t=p.length;
		int l=0;
		int index;
		while(t>l){
			index=(t+l)/2;
			//System.out.println(t+" "+l+" "+index);
			if(n==p[index]){
				return true;
			} else if(n>p[index]){
				l=index+1;
			} else if(n<p[index]){
				t=index;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		/*long p[] = new long[100000];
		for (long i = 1; i < p.length; i++) {
			p[(int) i] = i*(3*i-1)/2;
			System.out.println(i+" "+p[(int) i]);
		}
		System.out.println(binarySearch(p, 9006*(3*9006-1)/2));*/
		func();
	}

}

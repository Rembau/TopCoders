package projecteuler;

public class P2 {
	static int a = 1;
	static int b = 2;
	static int sum=2;
	public static void count() {
		while (true) {
			if (a < b) {
				a += b;
				if(a>=4000000){
					break;
				}
				if(a%2==0){
					sum+=a;
					System.out.println(a);
				}
			} else {
				b += a;
				if(b>=4000000){
					break;
				}
				if(b%2==0){
					sum+=b;
					System.out.println(b);
				}
			}
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		count();
	}

}

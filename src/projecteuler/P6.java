package projecteuler;

public class P6 {
	public static void func(){
		int a=0;
		int b=0;
		for (int i = 1; i <= 100; i++) {
			a+=i*i;
		}
		System.out.println(a);
		for (int i = 1; i <=100; i++) {
			b+=i;
		}
		System.out.println(b=b*b);
		
		System.out.println(b-a);
	}
	public static void func_(){
		//和的平方 (1+n)*n/2 * (1+n)*n/2
		//平方的和1/6(2*n*n*n+3*n*n+n)=n/6(2n+1)(n+1)
	}
	public static void main(String[] args) {
		func();
	}

}

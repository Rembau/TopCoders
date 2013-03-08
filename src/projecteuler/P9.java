package projecteuler;

public class P9 {
	/**
	 * 有更好的方法，查看projecteuler.com
	 */
	public static void func(){
		for (int i = 1; i <= 1000; i++) {
			for (int j = i+1; j <= 1000; j++) {
				int k=1000-i-j;
				if(i*i+j*j==k*k){
					System.out.println(i+" "+j+" "+k);
					System.out.println(i*j*k);
				}
			}
		}
	}
	public static void main(String[] args) {
		func();
	}

}

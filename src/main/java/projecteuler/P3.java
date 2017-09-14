package projecteuler;

public class P3 {
	public static void func(){
		long x = new Long("600851475143").longValue();//6008514750
		int i=2;
		while(x>i*2){
			if(x%i==0){
				x=x/i;
			}
			while(x%i==0){
				x=x/i;
			}
			i++;
		}
		System.out.println(x);
	}
	public static void main(String[] args) {
		func();
	}

}

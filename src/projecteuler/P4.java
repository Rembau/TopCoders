package projecteuler;

public class P4 {
	public static void func(){
		int x=0;
		for (int i = 999; i > 100; i--) {
			for (int j = 999; j > 100; j--) {
				int t = i*j;
				if(is(t) && x<t){
					x=t;
				}
			}
		}
		System.out.println(x);
	}
	public static boolean is(int a){
		String str = String.valueOf(a);
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		func();
	}
}

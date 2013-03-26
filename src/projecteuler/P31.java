package projecteuler;

public class P31 {
	static int[] coin= new int[]{200,100,50,20,10,5,2,1};
	static int n=0;
	public static void func(){
		f(200,0);
		System.out.println(n);
	}
	public static void f(int remain,int i){
		if(remain==0 || i==7){
			n++;
			return;
		}
		while(remain>=0){
			f(remain,i+1);
			remain = remain-coin[i];
		}
	}
	public static void main(String[] args) {
		func();
	}
}

package projecteuler;

public class P76 {
/**
* 
5������6�ַ�ʽд����������������֮�ͣ�

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

100�����Զ����ַ�ʽд����������������֮�ͣ�
*/
			
	public static void func(){
		System.out.println(f(100,99));
	}
	public static long f(int n,int m){
		if(m==1){
			return 1;
		}
		if(m>n){
			return f(n,n);
		}
		if(m==n){
			return f(n,n-1)+1;
		}
		if(m<n){
			return f(n,m-1)+f(n-m,m);
		}
		return 0;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

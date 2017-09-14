package projecteuler;

import java.util.Arrays;

public class P27 {
	static int ar,br,len=0;
	static boolean prime[] = gneratePrime();
	public static void func(){
		for (int i = 0; i < 1000; i++) {
			for (int j = 2; j < 1000; j++) {
				if(prime[j]){
					continue;
				}
				getLen(i,j);
				getLen(-i,j);
				getLen(i,-j);
				getLen(-i,-j);
			}
		}
		System.out.println(ar+" "+br+" "+len+" "+ar*br);
	}
	public static void getLen(int a,int b){
		for (int i = 0; true ; i++) {
			int r=r(a,b,i);
			if(r<0){
				r=-r;
			}
			if(prime[r]){
				if(i>len){
					len=i;
					ar=a;br=b;
				}
				break;
			}
		}
	}
	public static int r(int a,int b,int n){
		return n*n+a*n+b;
	}
	public static boolean[] gneratePrime(){
		int n = 10000000;
		boolean d[] = new boolean[n];
		Arrays.fill(d, false);
		d[0]=true;
		d[1]=true;
		for (int i = 4; i < n; i+=2) {
			d[i]=true;        //�ѳ���2��ż�������Ϊ����
		}
		int x = (int) Math.sqrt(n);
		for (int i = 3; i < x; i+=2) {
			if(!d[i]){			//���û�б����������
				for (int j = i*i; j < n; j+=2*i) {  //С��i�ı��� ��֮ǰ�Ѿ������ˣ������i��jһ��������������ϸ�i
													//��Ϊż����ż��ֱ�ӿ�������
					d[j]=true;
				}
			}
		}
		return d;
	}
	public static void main(String[] args) {
		func();
	}

}

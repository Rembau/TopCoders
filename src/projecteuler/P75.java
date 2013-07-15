package projecteuler;

//import java.util.HashMap;

public class P75 {
/**
It turns out that 12 cm is the smallest length of wire that can be bent to form an 
integer sided right angle triangle in exactly one way, but there are many more examples.
12 cm: (3,4,5)
24 cm: (6,8,10)
30 cm: (5,12,13)
36 cm: (9,12,15)
40 cm: (8,15,17)
48 cm: (12,16,20)

In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, 
and other lengths allow more than one solution to be found; for example, 
using 120 cm it is possible to form exactly three different integer sided right angle triangles.

120 cm: (30,40,50), (20,48,52), (24,45,51)

Given that L is the length of the wire, for how many values of L <= 1,500,000 
can exactly one integer sided right angle triangle be formed?
*/
	static int n=2000;
	public static void func(){
		int count=0;
		//HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int product[] = new int[n/2+1];
		for (int i = 0; i < product.length; i++) {
			product[i]=i*i;
		}
		for (int i = 0; i < product.length; i++) {
			for (int j = i+1; j < product.length; j++) {
				int tem = product[i]+product[j];
				for (int k = j+1; tem+product[k]<=n; k++) {
					
				}
			}
		}
		System.out.println(count);
	}
	/*static int mark[][] = new int[n+1][2];
	static int f[];
	public static void func3(){
		int count=0;
		label:
		for (int i = 3; i <= n; i++) {
			System.out.println(i);
			if(mark[i][0]>1){
				continue;
			}
			for (long j = 1; j < i/3; j++) {
				long jj=j*j;
				long l=0;
				for (long k = i/2-j+1;k<(l=i-j-k) ; k++) {
					if(jj+k*k==l*l){
						//System.out.println(j+" "+k+" "+l+" "+cc);
						if(mark[i][0]==1 && j%mark[i][1]==0){
							continue;
						}
						mark[i][0]++;
						mark[i][1]=(int) j;
						for (int m = i*2; m < n; m+=i) {
							mark[m][0]++;
							mark[m][1]=(int) j;
						}
						if(mark[i][0]>1){
							continue label;
						}
						break;
					}
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			if(mark[i][0]==2){
				count++;
			}
		}
		System.out.println(count);
	}
	public static void func1(){
		int count=0;
		for (long i = 3; i < n/3; i++) {
			System.out.println(i);
			long ii = i*i;
			double k=0;
			for (long j = i+1; i+j+(k=Math.sqrt(ii+j*j))<=n; j++) {
				System.out.println(i+" "+j+" "+k);
				if(k-j<1){
					break;
				}
				if(k % 1==0){
					int m = (int) (i+j+k);
					System.out.println("----"+m+"----");
					for (int l = m; l < n; l+=m) {
						//System.out.println("i----"+i+" l----"+l);
						if(mark[l][0]==0 || i%mark[l][1]!=0){
							mark[l][0]++;
							mark[l][1]=(int)i;
							continue;
						}
					}
					break;
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			System.out.println("i="+i+" "+mark[i][0]);
			if(mark[i][0]==1){
				count++;
			}
		}
		System.out.println(count);
	}
	public static void func2(){
		int count=0;
		f = MathTool.generatePrime(150000);
		for (int i = 0; i < n/3; i++) {
			long ii = i*i;
			double k=0;
			for (long j = i+1; i+j+(k=Math.sqrt(ii+j*j))<=n; j++) {
				System.out.println(i+" "+j+" "+k);
				if(k-j<1){
					break;
				}
				if(k % 1==0){
					int m = (int) (i+j+k);
					System.out.println("----"+m+"----");
					for (int l = m; l < n; l+=m) {
							mark[l][0]++;
					}
					break;
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			System.out.println("i="+i+" "+mark[i][0]);
			if(mark[i][0]==1){
				count++;
			}
		}
		System.out.println(count);
	}*/
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

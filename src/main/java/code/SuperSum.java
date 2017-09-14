package code;

import java.math.BigInteger;

public class SuperSum {
	int num[][];
	/**
	 * 递归
	 * @param k
	 * @param n
	 * @return
	 */
	public int calculate(int k, int n){
		if(k==0){
			return n;
		}
		num =new int[k][n];
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[0].length; j++) {
				num[i][j]=0;
			}
		}
		int x=(int) (superSum(k,n)%1000000007);
		return x;
	}
	public long superSum(int k,int n){
		if(k==0)
			return n;
		long count=0;
		if(num[k-1][n-1]!=0){
			return (int) num[k-1][n-1];
		}
		for (int i = 1; i <= n; i++) {
				count+=superSum(k-1,i);
		}
		num[k-1][n-1]=(int) (count%1000000007);
		return count;
	}
	/**
	 * 迭代方法
	 * @param k
	 * @param n
	 * @return
	 */
	public static int ff(int k,int n){
		int[] begin=new int[n];
		for(int i=0;i<n;i++){
			begin[i]=i+1;
		}
		for(int i=0;i<k;i++){
			for(int j=1;j<n;j++){
				begin[j]+=begin[j-1];
				if(begin[j]-1000000007>=0)
					begin[j]=begin[j]%1000000007;
			}
		}
		return begin[n-1];
	}
	/**
	 * 公式法 靠靠靠
	 * @param k
	 * @param n
	 * @return
	 */
	public int expre(int k,int n){
		BigInteger b = BigInteger.ONE;
		for (int i = 0; i < k+1; i++) {
			b=b.multiply(BigInteger.valueOf(n+i));
			b=b.divide(BigInteger.valueOf(i+1));
		}
		return b.mod(BigInteger.valueOf(1000000007)).intValue();
	}
	public static void main(String[] args)
	{
//		int answer =ff(10,35000000);
//		int answer = new SuperSum().expre(10, 100000000);
//		int answer = new SuperSum().calculate(10, 1000000);
//		System.out.println(answer);
		System.out.println(3&1);
	}
}

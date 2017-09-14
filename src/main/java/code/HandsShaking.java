package code;

public class HandsShaking {
	/**
	 * 递归法
	 * @param end
	 * @return
	 */
/*	public long countPerfect(int end){
		int n=end;
		long[] memo =new long[n+1];
		memo[0]=1;
		memo[2]=1;
		for (int i = 4; i <= n; i+=2) {
			for (int j = 2; j <= i; j+=2) {
				memo[i]+=memo[j-2]*memo[i-j];
				System.out.println(i+" "+(j-2)+" "+(i-j)+" "+memo[i]);
			}
		}
		return memo[n];
	}*/
	
	long dp[];
	/**
	 * 迭代 动态规划法。
	 * @param n
	 * @return
	 */
	public long countPerfect(int n){
		dp = new long[n+1];
		dp[2] = 1;
		getNum(n);
		return dp[n];
	}
	public long getNum(int n){
		if(n==0){
			return 1;
		}
		if(dp[n]!=0){
			return dp[n];
		}
		long sum = 0;
		for (int i = 2; i < n; i+=2) {
			sum+=getNum(i-2)*getNum(n-i);
		}
		dp[n] = sum;
		return sum;
	}
	public static void main(String[] args)
	{
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;
		
		time = System.currentTimeMillis();
		answer = new HandsShaking().countPerfect(2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new HandsShaking().countPerfect(4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new HandsShaking().countPerfect(8);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 14L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}

package projecteuler;

public class P30 {
	static int pows[];
	public static void func(){
		pows = new int[10];
		for (int i = 0; i < pows.length; i++) {
			pows[i]=(int) Math.pow(i, 5);
		}
		int sumt=0;
		for (int i = 10; i < 400000; i++) {
			String str = String.valueOf(i);
			char charn[] = str.toCharArray();
			int sum=0;
			for(char n : charn) {
				sum+=pows[n-'0'];
			}
			if(sum==i){
				System.out.println(sum);
				sumt+=sum;
			}
		}
		System.out.println(sumt);
	}
	public static void main(String[] args) {
		func();
	}

}

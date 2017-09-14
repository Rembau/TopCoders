package oneHundredProject;

public class P3 {
	static int n =21;
	static String nn[][] = new String[n][n];
	public static void func(){
		int tem = (int) Math.ceil(n/2.0);
		String ch[] = new String[tem];
		ch[0]="T";
		ch[1]="J";
		for (int i = 2; i < ch.length; i++) {
			ch[i] = (i-1)+"";
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int x=i;
				int y=j;
				if(x>=Math.ceil(n/2.0)){
					x=n-i-1;
				}
				if(y>=Math.ceil(n/2.0)){
					y=n-j-1;
				}
				System.out.print(ch[Math.min(x, y)]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		func();
	}

}

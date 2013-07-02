package oneHundredProject;

public class P2 {
	static int a=0;
	static int b=1;
	static int c=2;
	static int d=3;
	static int e=4;
	public static void func(){
		boolean b[] = new boolean[5];
		f(0,b);
	}
	public static void f(int i,boolean b[]){
		if(i==5){
			if(judge(b)){
				for (int j = 0; j < b.length; j++) {
					System.out.print(b[j]+" ");
				}
				System.out.println("----");
			}
			return;
		}
		b[i]=false;
		f(i+1,b);
		b[i]=true;
		f(i+1,b);
	}
	public static boolean judge(boolean bb[]){
		if(bb[a] && !bb[b]){
			return false;
		}
		if((bb[b] && bb[c])||(!bb[b]&& !bb[c])){
			return false;
		}
		if((bb[c] & !bb[d]) ||(bb[d]&&!bb[c])){
			return false;
		}
		if(!bb[d] && !bb[e]){
			return false;
		}
		if(bb[e] && (!bb[a] ||!bb[d])){
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		func();
	}

}

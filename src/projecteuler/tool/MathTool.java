package projecteuler.tool;

public class MathTool {
	/**
	 * ÊÇ·ñÎªËØÊı
	 */
	public static boolean isFactor(int a){
		for(int i=2;i<=Math.sqrt(a);i++){
			if(a%i==0){
				return false;
			}
		}
		return true;
	}
	public static int compareTo(char a[],char b[]){
		int i=0;
		while(i<a.length){
			if(a[i]>b[i]){
				return 1;
			} else if(a[i]<b[i]){
				return -1;
			}
			i++;
		}
		return 0;
	}
	public static void main(String[] args) {

	}

}

package projecteuler.tool;

public class MathTool {
	/**
	 * 是否是素数
	 */
	public static boolean isFactor(int a){
		for(int i=2;i<=Math.sqrt(a);i++){
			if(a%i==0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {

	}

}

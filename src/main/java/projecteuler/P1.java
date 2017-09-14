package projecteuler;

public class P1 {
	private int limit;
	public int count(int x,int y,int limit){
		this.limit=limit;
		return getSum(x)+getSum(y)-getSum(x*y);
	}
	public int getSum(int x){
		int max=getMax(x);
		return max==0?0:(x+max)*max/(x*2);
	}
	public int getMax(int x){
		int max=0;
		for (int i = limit-1; i >0 ; i--) {
			if(i%x==0){
				max=i;
				break;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println(new P1().count(3, 5, 1000));
	}
}

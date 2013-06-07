package projecteuler;

public class P73 {
	static double max=1.0/2;
	static double min=1.0/3;
	static int maxn = 12000;
	static int count=0;
	//1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
	public static void func(){
		for (int i = 4; i <= maxn; i++) {
			double temx = Math.floor(i*max);
			double temn = Math.ceil(i*min);
			if(i%2==0){
				temx--;
			}
			if(i%3==0){
				temn++;
			}
			//System.out.println(i+" "+temn+" "+temx);
			for (int j = (int) temn; j <= temx; j++) {
				if(j*1.0/i>min && j*1.0/i<max && j(j,i)==1){
					count++;
				}
			}
		}
		System.out.println(min+" "+max+" "+count);
	}
	public static int j(int o,int d){
		int c=0;
		for(c = d % o ; c >0 ; c = d % o){
			d = o;
			o = c;
		}
		return o;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

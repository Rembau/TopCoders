package projecteuler;

public class P33 {
	public static void func(){
		int p1=1;
		int p2=1;
		for (int i = 10; i < 100; i++) {
			for (int j = i+1; j < 100; j++) {
				if(i/10==i%10){
					continue;
				}
				if(j%10==0){
					continue;
				}
				//System.out.println((i*1.0)/j);
				if((i/10*1.0)/(j%10) == (i*1.0)/j && i%10 == j/10){// 
					System.out.println(i+" "+j);
					p1*=i;
					p2*=j;
				}
			}
		}
		System.out.println(p1+" "+p2);
	}
	public static void main(String[] args) {
		func();
	}

}

package projecteuler;

import projecteuler.tool.MathTool;

public class P46 {
	/**
	 * It was proposed by Christian Goldbach that every odd composite number can
	 * be written as the sum of a prime and twice a square.
	 * 
	 * 9 = 7 + 2*12 
	 * 15 = 7 + 2*22 
	 * 21 = 3 + 2*32 
	 * 25 = 7 + 2*32 
	 * 27 = 19 + 2*22 
	 * 33 = 31 + 2*12
	 * 
	 * It turns out that the conjecture was false.
	 * 
	 * What is the smallest odd composite that cannot be written as the sum of a
	 * prime and twice a square?
	 */
	public static void func(){
		int sqs[] = new int[1000];
		for (int i = 1; i < sqs.length; i++) {
			sqs[i] = i*i;
		}
		int ps[] = MathTool.generatePrime(100000);
		for (int i = 3; true; i++) {
			boolean flag = false;
			for (int j = 0; j < ps.length; j++) {
				if(ps[j]==i){
					flag=true;
					break;
				} else if(ps[j]<i){
					int n = (i-ps[j])/2;
					for (int k = 0; k < sqs.length; k++) {
						if(sqs[k]==n){
							flag=true;
							break;
						}
						if(sqs[k]>n){
							break;
						}
					}
					if(flag){
						break;
					}
				} else if(ps[j]>i){
					break;
				}
			}
			if(!flag){
				System.out.println(i);
				break;
			}
		}
	}
	public static void main(String[] args) { 
		func();
	}

}

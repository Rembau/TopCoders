package projecteuler;

import java.util.Arrays;

import projecteuler.tool.MathTool;

public class P62 {
/**
The cube, 41063625 (345(3)), 
can be permuted to produce two other cubes: 56623104 (384(3)) and 66430125 (405(3)). 

In fact, 41063625 is the smallest cube which has exactly three 
permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are cube.
 */
	public static void func(){
		N nums[] = new N[10000];
		int cdigitnum=1;
		int j=0;
		for (long i = 0; i < nums.length; i++) {
			N n=new N(i*i*i,i);
			if(cdigitnum!=n.digitnum){
				//System.out.println("i="+i);
				nums=Arrays.copyOf(nums, j);
				//System.out.println("nums.length="+nums.length);
				Arrays.sort(nums);
				if(judge(nums)){
					return;
				}
				nums = new N[10000];
				j=0;
				cdigitnum=n.digitnum;
			}
			nums[j]=n;
			j++;
		}
		nums=Arrays.copyOf(nums, j);
		Arrays.sort(nums);
		if(judge(nums)){
			return;
		}
	}
	public static boolean judge(N[] nums){
		int count=1;
		long v=-1;
		for (int i = 1; i < nums.length; i++) {
			if(v==nums[i].value){
				count++;
				if(count==5){
					System.out.println(nums[i].index+" "+nums[i].value+" "+nums[i].index*nums[i].index*nums[i].index);
					System.out.println(nums[i-1].index+" "+nums[i-1].index*nums[i-1].index*nums[i-1].index);
					System.out.println(nums[i-2].index+" "+nums[i-2].index*nums[i-2].index*nums[i-2].index);
					System.out.println(nums[i-3].index+" "+nums[i-3].index*nums[i-3].index*nums[i-3].index);
					System.out.println(nums[i-4].index+" "+nums[i-4].index*nums[i-4].index*nums[i-4].index);
					return true;
				}
			} else{
				count=1;
				v=nums[i].value;
			}
		}
		return false;
	}
	static class N implements Comparable<N>{
		long value;
		long index;
		int digitnum=0;
		public N(long d,long index){
			this.index=index;
			digitnum=MathTool.getDigitNum(d);
			int nums[] = new int[digitnum];
			int i=0;
			while(d>0){
				nums[i++]=(int) (d%10);
				d/=10;
				d-=d%1;
			}
			Arrays.sort(nums);
			for (int j = nums.length-1; j >=0 ; j--) {
				value=value*10+nums[j];
			}
		}
		public int compareTo(N o) {
			if(this.value>o.value){
				return 1;
			} else{
				return -1;
			}
		}
		
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

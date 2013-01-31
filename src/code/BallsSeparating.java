package code;

import java.util.*;

/**
{
{852057, 889141, 662939, 340220 }, 
{600081, 390298, 376707, 372199 }, 
{435097,  40266, 145590, 505103 }}
 * @author Rembau
 *
 */
public class BallsSeparating
{
	int boxS[];
	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @return
	 */
/*	public int minOperations(int[] red, int[] green, int[] blue)
	{
		if(red.length<3){
			return -1;
		}
		boxS = new int[red.length];
		int r[]=new int[]{0,0,0};
		for (int i = 0; i < blue.length; i++) {
			if(red[i]>=green[i]){
				if(red[i]>=blue[i]){
					boxS[i]=0;
				} else {
					boxS[i]=2;
				}
			} else {
				if(green[i]>=blue[i]){
					boxS[i]=1;
				} else{
					boxS[i]=2;
				}
			}
			r[boxS[i]]=1;
		}
		int boxs[][]=new int[][]{red,green,blue};
		ArrayList<Integer> record = new ArrayList<Integer>();
		for(int i=0;i<r.length;i++){
			if(r[i]==0){
				record.add(i);
			}
		}
		if(record.size()==1){
			int index=-1;
			int mm=Integer.MAX_VALUE;
			for (int j = 0; j < red.length; j++) {
				if(Math.abs(boxs[boxS[j]][j]-boxs[record.get(0)][j])< mm){
					mm=Math.abs(boxs[boxS[j]][j]-boxs[record.get(0)][j]);
					index=j;
				}
			}
			boxS[index]=record.get(0);
			System.out.println(index+" "+record.get(0));
		} else if(record.size()==2){
			int index1[]=new int[]{-1,-1};
			int index2[]=new int[]{-1,-1};
			int mm=Integer.MAX_VALUE;
			int nn=Integer.MAX_VALUE;
			for (int j = 0; j < boxs.length; j++) {
				if(Math.abs(boxs[boxS[j]][j]-boxs[record.get(0)][j])<= mm){
					mm=Math.abs(boxs[boxS[j]][j]-boxs[record.get(0)][j]);
					index1[1]=index1[0];
					index1[0]=j;
				}
				if(Math.abs(boxs[boxS[j]][j]-boxs[record.get(1)][j])<= nn){
					nn=Math.abs(boxs[boxS[j]][j]-boxs[record.get(1)][j]);
					index2[1]=index2[0];
					index2[0]=j;
				}
			}
			if(index1[0]!=index2[0]){
				boxS[index1[0]]=record.get(0);
				boxS[index2[0]]=record.get(1);
			} else {
				int x= boxs[boxS[index1[0]]][index1[0]]+boxs[record.get(0)][index1[0]] 
						+ boxs[boxS[index1[1]]]
								[index1[1]]+
						boxs[record.get(1)][index1[1]];
				int x_=boxs[boxS[index1[0]]][index1[0]]+boxs[record.get(1)][index2[1]]
						+ boxs[boxS[index2[1]]][index2[1]]+boxs[record.get(0)][index2[1]];;
				if(x<=x_){
					boxS[index1[0]]=record.get(1);
					boxS[index1[1]]=record.get(0);
					System.out.println(boxS[index1[0]]+" "+boxS[index1[1]]);
				} else{
					boxS[index1[0]]=record.get(0);
					boxS[index2[1]]=record.get(1);
					System.out.println(boxS[index1[0]]+" "+boxS[index2[1]]);
				}
			}
		}
		
		int count=0;
		for (int i = 0; i < red.length; i++) {
			int a=(boxS[i]+1)%3;
			int b=(boxS[i]+2)%3;
			count+=(boxs[a][i]+boxs[b][i]);
		}
		return count;
	}*/
	public int minOperations(int[] red, int[] green, int[] blue){
		if(red.length<3){
			return -1;
		}
		int r=Integer.MAX_VALUE;
		for (int i = 0; i < blue.length; i++) {
			for (int j = 0; j < blue.length; j++) {
				for (int j2 = 0; j2 < blue.length; j2++) {
					int t=0;
					if(i==j || i==j2 || j==j2) continue;
					for (int k = 0; k < blue.length; k++) {
						int gb=green[k]+blue[k];
						int rb=red[k]+blue[k];
						int rg=red[k]+green[k];
						if(k==i) t+=(gb);
						else if(k==j) t+=(rb);
						else if(k==j2) t+=(rg);
						else {
							t+=Math.min(gb,Math.min(rb, rg));
						}
					}
					r=t<r?t:r;
				}
			}
		}
		return r;
	}
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		time = System.currentTimeMillis();
		answer = new BallsSeparating().minOperations(new int[]{1, 1, 1}
		, new int[]{1,1,1}, new int[]{1,1,1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new BallsSeparating().minOperations(new int[]{5}, new int[]{6}, new int[]{8});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new BallsSeparating().minOperations(new int[]{4, 6, 5, 7}, new int[]{7, 4, 6, 3}, new int[]{6, 5, 3, 8});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 37;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new BallsSeparating().minOperations(new int[]{7, 12, 9, 9, 7}, new int[]{7, 10, 8, 8, 9}, new int[]{8, 9, 5, 6, 13});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 77;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new BallsSeparating().minOperations(new int[]{842398, 491273, 958925, 849859, 771363, 67803, 184892, 391907, 256150, 75799}, new int[]{268944, 342402, 894352, 228640, 903885, 908656, 414271, 292588, 852057, 889141}, new int[]{662939, 340220, 600081, 390298, 376707, 372199, 435097, 40266, 145590, 505103});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7230607;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}
}

package projecteuler;

public class P18 {
	public static void func(String str[]) {
		int rowNum = str.length;
		int[][] nums = new int[rowNum][];
		for (int i = 0; i < rowNum; i++) {
			String strnum[] = str[i].split(" ");
			int num[] = new int[strnum.length];
			for (int j = 0; j < num.length; j++) {
				num[j] = Integer.valueOf(strnum[j]);
			}
			nums[i] = num;
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = 0; j < nums[i].length; j++) {
				if (nums[i][j] + nums[i + 1][j] > nums[i][j]
						+ nums[i + 1][j + 1]) {
					nums[i][j] = nums[i][j] + nums[i + 1][j];
				} else {
					nums[i][j] = nums[i][j] + nums[i + 1][j + 1];
				}
			}
		}
		System.out.println(nums[0][0]);
	}

	/*
	 * static int count=0; static int rowNum=0; static int [][]nums; static int
	 * [][][]m; public static void func(String str[]){ rowNum=str.length;
	 * nums=new int[rowNum][]; for (int i = 0; i < rowNum; i++) { String
	 * strnum[]=str[i].split(" "); int num[] = new int[strnum.length]; for (int
	 * j = 0; j < num.length; j++) { num[j]=Integer.valueOf(strnum[j]); }
	 * nums[i]=num; } m = new int[str.length-1][][]; for (int i = 0; i <
	 * m.length; i++) { int m1[][] = new int[nums[i].length][2]; for (int[] js :
	 * m1) { Arrays.fill(js, 1); } for (int j = 0; j < nums[i].length-1; j++) {
	 * if(nums[i][j]>nums[i][j+1]){ m1[j+1][0]=0; } else
	 * if(nums[i][j]<nums[i][j+1]){ m1[j][1]=0; } } m[i]=m1; } sum(0,0,0);
	 * System.out.println(count); }
	 *//**
	 * h:当前行 s:当前和 i:当前索引
	 */
	/*
	 * static int cc=0; public static void sum(int h,int s,int i){
	 * s+=nums[h][i]; System.out.print(h+" ");
	 * System.out.print(nums[h][i]+" s="+s); if(h==rowNum-1){ if(s>count){
	 * count=s; } cc++; System.out.println("cc="+cc+": s= "+s); return; }
	 * System.out.println(" m[h][i][0]= "+m[h][i][0]
	 * +" m[h][i][1]= "+m[h][i][1]); if(m[h][i][0]==1){ sum(h+1,s,i); }
	 * if(m[h][i][1]==1){ sum(h+1,s,i+1); } }
	 */
	public static void main(String[] args) {

		String str[] = new String[] { "75", "95 64", "17 47 82", "18 35 87 10",
				"20 04 82 47 65", "19 01 23 75 03 34", "88 02 77 73 07 63 67",
				"99 65 04 28 06 16 70 92", "41 41 26 56 83 40 80 70 33",
				"41 48 72 33 47 32 37 16 94 29",
				"53 71 44 65 25 43 91 52 97 51 14",
				"70 11 33 28 77 73 17 78 39 68 17 57",
				"91 71 52 38 17 14 91 43 58 50 27 29 48",
				"63 66 04 68 89 53 67 30 73 16 69 87 40 31",
				"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23" };
		func(str);
	}

}

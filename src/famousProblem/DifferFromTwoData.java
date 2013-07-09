package famousProblem;

/**
 * 求两个日志之间差的天数。
 * @author Rembau
 *
 */

public class DifferFromTwoData {
	public static void func(int y1,int m1,int d1,int y2,int m2,int d2){
		int count=0;
		for (int i=y1;i <= y2; i++) {
			boolean b = isLeap(i);
			int sm=1;
			int em=12;
			if(i==y1){
				sm=m1;
			}
			if(i==y2){
				em=m2;
			}
			for (int j = sm; j <= em; j++) {
				int sd=0;
				int ed=getDataNum(j,b);
				if(i==y1 && j==m1){
					sd=d1;
				}
				if(i==y2 && j==m2){
					ed=d2;
				}
				System.out.println(j+" "+sd+" "+ed);
				count+=(ed-sd);
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		func(2012,5,30,2013,5,30);
	}
	public static int getDataNum(int j,boolean b){
		int days;
		switch (j) {
		case 2:
			if (b) {
				days=29;
			} else {
				days=28;
			}
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;break;
			default: days=30;break;
		}
		return days;
	}
	public static boolean isLeap(int i){
		if ((i % 4 == 0 && (i % 100 != 0)) || i % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}
}

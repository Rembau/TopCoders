package code;

import java.util.Arrays;
// SRM570
public class Chopsticks {

	public int getmax(int l[]){
		int max=0;
		int mark[]=new int[l.length];
		Arrays.fill(mark, 0);
		for (int i = 0; i < l.length-1; i++) {
			if(mark[i]==1){
				continue;
			}
			for (int j = i+1; j < l.length; j++) {
				if(mark[j]==0 && l[i]==l[j]){
					max++;
					mark[i]=1;
					mark[j]=1;
					break;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {

	}
}

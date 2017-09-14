package code;

import java.util.Arrays;
//SRM570
public class RobotHerbDiv2 {

	public int getdist(int T,int []a){
		int dis=0;
		int coord[]=new int[2];
		Arrays.fill(coord, 0);
		int direction=0;
		for(int t=0;t<T;t++){
			for (int i = 0; i < a.length; i++) {
				if(direction==0){
					moveR(coord,a[i]);
				} else if(direction==1){
					moveD(coord,a[i]);
				} else if(direction==2){
					moveL(coord,a[i]);
				} else if(direction==3){
					moveU(coord,a[i]);
				}
				direction = (direction+a[i])%4;
			}
		}
		dis = Math.abs(coord[0])+Math.abs(coord[1]);
		return dis;
	}
	public void moveR(int coord[],int step){
		coord[0]+=step;
	}
	public void moveL(int coord[],int step){
		coord[0]-=step;
	}
	public void moveU(int coord[],int step){
		coord[1]-=step;
	}
	public void moveD(int coord[],int step){
		coord[1]+=step;
	}
	public static void main(String[] args) {

	}

}

package oneHundredProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Rembau
 * Date: 13-8-12
 * Time: ÏÂÎç3:33
 * To change this template use File | Settings | File Templates.
 1  2  3  4  5
 2  3  4  5  1
 3  4  5  1  2
 4  5  1  2  3
 5  1  2  3  4
 */
public class P4 {
    static int n=5;
    static LinkedList<Integer>[][] enabled;
    static int[][] matrix;
	static int count=0;
    public static void func(){
        enabled = new LinkedList[n][n];
	    matrix = new int[n][n];
	    LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for(int i = 0; i < enabled.length; i++) {
            for (int j=0;j< enabled[i].length;j++){
                enabled[i][j]=new LinkedList<Integer>(list);
            }
        }
	    f(0,0);
	    System.out.println(count);
    }
    public static void f(int i,int j){
		if(i==n-1 && j==n){
			print(matrix);
			count++;
		//	System.exit(0);
			return;
		}
	    if(j==n){
		    i++;
		    f(i,0);
		    return;
	    }
	    /*if(i==3 && j==3){
		    System.out.println(enabled[i][j]);
	    }*/
	    //System.out.println(i + " " + j + " " + enabled[i][j]);
	    for (int x=0 ; x< enabled[i][j].size();x++) {
		    int tem = enabled[i][j].getFirst();
		    //System.out.println(i + " " + j + " " + enabled[i][j]+" use tem="+tem);
		    matrix[i][j]=tem;
			avoid(i,j,tem);
		    f(i,j+1);
		    recover(i,j,tem);
	    }
    }
/*			1  2  3  4  5
			2  3  4  5  1
			3  4  5  1  2
			4  5  1  2  3
			5  1  2  3  4*/
	static LinkedList<RecordAvoid>[][] recordAvoids = new LinkedList[n][n];
	public static void avoid(int i,int j,int tem){
		recordAvoids[i][j] = new LinkedList<RecordAvoid>();
		/*if(i==1 && j==1){
			System.out.println("tem="+tem);
		}*/
		enabled[i][j].remove(new Integer(tem));
		recordAvoids[i][j].add(new RecordAvoid(i, j, tem));
		for (int k = j+1; k < n; k++) {
			if(enabled[i][k].remove(new Integer(tem))){
				recordAvoids[i][j].add(new RecordAvoid(i, k, tem));
			}
		}
		for (int k = i+1; k < n; k++) {
			if(enabled[k][j].remove(new Integer(tem))){
				recordAvoids[i][j].add(new RecordAvoid(k, j, tem));
			}
		}
	}
	public static void recover(int i,int j,int tem){
		//System.out.println("recover "+i+" "+j+" "+tem+"");
		for(RecordAvoid ra:recordAvoids[i][j]){
			if(!enabled[ra.x][ra.y].contains(tem)){
				//System.out.println("recover---"+ra.x+" "+ra.y+" "+tem+"");
				enabled[ra.x][ra.y].add(tem);
			}
		}
	}
	static class RecordAvoid{
		int x,y;
		int tem;
		public RecordAvoid(int x,int y,int value){
			this.x=x;
			this.y=y;
			this.tem=value;
		}
	}
	public static void print(int d[][]){
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
    public static void main(String args[]){
	    long i =System.currentTimeMillis();
	    func();
	    System.out.println(System.currentTimeMillis()-i);
    }
}

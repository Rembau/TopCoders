package famousProblem;

import java.util.LinkedList;

public class EightQueenProblem {
	static int board[][] =new int[8][8];
	static int count = 0;
	static LinkedList<Integer[]> queens = new LinkedList<Integer[]>();
	public static void func(){
		f(0);
		System.out.println(count);
	}
	public static void p(){
		for (Integer in[] : queens) {
			for (int i = 0; i < board.length; i++) {
				if(in[1]==i){
					System.out.print(1+" ");
				} else {
					System.out.print(0+" ");
				}
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
	public static void f(int line){
		if(line == 8){
			count++;
			p();
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if(board[line][i]==1){
				continue;
			}
			Integer[] in = new Integer[]{line,i};
			queens.add(in);
			LinkedList<Integer[]> list = avoidAttack(line,i);
			for (Integer[] integers : list) {
				board[integers[0]][integers[1]]=1;
			}
			f(line+1);
			queens.remove(in);
			for (Integer[] integers : list) {
				board[integers[0]][integers[1]]=0;
			}
		}
	}
	public static LinkedList<Integer[]> avoidAttack(int line,int x){
		LinkedList<Integer[]> list = new LinkedList<Integer[]>();
		for (int i = 0; i < board.length; i++) {
			if(board[line][i]==0){
				list.add(new Integer[]{line,i});
			}
		}
		for (int i = 0; i < board.length; i++) {
			if(board[i][x]==0){
				list.add(new Integer[]{i,x});
			}
		}
		for (int i = 1; ; i++) {
			if(line-i>=0 && x-i>=0){
				if(board[line-i][x-i]==0){
					list.add(new Integer[]{line-i,x-i});
				}
			} else{
				break;
			}
		}
		for (int i = 1; ; i++) {
			if(line-i>=0 && x+i<board.length){
				if(board[line-i][x+i]==0){
					list.add(new Integer[]{line-i,x+i});
				}
			} else{
				break;
			}
		}
		for (int i = 1; ; i++) {
			if(line+i<board.length && x-i>=0){
				if(board[line+i][x-i]==0){
					list.add(new Integer[]{line+i,x-i});
				}
			} else{
				break;
			}
		}
		for (int i = 1; ; i++) {
			if(line+i<board.length && x+i<board.length){
				if(board[line+i][x+i]==0){
					list.add(new Integer[]{line+i,x+i});
				}
			} else{
				break;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
}

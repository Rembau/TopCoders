package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class RedBlackTreeSort {
/**
  	  |-6
  |-5-|
  |   |-4
3-|
  |-2 
*/
	static node top;
	static LinkedList<node> list = new LinkedList<node>();
	static int size;
	static String blank = "-";
	public static void func(){
		int num[] = new int[]{3,900000,7,5,2,6,4,8,17,9,16,20,59,37,78};
		top = new node(num[0],1);
		list.add(top);
		for (int i = 1; i < num.length; i++) {
			f(num[i]);
		}
		LinkedList<node> readyList = new LinkedList<node>();
		Collections.sort(list);
		size = (int) Math.ceil(Math.log10(list.get(0).value));
		//由上往下画
		for (int i = 0; i < num.length; i++) {
			node node = list.get(i);
			String line[] = null;
			int num_side;
			int tem = (int) (size - Math.ceil(Math.log10(node.value)));
			num_side=(node.level-1)*size+(node.level-1)*3+tem;
			if(node.level==1){
				node.secend = num_side+2;
				if(node.left!=null || node.right!=null){
					line = new String[num_side+3];
					Arrays.fill(line, blank);
					line[num_side+1]="-";
					line[num_side+2]="|";
				}
				line[num_side] = node.value+"";
			} else {
				if(node.left!=null || node.right!=null){
					line = new String[num_side+3];
					Arrays.fill(line, blank);
					line[num_side+1]="-";
					line[num_side+2]="|";
				} else {
					line = new String[num_side+1];
					Arrays.fill(line, blank);
				}
				for (int j = 0; j < num_side-tem; j++) {
					line[j]=" ";
				}
				line[num_side]=""+node.value;
				line[num_side-2-tem] = "|";
				line[num_side-1-tem] = "-";
				node.first = num_side-2-tem;
				node.secend = num_side+2+(size - tem-1);
			}
			node.isPaint=true;
			//这里是画父子节点相连很多个"|"时的"|"。
			for (node _node : readyList) {
				if(_node.father!=null && !_node.father.isPaint){
					line[_node.first]="|";
				} 
				if(_node.right!=null && !_node.right.isPaint){
					line[_node.secend]="|";
				}
			}
			for (String string : line) {
				System.out.print(string);
			}
			System.out.println();
			readyList.add(node);
		}
	}
	public static void f(int num){
		node node = top;
		while(true){
			if(node.value<num){
				node.bigger_num++;
				if(node.left==null){
					node left = new node(num,node.level+1);
					node.left=left;
					left.father = node;
					list.add(left);
					return;
				}
				node = node.left;
			} else {
				node.small_num++;
				if(node.right==null){
					node right=new node(num,node.level+1);
					node.right = right;
					right.father = node;
					list.add(right);
					return;
				}
				node = node.right;
			}
		}
	}
	static class node implements Comparable<node>{
		int value;
		int bigger_num;
		int small_num;
		int level;
		node left;
		node right;
		node father;
		int first;
		int secend;
		boolean isPaint = false;
		public node(int n,int l){
			value = n;
			level = l;
		}
		public String toString(){
			return this.value+" "+level;
		}
		public int compare(node o1, node o2) {
			return o2.value-o1.value;
		}
		public int compareTo(node o) {
			return o.value-this.value;
		}
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println((System.currentTimeMillis()-i)+"ms");
	}

}

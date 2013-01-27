package code;

import java.util.Arrays;

public class Lottery {
	class Element implements Comparable<Element>{
		String name;
		int ch;
		int blank;
		String sorted;
		String unique;
		
		long num=1;
		void setAll(String str){
			String str1[] = str.split(":");
			name = str1[0];
			String str2[] = str1[1].split(" ");
			ch = Integer.valueOf(str2[1]);
			blank = Integer.valueOf(str2[2]);
			sorted = str2[3];
			unique = str2[4];
			figure();
		}
		void figure(){
			if(sorted.equals("F") && unique.equals("F")){
				num = (long) Math.pow(ch, blank);
			}
			if(sorted.equals("F") && unique.equals("T")){
				for (int i = 0; i < blank; i++) {
					num*=(ch-i);
				}
			}
			if(sorted.equals("T") && unique.equals("F")){
				int x=1;
				for (int i = 0; i < blank; i++) {
					num*=(ch+blank-1-i);
					x*=(blank-i);
				}
				num= num/x;
			}
			if(sorted.equals("T") && unique.equals("T")){
				int x=1;
				for (int i = 0; i < blank; i++) {
					num*=(ch-i);
					x*=(blank-i);
				}
				num= num/x;
			}
		}
		public void fig1(){
			
		}
		public int compareTo(Element o) {
			return this.num==o.num?name.compareTo(o.name):this.num>o.num?1:-1;
		}
 	}
	public String[] sortByOdds(String[] rules){
		if(rules.length==0){
			return new String[]{"Empty case"};
		}
		Element[] ele=new Element[rules.length];
		for (int i = 0; i < rules.length; i++) {
			ele[i] = new Element();
			ele[i].setAll(rules[i]);
		}
		Arrays.sort(ele);
		for (int i = 0; i < ele.length; i++) {
			rules[i]=ele[i].name;
		}
		return rules;
	}
	public static void main(String[] args) {
		String rules[] ={"PICK ANY TWO: 10 2 F F"
				,"PICK TWO IN ORDER: 10 2 T F"
				,"PICK TWO DIFFERENT: 10 2 F T"
				,"PICK TWO LIMITED: 10 2 T T"}; 
		p(new Lottery().sortByOdds(rules));
	}
	public static void p(String s[]){
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]+" ");
		}
		System.out.println();
	}
}

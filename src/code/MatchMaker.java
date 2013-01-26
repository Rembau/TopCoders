package code;

public class MatchMaker {
	
	public String[] getBestMatches(String[] members, String currentUser, int sf){
		int s[]=new int[members.length-1];
		for (int i = 0; i < s.length; i++) {
			s[i]=-1;
		}
		System.out.println(members.length);
		String mm[][] =new String[members.length-1][];
		String user[]=null;
		int m=0;
		int fff=0;
		int mmm=0;
		for (int i = 0; i < members.length; i++) {
			if(members[i].split(" ")[1].equals("F")){
				fff++;
			} else {
				mmm++;
			}
			if(members[i].split(" ")[0].equals(currentUser)){
				System.out.println("i="+i);
				user=members[i].split(" ");
			} else {
				mm[m++]=members[i].split(" ");
			}
		}
		String rr[][]=null;
		String rm=user[1];
		if(user[1].equals("F")){
			rr=new String[mmm][];
		} else{
			rr=new String[fff][];
		}
		int x=0;
		for (int i = 0; i < mm.length; i++) {
			if(!mm[i][1].equals(rm)){
				rr[x++]=mm[i];
			}
		}
		sort(rr,user);
		String str[]=new String[rr.length];
		for (int i = 0; i < rr.length; i++) {
			System.out.println((combine(rr[i])));
			str[i]=combine(rr[i]);
		}
		return str;
	}
	public String combine(String m[]){
		String str="";
		for (int i = 0; i < m.length; i++) {
			str=str+" "+m[i];
		}
		return str;
	}
	public void sort(String [][] mm,String c[]){
		for (int i = 0; i < mm.length; i++) {
			for (int j = 0; j < mm.length-1-i; j++) {
				if(compare(mm[j],mm[j+1],c)<0){
					String tt[]=mm[j];
					mm[j]=mm[j+1];
					mm[j+1]=tt;
				}
			}
		}
	}
	public int compare(String a[],String b[],String c[]){
		int aa=0,bb=0;
		for (int j = 3; j < c.length; j++) {
			if (a[j].equals(c[j])) {
				aa++;
			}
			if (b[j].equals(c[j])) {
				bb++;
			}
		}
		p(a);
		p(b);
		System.out.println(aa-bb);
		return aa-bb;
	}
	public static void main(String[] args) {
		String m[]=new String[]{
			 "BETTY F M A A C C",
			 "TOM M F A D C A",
			 "SUE F M D D D D",
			 "ELLEN F M A A C A",
			 "JOE M F A A C A",
			 "ED M F A D D A",
			 "SALLY F M C D A B",
			 "MARGE F M A A C C"};
		p(new MatchMaker().getBestMatches(m, "BETTY", 6));
	}
	public static void p(String s[]){
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
		System.out.println();
	}
}

package code;

public class BinaryCode {
	String nu="NONE";
	public String[] decode(String message){
		char messageChar[] = message.toCharArray();
		int messageInt[] = new int[messageChar.length];
		for (int i = 0; i < messageChar.length; i++) {
			messageInt[i]=messageChar[i]-'0';
		}
		p(messageInt);
		if(messageInt.length==1){
			if(messageInt[0]==0){
				return new String[]{"0",nu};
			} else if(messageInt[0]==1){
				return new String[]{nu,"1"};
			} else return new String[]{nu,nu};
		}
		return new String[]{f(messageInt,0),f(messageInt,1)};
	}
	public String f(int m[],int value){
		int i=1;
		String str=""+value;
		int r[]=new int[m.length];
		r[0]=value;
		while(i<m.length){
			r[i]=getV(m,r,i);
			System.out.println("value = "+value+" "+r[i]);
			if(r[i]>1 || r[i]<0){
				return nu;
			}
			str=str+r[i];
			i++;
		}
		return str;
	}
	public int getV(int m[],int r[],int i){
		if(i==1){
			System.out.println();
			return m[i-1]-r[i-1];
		}
		/*if(i==r.length-1){
			return m[i-1]-r[i-1];
		}*/
		return m[i-1]-r[i-1]-r[i-2];
	}
	public static void main(String[] args) {
		String message = "123210122";
		p(new BinaryCode().decode(message));
	}
	public static void p(Object s[]){
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
		System.out.println();
	}
	public static void p(int s[]){
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
		System.out.println();
	}
}

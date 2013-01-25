package code;

public class Execution {
	public long analyze(String[] code){
		long l=0;
		String str="";
		for (int i = 0; i < code.length; i++) {
			str+=code[i];
		}
		str=str.replaceAll(" ", "");
		l=for_(str,1);
		return l;
	}
	int index=0;
	public long for_(String str,long num){
		long l=0;
		long time=0;
		while(index<str.length()){
			String str_=str.substring(index, str.length()).trim();
			System.out.println("Str "+str_);
			if(str_.startsWith("BASIC;")){
				l++;
				int tem=str_.indexOf(';');
				index+=tem+1;
				continue;
			}
			if(str_.startsWith("for")){
				time = Long.valueOf(str_.substring(str_.indexOf('(')+1, str_.indexOf(')')));
				System.out.println(time);
				index=index+str_.indexOf('{')+1;
				l+=time*for_(str,time);
				continue;
			}
			if(str_.startsWith("}")){
				index=index+str_.indexOf('}')+1;
				return l;
			}
			break;
		}
		return l;
	}
	public static void main(String[] args) {
		String code[]=new String[]{"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
				,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
				,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
				,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
				,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
				,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
				,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
				,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
				,"BASIC;"
				,"}}}}}}}}}}}}}}}}}}}}}}}}}}}}"
				,"}}}}}}}}}}}}}}}}}}}}}}}}}}}}"};
		System.out.println(new Execution().analyze(code));
	}

}

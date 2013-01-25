package code;

public class Whisper {
	public String toWhom(String[] usernames, String typed){
		typed = typed.toLowerCase();
		if(!typed.startsWith("/msg ")){
			return "not a whisper";
		}
		typed = typed.replace("/msg ", "");
		System.out.println(typed);
		int length=0;
		int mark=-1;
		for (int i = 0; i < usernames.length; i++) {
			System.out.println(usernames[i].toLowerCase());
			if(typed.startsWith(usernames[i].toLowerCase()+" ") && usernames[i].length()>length){
				mark=i;
				length = usernames[i].length();
			}
		}
		if(mark==-1){
			return "user is not logged in";
		}
		return usernames[mark];
	}
	public static void main(String[] args) {
		String usernames[] = new String[]{"Wow"};
		String typed = "/msg Wow ";
		System.out.println(new Whisper().toWhom(usernames, typed));
	}
}

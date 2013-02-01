package code;

public class MirroredClock
{
	/**
	 * 功能代码
	 * @param time
	 * @return
	 */
	public String whatTimeIsIt(String time)
	{
		String t[] = time.split(":");
		int h1 = Integer.valueOf(t[0]);
		int m1 = Integer.valueOf(t[1]);
		int h2=0;
		int m2=0;
		if(m1==0){
			h2=(12-h1)%12;
		} else {
			h2=11-h1;
			m2=60-m1;
		}
		String hs="",ms="";
		if(h2<10){
			hs = "0"+h2;
		} else {
			hs=""+h2;
		}
		if(m2<10){
			ms = "0"+m2;
		} else {
			ms = ""+m2;
		}
		return hs+":"+ms;
	}
	/**
	 * 与上面的whatTimeIsIt_()方法有同样功能（改写）
	 * @param _
	 * @return
	 */
	public String whatTimeIsIt_(String _)
	{
		return (((_(__(_)[1]))==0?(12-(_(__(_)[0])))%12:11-(_(__(_)[0])))>=10?(_(__(_)[1]))==0?(12-(_(__(_)[0])))%12:11-(_(__(_)[0]))+"":"0"+((_(__(_)[1]))==0?(12-(_(__(_)[0])))%12:11-(_(__(_)[0]))))+":"+((60-(_(__(_)[1])))%60>=10?(60-(_(__(_)[1])))%60+"":"0"+(60-(_(__(_)[1])))%60);
	}
	public int _(String n){
		return Integer.valueOf(n);
	}
	public String[] __(String n){
		return n.split(":");
	}
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		time = System.currentTimeMillis();
		answer = new MirroredClock().whatTimeIsIt("10:00");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "02:00";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MirroredClock().whatTimeIsIt("01:15");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "10:45";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MirroredClock().whatTimeIsIt("03:40");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "08:20";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MirroredClock().whatTimeIsIt("00:00");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "00:00";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MirroredClock().whatTimeIsIt("11:53");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "00:07";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
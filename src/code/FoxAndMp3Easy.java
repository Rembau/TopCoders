package code;

import java.util.Arrays;

public class FoxAndMp3Easy {
	public String[] playList(int n){
		String ms[] = new String[n];
		for (int i = 0; i < ms.length; i++) {
			ms[i]=""+(i+1)+".mp3";
		}
		Arrays.sort(ms);
		String m[]=new String[Math.min(50, n)];
		for (int i = 0; i < m.length; i++) {
			m[i]=ms[i];
		}
		/*List<String> ms = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			ms.add(i+".mp3");
		}
		Collections.sort(ms, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String str1 =  o1;
				String str2 =  o2;
				
				int len1 = str1.length();
				int len2 = str2.length();
				if(len1>len2){
					for(int i=0;i<len1-len2;i++){
						str2+="0";
					}
				} else if(len2>len1){
					for(int i=0;i<len2-len1;i++){
						str1+="0";
					}
				}
				
				for(int i=0;i<str1.length();i++){
					if(Integer.valueOf(str1.charAt(i)) > Integer.valueOf(str2.charAt(i))){
						return 1;
					} else if(Integer.valueOf(str1.charAt(i)) < Integer.valueOf(str2.charAt(i))){
						return -1;
					}
				}
				return 0;
			}
		});
		String m[];
		if(ms.size()<=50){
			m = new String[ms.size()];
			ms.toArray(m);
		} else {
			m = new String[50];
			int i=0;
			while(i<50){
				m[i]=ms.get(i);
				i++;
			}
		}*/
		return m;
	}
	public static void main(String[] args)
	{
		long time;
		String[] answer;
		boolean errors = false;
		String[] desiredAnswer;
		
		boolean same;
		time = System.currentTimeMillis();
		answer = new FoxAndMp3Easy().playList(3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"1.mp3", "2.mp3", "3.mp3" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FoxAndMp3Easy().playList(10);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"1.mp3", "10.mp3", "2.mp3", "3.mp3", "4.mp3", "5.mp3", "6.mp3", "7.mp3", "8.mp3", "9.mp3" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FoxAndMp3Easy().playList(16);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"1.mp3", "10.mp3", "11.mp3", "12.mp3", "13.mp3", "14.mp3", "15.mp3", "16.mp3", "2.mp3", "3.mp3", "4.mp3", "5.mp3", "6.mp3", "7.mp3", "8.mp3", "9.mp3" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FoxAndMp3Easy().playList(32);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"1.mp3", "10.mp3", "11.mp3", "12.mp3", "13.mp3", "14.mp3", "15.mp3", "16.mp3", "17.mp3", "18.mp3", "19.mp3", "2.mp3", "20.mp3", "21.mp3", "22.mp3", "23.mp3", "24.mp3", "25.mp3", "26.mp3", "27.mp3", "28.mp3", "29.mp3", "3.mp3", "30.mp3", "31.mp3", "32.mp3", "4.mp3", "5.mp3", "6.mp3", "7.mp3", "8.mp3", "9.mp3" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FoxAndMp3Easy().playList(109);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"1.mp3", "10.mp3", "100.mp3", "101.mp3", "102.mp3", "103.mp3", "104.mp3", "105.mp3", "106.mp3", "107.mp3", "108.mp3", "109.mp3", "11.mp3", "12.mp3", "13.mp3", "14.mp3", "15.mp3", "16.mp3", "17.mp3", "18.mp3", "19.mp3", "2.mp3", "20.mp3", "21.mp3", "22.mp3", "23.mp3", "24.mp3", "25.mp3", "26.mp3", "27.mp3", "28.mp3", "29.mp3", "3.mp3", "30.mp3", "31.mp3", "32.mp3", "33.mp3", "34.mp3", "35.mp3", "36.mp3", "37.mp3", "38.mp3", "39.mp3", "4.mp3", "40.mp3", "41.mp3", "42.mp3", "43.mp3", "44.mp3", "45.mp3" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
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
/*roblem Statement
    
Fox Ciel loves music. She currently has n songs in her mp3 player. Their file names are "1.mp3", "2.mp3", 
and so on, until string(n)+".mp3".   Sadly, Ciel's mp3 player does not sort the files according to the number. 
Instead, it simply sorts the file names in lexicographic order, as strings. 
So, for instance, if n=10 then the sorted order looks as follows: "1.mp3", "10.mp3", "2.mp3", ..., "9.mp3".   
You are given the int n. If n is at most 50, return a String[] containing the entire sorted list of file names. 
		If n is more than 50, return a String[] containing the first 50 elements of the sorted list of file names.
Definition
    
Class:
FoxAndMp3Easy
Method:
playList
Parameters:
int
Returns:
String[]
Method signature:
String[] playList(int n)
(be sure your method is public)
    

Notes
-
The string A is lexicographically smaller than the string B if either of the following two 
conditions holds: 1. A is a proper prefix of B; 2. There is an index i such that the first (i-1) 
characters of A and B are equal, and character i of A has a smaller ASCII value than character i of B.
Constraints
-
n will be between 1 and 1,000, inclusive.
Examples
0)

    
3
Returns: {"1.mp3", "2.mp3", "3.mp3" }
We have 3 files: "1.mp3", "2.mp3", and "3.mp3". This is also their lexicographic order.*/
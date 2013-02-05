package code;

import java.util.ArrayList;

public class FieldPairParse {
	public int[] getPairs(String[] data)
	{
		char ch[][]=new char[data.length][data[0].length()];
		ArrayList<Integer> rd = new ArrayList<Integer>();
		for (int i = 0; i < ch.length; i++) {
			ch[i]=data[i].toCharArray();
		}
		boolean flag = true;
		int r=0;
		for (int i = 0; i < ch[0].length; i++) {
			for (int j = 0; j < ch.length; j++) {
				if(ch[j][i]!=' '){
					flag = false;
					break;
				}
			}
//			System.out.println(flag+" "+r);
			if(flag){
				r++;
			} else if(r!=0){
				rd.add(r);
				r=0;
			}
			flag = true;
		}
		if(rd.size()%2==0){
			return new int[0];
		}
		int d[] = new int[rd.size()];
		for (int i = 0; i < rd.size(); i++) {
			d[i]=rd.get(i);
		}
		return d;
	}
	public static void main(String[] args)
	{
		long time;
		int[] answer;
		boolean errors = false;
		int[] desiredAnswer;
		
		boolean same;
		time = System.currentTimeMillis();
		answer = new FieldPairParse().getPairs(new String[]{"XXXXX    XXXXX","XXXX    XXXXX "});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{3 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
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
		answer = new FieldPairParse().getPairs(new String[]{"XXXXXXXXXX     XXXXXXXXXXX","XXXXXXXXXXXXXXXXX    XXXXX"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{ };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
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
		answer = new FieldPairParse().getPairs(new String[]{"X X X","X X X"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{ };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
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
		answer = new FieldPairParse().getPairs(new String[]{"XXXX      X  X           X X   X","XX       XXX XX   X   X   X XXX "});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{5, 1, 3, 3, 2 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
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
		answer = new FieldPairParse().getPairs(new String[]{"XXXX      X  X           X X   X"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{6, 2, 11, 1, 3 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
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
		answer = new FieldPairParse().getPairs(new String[]{"XXX XXX XXX XXX XXX"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{ };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
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
/*
Problem Statement

You have been given a document header containing important data that will eventually get stored in a database. 
The data is formatted as follows:
Field Name     Data     Field Name     Data     ...
Field Name     Data     Field Name     Data     ...
...            ...      ...            ...      ...	
That is, each field name column will be followed by the corresponding data column. 
If formatted correctly, the header should contain an even number of columns. 
Each element of data will correspond to a row of values. 
Since there are no terminating characters or field widths in use, it is not obvious where each column begins and ends. 
We have decided to use rectangles of spaces to split each column. 
These rectangles must cover all rows of data, be as wide as possible, and contain only space characters. 
You will return how wide each delimiting rectangle is in a int[]. 
The return value should be ordered left-to-right based on the positions of the corresponding delimeters in data. 
If the number of delimiting rectangles is even, return an empty int[] denoting an error.
*/
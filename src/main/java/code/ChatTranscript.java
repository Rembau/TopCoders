package code;


public class ChatTranscript
{
	public int howMany(String[] transcript, String name)
	{
		int count=0;
		for (String string : transcript) {
			if (string.startsWith(name+":")) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		time = System.currentTimeMillis();
		answer = new ChatTranscript().howMany(new String[]{"Bob: Hello Tim.","Tim: Hello Bob.","Bob: How are ya Tim?","Frank: Stop chatting!"}, "Bob");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ChatTranscript().howMany(new String[]{"Bob: This is a long","sentence that takes 2 lines.","Tim: Yes it is.","Bob : I am not Bob.","Frank: No you aren't!"," Bob: Neither am I."}, "Bob");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ChatTranscript().howMany(new String[]{"Crazy1010: !@LK%#L%K @#L%K @#L%K@#L%K2kl53k2","Bob: You are crazy.","Crazy1010 Yup #@LK%$L!K%LK%!K% !K afmas,"}, "Crazy1010");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ChatTranscript().howMany(new String[]{"A:A:A:A:A:A:A:A:A","b:b:b:b:b:b:b:b:b"}, "B");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ChatTranscript().howMany(new String[]{"A:A:A:A:A:A:A:A:A"}, "A");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
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
//Powered by [KawigiEdit] 2.0!

/*Problem Statement
    
You have received the transcript of an online chat. 
Each element of transcript corresponds to a line. 
You want to know how many times name said something. 
To do this, count how many lines begin with name immediately followed by a colon. 
This comparison is case sensitive.
Definition
    
Class:
ChatTranscript
Method:
howMany
Parameters:
String[], String
Returns:
int
Method signature:
int howMany(String[] transcript, String name)
(be sure your method is public)
    

Constraints
-
transcript will contain between 1 and 50 elements inclusive.
-
Each element of transcript will contain between 1 and 50 characters inclusive.
-
Each character in each element of transcript will have ASCII value between 32 and 126 inclusive.
-
name will contain between 1 and 50 characters inclusive.
-
Each character in name will be a letter (A-Z, a-z) or a digit (0-9).
Examples
0)

    
{
"Bob: Hello Tim.",
"Tim: Hello Bob.",
"Bob: How are ya Tim?",
"Frank: Stop chatting!"
}
"Bob"
Returns: 2
Bob managed to say two things before Frank entered the conversation.
1)

    
{
"Bob: This is a long",
"sentence that takes 2 lines.",
"Tim: Yes it is.",
"Bob : I am not Bob.",
"Frank: No you aren't!",
" Bob: Neither am I."
}
"Bob"
Returns: 1
Only one line begins with "Bob:" (quotes for clarity).
2)

    
{
"Crazy1010: !@LK%#L%K @#L%K @#L%K@#L%K2kl53k2",
"Bob: You are crazy.",
"Crazy1010 Yup #@LK%$L!K%LK%!K% !K afmas,"
}
"Crazy1010"
Returns: 1

3)

    
{
"A:A:A:A:A:A:A:A:A",
"b:b:b:b:b:b:b:b:b"
}
"B"
Returns: 0

4)

    
{"A:A:A:A:A:A:A:A:A"}
"A"
Returns: 1
*/
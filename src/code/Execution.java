package code;

/**
 * 
 * @author Rembau.Lin
 * Inv2002 Round 1 B
 *
 */
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
/**

Problem Statement
    
When solving TopCoder problems, it is always important to make sure that a solution will not exceed the 8 second time limit. Sometimes this is as simple as just looking at the loops in the code and figuring out the maximum number of iterations through the inner most loop. If this number is sufficiently small, then it is obvious that the code will execute in time. However, for other cases, we must consider what the code is doing in the loops, as well as the number of times the loop is executed, to determine whether it will run in the given time frame..
You will be given a String[] containing loops and basic instructions. Loops will be represented as "for(<x>)" where <x> represents an integer and is the number of times the loop is executed. Basic instructions will be represented by the word "BASIC" followed by a semicolon. Loops will always have an accompanying set of braces, '{' and '}', to signify their scope. Thus "for(100){BASIC;BASIC;}" represents a loop which is executed 100 times, and contains two basic instructions. Your method should determine the total number of basic instruction executions in the program. So, for the above example, you would return 200.
Additionally, loops may be nested, just like they are in actual code. In the code, "for(100){BASIC;for(12){BASIC;}}", the outer loop is executed 100 times, and the inner loop is executed 12 times for each execution of the outer loop. Thus, the basic instruction in the inner loop is executed 1200 times, and the basic instruction in the outer loop is executed 100 times, for a total of 1300 basic instructions.
More formally, the input String[] will be a <statement> following the rules below. Note that these rules ignore spaces and line breaks because spaces and line breaks do not effect the semantics of the input.
<statement> ::= <statement><statement> | <for-loop> | <basic> | ""
<for-loop> ::= for(<iter>){<statement>}
<basic> ::= BASIC;
<iter> ::= <non-negative integer>
Definition
    
Class:
Execution
Method:
analyze
Parameters:
String[]
Returns:
long
Method signature:
long analyze(String[] code)
(be sure your method is public)
    

Notes
-
The code may have extra spaces in it, but they will not be within "BASIC;","for", or any numbers. Thus "f or" and "for(1 3)" are invalid, but "for ( 12 ) { }" is valid.
-
Elements of code should be treated as lines of code. Thus, element 0 is the first line, element 1 is the second line, and so on. Line breaks (between two elements) should be treated the same way as spaces. Thus {"for(","10",")","{","BASIC;","}"} is the same as {"for( 10 ) { BASIC; }"}.
-
The simplified version "for(10)BASIC;" (without braces) which works in many programming languages, will not be allowed.
Constraints
-
code will have between 0 and 50 elements, inclusive.
-
Each element of code will be between 1 and 50 characters in length, inclusive.
-
The code will be well-formed similar to what it would have to be in Java, C++, or C#, meaning that every "for(<x>)" will be followed by optional spaces and then a '{'. <x> will be an integer, there will be an equal number of '{' and '}', and aside from the numbers it will be formed solely out of the tokens from: {"BASIC;","for","(",")","{","}"," "}. In other words, it will conform to the grammar given above.
-
All the numbers in the loops will be non-negative integers less than or equal to (2^63)-1 (9223372036854775807)
-
The total number of BASIC; operations will be less than or equal to (2^63)-1.
Examples
0)

    
{"BASIC;for(10){BASIC;}"}
Returns: 11
The first BASIC; element gets executed once, and the second one gets executed 10 times.
1)

    
{"BASIC;"
,"for(10){"
,"  for(100){}"
,"  BASIC;"
,"  for(20){"
,"    BASIC;"
,"    BASIC;"
,"  }"
,"  BASIC;" ,"}"}
Returns: 421
The BASIC; in element 0 gets executed once. The BASIC; in element 3 gets executed 10 times. The ones in elements 5 and 6 each get executed 200 times. The one in element 8 gets executed 10 times. For a total of 1+10+200+200+10 = 421
2)

    
{"for(0){}"}
Returns: 0

3)

    
{"for(10900){}BASIC;"}
Returns: 1

4)

    
{"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
,"BASIC;"
,"}}}}}}}}}}}}}}}}}}}}}}}}}}}}"
,"}}}}}}}}}}}}}}}}}}}}}}}}}}}}"}
Returns: 72057594037927936
There are 7*8 = 56 for(2) statements at the beginning of the this test case. 2^56 = 72057594037927936
5)

    
{"for(0){}"
,"for(1)"
,"{BASIC;"
,"for(5){BASIC;}"
,"for(2){BASIC;}"
,"BASIC;"
,"  for"
,"( 3 ){BASIC;}}"}
Returns: 12

6)

    
{"BASIC;for(7){for(3){}for(0){BASIC;}}"}
Returns: 1

7)

    
{"for(9223372036854775807){BASIC;}"}
Returns: 9223372036854775807
*/

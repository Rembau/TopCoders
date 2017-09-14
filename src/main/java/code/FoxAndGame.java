package code;

public class FoxAndGame {
	public int countStars(String[] result)
	{
		int count=0;
		for (int i = 0; i < result.length; i++) {
			String str = result[i];
			if(str.equals("o--")){
				count+=1;
			} else if(str.equals("oo-")){
				count+=2;
			} else if(str.equals("ooo")){
				count+=3;
			}
		}
		return count;
	}
	public static void main(String[] args) {

	}

}
/*Problem Statement
    
Fox Ciel is playing the popular game 'Cut the Rope' on her smartphone. The game has multiple stages, 
and for each stage the player can gain between 0 and 3 stars, inclusive. 
You are given a String[] result containing Fox Ciel's current results: 
For each stage, result contains an element that specifies Ciel's result in that stage. More precisely, 
result[i] will be "---" if she got 0 stars in stage i, "o--" if she got 1 star, "oo-" if she got 2 stars and "ooo" 
if she managed to get all 3 stars. Return the total number of stars Ciel has at the moment.
Definition
    
Class:
FoxAndGame
Method:
countStars
Parameters:
String[]
Returns:
int
Method signature:
int countStars(String[] result)
(be sure your method is public)*/
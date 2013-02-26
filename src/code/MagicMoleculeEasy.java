package code;

import java.util.HashSet;
import java.util.LinkedList;

public class MagicMoleculeEasy {
	int r=0;
	int k=0;
	int magicPower[];
	public int maxMagicPower(int[] magicPower, String[] magicBond, int k){
		this.k=k;
		this.magicPower = magicPower;
		LinkedList<int[]> relas = new LinkedList<int[]>();
		for (int i = 0; i < magicBond.length-1; i++) {
			for (int j = i+1; j < magicBond.length; j++) {
				if(magicBond[i].charAt(j)=='Y'){
					relas.add(new int[]{i,j});
					System.out.println(i+" "+j);
				}
			}
		}
//		System.out.println();
		f(relas,0);
		if(r==0){
			r=-1;
		}
		return r;
	}
	public void f(LinkedList<int[]> relas,int s){
		if(s==relas.size()){
//			p(relas);
			HashSet<Integer> hi = getNumOfLeft(relas);
			int num = hi.size();
			if(num==k){
				int r_=0;
				for(int i:hi){
					r_+=magicPower[i];
				}
				if(r_>r){
					r=r_;
				}
			}
			return;
		}
		f(relas,s+1);
		swap(relas,s);
		f(relas,s+1);
	}
	public void p(LinkedList<int[]> relas){
		for(int[] r:relas){
			System.out.println(r[0]+" "+r[1]);
		}
		System.out.println("--");
	}
	public void swap(LinkedList<int[]> relas,int s){
		int x = relas.get(s)[0];
		relas.get(s)[0] = relas.get(s)[1];
		relas.get(s)[1] = x;
	}
	public HashSet<Integer> getNumOfLeft(LinkedList<int[]> relas){
		HashSet<Integer> hi = new HashSet<Integer>();
		for(int i[]:relas){
			hi.add(i[0]);
		}
		return hi;
	}
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		time = System.currentTimeMillis();
		answer = new MagicMoleculeEasy().maxMagicPower(new int[]{1, 2}, new String[]{"NY", "YN"}, 1);
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
		answer = new MagicMoleculeEasy().maxMagicPower(new int[]{100, 1, 100}, new String[]{"NYN", "YNY", "NYN"}, 1);
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
		answer = new MagicMoleculeEasy().maxMagicPower(new int[]{100, 1, 100}, new String[]{"NYN", "YNY", "NYN"}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 200;
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
		answer = new MagicMoleculeEasy().maxMagicPower(new int[]{4, 7, 5, 8}, new String[]{"NYNY", "YNYN", "NYNY", "YNYN"}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 15;
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
		answer = new MagicMoleculeEasy().maxMagicPower(new int[]{46474, 60848, 98282, 58073, 42670, 50373}, new String[]{"NYNNNY", "YNNYNY", "NNNYYY", "NYYNNN", "NNYNNN", "YYYNNN"}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 209503;
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
		answer = new MagicMoleculeEasy().maxMagicPower(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new String[]{"NNYYYNYYNYNNY", "NNYNYYYYYYYNY", "YYNYYNYYYYYYY", "YNYNYYNYYYYYY", "YYYYNNYYYYYNY", "NYNYNNYYYYYNN", "YYYNYYNYYYYYY", "YYYYYYYNYNYYY", "NYYYYYYYNYYYY", "YYYYYYYNYNNNN", "NYYYYYYYYNNYN", "NNYYNNYYYNYNN", "YYYYYNYYYNNNN"}, 9);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new MagicMoleculeEasy().maxMagicPower(new int[]{1, 1}, new String[]{"NN", "NN"}, 1);
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
		answer = new MagicMoleculeEasy().maxMagicPower(new int[]{1,1,2,5,2,4,2}, new String[]{"NNNNNNN","NNYNNNN","NYNNNYN","NNNNNNY","NNNNNNN","NNYNNNN","NNNYNNN"}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 11;
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
/*Problem Statement
    
Fox Ciel is learning magical physics. Currently, she studies Magic Molecules. 
Each Magic Molecule consists of some Magic Atoms. Each Magic Atom stores some Magic Power, 
with different atoms possibly storing different amounts of power. Within the molecule, 
some pairs of atoms are connected by bidirectional Magic Bonds.  
Ciel now has a Magic Molecule formed by n Magic Atoms. The atoms are numbered 0 through n-1, inclusive. 
You are given a int[] magicPower with n elements: For each i, 
the amount of power stored in the Magic Atom number i is magicPower[i]. 
You are also given a String[] magicBond with n elements, each containing n characters.
Character j of element i of magicBond is 'Y' if the Magic Atoms i and j are connected by a Magic Bond. 
Otherwise, character j of element i of magicBond is 'N'.  Your task is to improve Ciel's Magic Molecule. 

You have to choose a subset S of the n Magic Atoms so that the following two conditions are met:

You are given a int k. The subset S must contain exactly k atoms.
For each pair of the given n atoms that are connected by a Magic Bond, 
at least one of these two atoms must belong to S.
Your goal is to maximize the total Magic Power stored in the chosen atoms. 
Compute and return the maximum total amount of power. 
If it is impossible to choose a subset of atoms that satisfies the above criteria, return -1 instead.
Definition
    
Class:
MagicMoleculeEasy
Method:
maxMagicPower
Parameters:
int[], String[], int
Returns:
int
Method signature:
int maxMagicPower(int[] magicPower, String[] magicBond, int k)
(be sure your method is public)
    

Constraints
-
k will be between 1 and min(n, 14), inclusive, where n is the number of elements in magicPower.
-
magicPower will contain between 2 and 50 elements, inclusive.
-
Each element in magicPower will be between 1 and 100,000, inclusive.
-
magicBond and magicPower will contain the same number of elements.
-
Each element of magicBond will contain exactly n characters, where n is the number of elements in magicPower.
-
Each element of magicBond will only contain the characters 'Y' and 'N'.
-
For each valid i, magicBond[i][i] will be 'N'.
-
For each valid i and j, magicBond[i][j] will be equal to magicBond[j][i].
Examples
0)

    
{1, 2}
{"NY",
 "YN"}
1
Returns: 2
There are two Magic Atoms and we need to select exactly one of them. Both selections are valid. 
It is better to choose atom 1 (0-based index) since it stores more power.
{4, 7, 5, 8}
{"NYNY",
 "YNYN",
 "NYNY",
 "YNYN"}
2
Returns: 15
    
{100, 1, 100}
{"NYN",
 "YNY",
 "NYN"}
2
Returns: 200

{100, 1, 100}
{"NYN",
 "YNY",
 "NYN"}
1
Returns: 1

0 1
0 3
1 2
2 3
Time: 0.0 seconds
Your answer:
	15
Desired answer:
	15
Match :-)

0 1
0 5
1 3
1 5
2 3
2 4
2 5
Time: 0.0010 seconds
Your answer:
	209503
Desired answer:
	209503
Match :-)

0 2
0 3
0 4
0 6
0 7
0 9
0 12
1 2
1 4
1 5
1 6
1 7
1 8
1 9
1 10
1 12
2 3
2 4
2 6
2 7
2 8
2 9
2 10
2 11
2 12
3 4
3 5
3 7
3 8
3 9
3 10
3 11
3 12
4 6
4 7
4 8
4 9
4 10
4 12
5 6
5 7
5 8
5 9
5 10
6 7
6 8
6 9
6 10
6 11
6 12
7 8
7 10
7 11
7 12
8 9
8 10
8 11
8 12
10 11
*/
package projecteuler;

//import java.util.HashMap;

public class P75 {
/**
It turns out that 12 cm is the smallest length of wire that can be bent to form an 
integer sided right angle triangle in exactly one way, but there are many more examples.
12 cm: (3,4,5)
24 cm: (6,8,10)
30 cm: (5,12,13)
36 cm: (9,12,15)
40 cm: (8,15,17)
48 cm: (12,16,20)

In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, 
and other lengths allow more than one solution to be found; for example, 
using 120 cm it is possible to form exactly three different integer sided right angle triangles.

120 cm: (30,40,50), (20,48,52), (24,45,51)

Given that L is the length of the wire, for how many values of L <= 1,500,000 
can exactly one integer sided right angle triangle be formed?
*/
	static int n=2000;
	static int mark[] = new int[n+1];
	public static void func(){
		int limit_i=n/3;
		for(int i=3;i<limit_i;i++){
			int square_i=i*i;
			for(int j=i+1;;j++){

			}
		}
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

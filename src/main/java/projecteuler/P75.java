package projecteuler;

//import java.util.HashMap;

import org.junit.Test;
import projecteuler.tool.Base;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P75 extends Base {
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
	@Test
	public void func() {
        int n=15000;
        int mark[] = new int[n];
        Arrays.fill(mark, 0);

        long mark1[] = new long[n];
        for (long i = 0; i < mark1.length; i++) {
            mark1[(int)i] = i*i;
        }

        int tem = 0;
        int count = 0;
        List<Integer> list = new LinkedList<>();

        int i1 = n / 3;
        for (int i = 1; i < i1; i ++) {
            int i2 = (n - i) / 2;
            for (int j = i + 1; j < i2; j ++) {

                double sqrt = Math.sqrt(mark1[i] + mark1[j]);

                int b = (int)sqrt;
                if (sqrt - b == 0) {
//                    System.out.println(i + " " + j + " " + sqrt + " == " + (i+j+b));

//                    int xtem = mark[i + j + b];
                    count = count + 1;
//                    sqrt = Math.sqrt(mark1[i] + mark1[j]);

//                    list.add(i + j + b);
                }

            }
        }
        System.out.println(count);
    }

    @Test
    public void f2() {
	    int n = 1500000;

	    for (long i = 0;i < n;i ++) {
//            System.out.println(i);
            for (long j = 0;j < n;j ++) {
//                for (int k = 0;k < n;k ++) {
//
//                }
                double sqrt = Math.sqrt(i * i + j * j);
            }
        }
    }

    @Test
    public void f3() {
        int n = 1500000;
        int count = 0;
        for (long i = 0;i < n;i ++) {
//            System.out.println(i);
            for (long j = 0;j < n;j ++) {
//                for (int k = 0;k < n;k ++) {
//
//                }
//                double sqrt = Math.sqrt(i * i + j * j);
                count ++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void test() {
        double i = 10.5;

        System.out.println(i % 1);
        System.out.println(i % 1.0);
    }
}

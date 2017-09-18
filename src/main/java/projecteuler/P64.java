package projecteuler;

import org.junit.Test;
import projecteuler.tool.Base;

import java.util.Arrays;

public class P64 extends Base {

    @Test
    public void f1() throws InterruptedException {
        int num = 0;
        for (int i = 2;i <= 10000; i++) {
            System.out.println("====" + i);
            int cycleNum = f1_2(i);
            if (cycleNum % 2 == 1) {
                num ++;
            }
        }

        System.out.println(num + " result");
    }

    private int f1_2(int num) {

        int[] first = first(num);
        System.out.println(Arrays.toString(first));

        int bMax  = first[1];

        int a = first[0];
        int b = first[1];
        int c = first[2];

        System.out.println(a);

        int an=0;
        int bn=0;

        int cycleNums[] = null;
        int[] nums = new int[3];

        int i = 0;
        while (true) {
            if (cycleNums != nums && Arrays.equals(cycleNums, nums)) {
                break;
            }
            //Thread.sleep(1000);
            int cn = (num-b*b)/c;
            //System.out.println(cn);
            nums = f1_1(b, an, bn, cn, bMax);
            a = nums[0];
            b = nums[1];
            c = nums[2];
            //System.out.println(Arrays.toString(nums));
            if (a == 0) {
                return 0;
            }

            if (cycleNums == null) {
                cycleNums = nums;
            }
            i++;
        }
        System.out.println(i-1);
        return i - 1;
    }

    private int[] f1_1(int b, int an, int bn, int cn, int bMax) {
        bn = bMax;
        while (bn > 0) {
            if ((b + bn)%cn == 0) {
                an = (b + bn)/cn;
                break;
            }
            bn --;
        }

        return new int[]{an, bn, cn};
    }

    private int[] first(int num) {
        int a = 0;
        int b = 0;
        int c = 1;

        int i = 1;
        while (i * i < num) {
            i++;
        }

        a = i-1;
        b = i-1;

        return new int[]{a, b, c};
    }
}

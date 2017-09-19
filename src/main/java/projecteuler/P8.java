package projecteuler;

import org.junit.Test;
import projecteuler.tool.Base;

import java.util.*;

public class P8 extends Base {

    @Test
    //Õý½â
	public void func(){
		String str=
                "73167176531330624919225119674426574742355349194934" +
				"96983520312774506326239578318016984801869478851843" +
				"85861560789112949495459501737958331952853208805511" +
				"12540698747158523863050715693290963295227443043557" +
				"66896648950445244523161731856403098711121722383113" +
				"62229893423380308135336276614282806444486645238749" +
				"30358907296290491560440772390713810515859307960866" +
				"70172427121883998797908792274921901699720888093776" +
				"65727333001053367881220235421809751254540594752243" +
				"52584907711670556013604839586446706324415722155397" +
				"53697817977846174064955149290862569321978468622482" +
				"83972241375657056057490261407972968652414535100474" +
				"82166370484403199890008895243450658541227588666881" +
				"16427171479924442928230863465674813919123162824586" +
				"17866458359124566529476545682848912883142607690042" +
				"24219022671055626321111109370544217506941658960408" +
				"07198403850962455444362981230987879927244284909188" +
				"84580156166097919133875499200524063689912560717606" +
				"05886116467109405077541002256983155200055935729725" +
				"71636269561882670428252483600823257530420752963450";
        long n=0;
		for (int i = 0; i < str.length()-12; i++) {
			int j=0;
			long m=1;
			while(j<13){
				m*=(str.charAt(i+j)-'0');
				j++;
			}
			if (m > n) {
			    n = m;
                System.out.println(i + "=========== " + n);
            }
		}
		System.out.println(n);
	}

    int num[][] = new int[20][50];
	long maxNum = 0;
    @Test
    public void f2(){
        String str=
                "73167176531330624919225119674426574742355349194934\n" +
                "96983520312774506326239578318016984801869478851843\n" +
                "85861560789112949495459501737958331952853208805511\n" +
                "12540698747158523863050715693290963295227443043557\n" +
                "66896648950445244523161731856403098711121722383113\n" +
                "62229893423380308135336276614282806444486645238749\n" +
                "30358907296290491560440772390713810515859307960866\n" +
                "70172427121883998797908792274921901699720888093776\n" +
                "65727333001053367881220235421809751254540594752243\n" +
                "52584907711670556013604839586446706324415722155397\n" +
                "53697817977846174064955149290862569321978468622482\n" +
                "83972241375657056057490261407972968652414535100474\n" +
                "82166370484403199890008895243450658541227588666881\n" +
                "16427171479924442928230863465674813919123162824586\n" +
                "17866458359124566529476545682848912883142607690042\n" +
                "24219022671055626321111109370544217506941658960408\n" +
                "07198403850962455444362981230987879927244284909188\n" +
                "84580156166097919133875499200524063689912560717606\n" +
                "05886116467109405077541002256983155200055935729725\n" +
                "71636269561882670428252483600823257530420752963450\n";
        String strList[] = str.split("\n");
        int j = 0;
        for (String line : strList) {
            char[] chars = line.toCharArray();
            int numLine[] = new int[50];
            for (int i = 0; i < chars.length; i++) {
                numLine[i] = chars[i] - '0';
            }
            num[j++] = numLine;
            System.out.println(Arrays.toString(numLine));
        }

        for (int col = 0;col < 20;col ++) {
            for (int row = 0;row < 50;row ++) {
                List<Tem> currentList = new LinkedList<>();
                Tem tem = new Tem(row, col);
                currentList.add(tem);
                System.out.println(row + " " + col);
                f2_1(currentList, tem, 1);
            }
        }

        System.out.println(maxNum);
    }

    private void f2_1(List<Tem> currentList, Tem currentTem, int depth) {

//        List<Tem> adjacentList = getAdjacent(currentList, num);
        List<Tem> adjacentList = getAdjacent(currentTem);
        if (depth < 12) {
            for (Tem tem : adjacentList) {
//                System.out.println(num[tem.y][tem.x]);
                if (num[tem.y][tem.x] == 0) {
                    continue;
                }
                List<Tem> newCurrentList = new LinkedList<>(currentList);
                newCurrentList.add(tem);
                f2_1(newCurrentList, tem, depth + 1);
            }
        } else {
            for (Tem tem : adjacentList) {
                long value = num[tem.y][tem.x];
                if (value == 0) {
                    continue;
                }

                long product = getProduct(currentList, value);
                if (product > maxNum) {
                    maxNum = product;
                    for (Tem tem1 : currentList) {
                        System.out.print(num[tem1.y][tem1.x] + " ");
                    }
                    System.out.println();
                    System.out.println(currentList + " " + value + " ========= " + maxNum);
                }
            }
        }
//        System.out.println(adjacentList);
    }

    private long getProduct(List<Tem> currentList, long maxNum) {

        for (Tem tem : currentList) {
            maxNum *= num[tem.y][tem.x];
        }
        return maxNum;
    }

    private List<Tem> getAdjacent(Tem currentTem) {
        List<Tem> adjacentList = new LinkedList<>();
        int x = currentTem.x + 1 ;
        if (x < 50) {
            adjacentList.add(new Tem(x, currentTem.y));
        }
        int y = currentTem.y + 1;
        if (y < 20) {
            adjacentList.add(new Tem(currentTem.x, y));
        }
        return adjacentList;
    }

    private List<Tem> getAdjacent(List<Tem> numList, int num[][]) {
        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();

        for (Tem tem : numList) {
            TreeSet<Integer> colList = colMap.get(tem.x);
            if (colList == null) {
                colList = new TreeSet<>();
                colMap.put(tem.x, colList);
            }
            colList.add(tem.y);

            TreeSet<Integer> rowList = rowMap.get(tem.y);
            if (rowList == null) {
                rowList = new TreeSet<>();
                rowMap.put(tem.y, rowList);
            }
            rowList.add(tem.x);
        }

        List<Tem> adjacentList = new LinkedList<>();
        for (Integer integer : rowMap.keySet()) {
            TreeSet<Integer> integers = rowMap.get(integer);
            Integer last = integers.last() + 1;

            if (last < num[0].length) {
                addAdjacent(last, integer, adjacentList);
            }
        }

        for (Integer integer : colMap.keySet()) {
            TreeSet<Integer> integers = colMap.get(integer);
            Integer last = integers.last() + 1;

            if (last < num.length) {
                addAdjacent(integer, last, adjacentList);
            }
        }

        return adjacentList;
    }

    private void addAdjacent(int x, int y, List<Tem> adjacentList) {
        for (Tem tem : adjacentList) {
            if (tem.x == x && tem.y == y) {
                return;
            }
        }

        adjacentList.add(new Tem(x, y));
    }

    static class Tem {
        int x;
        int y;

        public Tem(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }


    @Test
    public void problem8() {
        StringBuffer baseNumber = new StringBuffer();
        baseNumber.append("73167176531330624919225119674426574742355349194934")
                .append("96983520312774506326239578318016984801869478851843")
                .append("85861560789112949495459501737958331952853208805511")
                .append("12540698747158523863050715693290963295227443043557")
                .append("66896648950445244523161731856403098711121722383113")
                .append("62229893423380308135336276614282806444486645238749")
                .append("30358907296290491560440772390713810515859307960866")
                .append("70172427121883998797908792274921901699720888093776")
                .append("65727333001053367881220235421809751254540594752243")
                .append("52584907711670556013604839586446706324415722155397")
                .append("53697817977846174064955149290862569321978468622482")
                .append("83972241375657056057490261407972968652414535100474")
                .append("82166370484403199890008895243450658541227588666881")
                .append("16427171479924442928230863465674813919123162824586")
                .append("17866458359124566529476545682848912883142607690042")
                .append("24219022671055626321111109370544217506941658960408")
                .append("07198403850962455444362981230987879927244284909188")
                .append("84580156166097919133875499200524063689912560717606")
                .append("05886116467109405077541002256983155200055935729725")
                .append("71636269561882670428252483600823257530420752963450");
        char[] dst = new char[13];
        int actualInit = 0;
        int actualEnd = 13;
        long answer = 0;
        long calc = 0;
        while (actualEnd <= baseNumber.length() -1){
            calc = 1;
            dst = new char[13];
            baseNumber.getChars(actualInit, actualEnd, dst, 0);
            System.out.println(Arrays.toString(dst));
            if(!containsZero(dst)){
                for (int i = 0; i < dst.length; i++){
                    calc = calc * Long.valueOf(String.valueOf(dst[i]));
                }
                if(calc > answer) {
                    answer = calc;
                    System.out.println(Arrays.toString(dst));
                    System.out.println(actualInit + "================" + answer);
                }
                actualInit++;
                actualEnd++;
            }else{
                actualInit = actualInit + String.valueOf(dst).lastIndexOf("0") + 1;
                actualEnd = actualInit + 13;
            }
        }

        System.out.println(answer);
    }

    private boolean containsZero(char[] dst) {
        for (int i = 0; i < dst.length;i++){
            if(Long.valueOf(String.valueOf(dst[i])) == 0)
                return true;
        }
        return false;
    }
}

package projecteuler;

import java.util.Arrays;
import java.util.LinkedList;

public class P60 {
	/**
	 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two
	 * primes and concatenating them in any order the result will always be
	 * prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The
	 * sum of these four primes, 792, represents the lowest sum for a set of
	 * four primes with this property.
	 * 
	 * Find the lowest sum for a set of five primes for which any two primes
	 * concatenate to produce another prime.
	 */
	static boolean[] aps = generatePrime();
	static int ps[] = new int[1100];
	static int len=5;
	public static void func() {
		int r = 0;
		for (int i = 2; r < ps.length; i++) {
			if (!aps[i]) {
				ps[r] = i;
				// System.out.println(i);
				r++;
			}
		}
		System.out.println("start");
		getP(0, new LinkedList<Integer>(), len-1);
		System.out.println("end getP()");
		int min = Integer.MAX_VALUE;
		for (P p : pps) {
			Integer pp[] = p.ps;
			if (judge(pp)) {
				int t = 0;
				for (int l = 0; l < pp.length; l++) {
					t += pp[l];
					System.out.print(pp[l]+" ");
				}
				System.out.println();
				if (t <= min) {
					min = t;
				}
			} else{
				for (int l = 0; l < pp.length; l++) {
					System.out.print(pp[l]+" ");
				}
				System.out.println();
			}
		}
		System.out.println(min+"--------------");
	}

	static LinkedList<P> pps = new LinkedList<P>();

	public static void getP(int index, LinkedList<Integer> list, int level) {
		if (list.size() == len) {
			P p = new P(list);
			System.out.println(p.sum);
			System.out.println(System.currentTimeMillis()-i+"ms");
			return;
		}
		for (int i = index; i < ps.length - level; i++){
			list.add(ps[i]);
			// System.out.println(i);
			Integer ns[]=new Integer[list.size()];
			list.toArray(ns);
			if(!judge(ns)){
				list.remove(new Integer(ps[i]));
				continue;
			}
			getP(i + 1, list, level - 1);
			list.remove(new Integer(ps[i]));
		}
	}

	public static boolean judge(Integer[] ns) {
		for (int i = 0; i < ns.length-1; i++) {
			for (int j = i + 1; j < ns.length; j++) {
				try{
					if (aps[Integer.valueOf(ns[i] + "" + ns[j])]
							|| aps[Integer.valueOf(ns[j] + "" + ns[i])]) {
						return false;
					}
				} catch(Exception e){
					System.out.println(e+" "+ns[i]+" "+ns[j]);
				}
			}
		}
		return true;
	}

	public static boolean[] generatePrime() {
		int n = 100000000;
		boolean d[] = new boolean[n];
		Arrays.fill(d, false);
		for (int i = 4; i < n; i += 2) {
			d[i] = true; // 把除了2的偶数都标记为丢弃
		}
		int x = (int) Math.sqrt(n);
		for (int i = 3; i <= x; i += 2) {
			if (!d[i]) { // 如果没有标记则是素数
				for (int j = i * i; j < n; j += 2 * i) { // 小于i的倍数
															// 在之前已经处理了，这里的i，j一定是奇数如果加上个i
															// 变为偶数，偶数直接可以跳过
					d[j] = true;
				}
			}
		}
		return d;
	}
	static long i =System.currentTimeMillis();
	public static void main(String[] args) {
		System.out.println(i);
		func();
	}

	static class P implements Comparable<P> {
		Integer[] ps = new Integer[len];
		int sum;

		public P(LinkedList<Integer> list) {
			list.toArray(ps);
			for (Integer integer : list) {
				sum += integer;
			}
		}

		public int compareTo(P p) {
			return sum - p.sum;
		}

	}
}

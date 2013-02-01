package code;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author Administrator Description:把中缀表达式转换成后缀表达式
 * 首字符為括號時，有bug.
 */
public class T_1 {
	String c[];
	Stack<String> s1 = new Stack<String>();
	Stack<String> s2 = new Stack<String>();
	int top = 0;

	/**
	 * Description:构造函数
	 * 
	 * @param expression
	 *            :表达式字符串
	 */
	public T_1(String expression) {
		ArrayList<String> al = new ArrayList<String>();
		char chare[] = expression.toCharArray();
		int count = 0;
		int i = 0;
		int start = 0;
		while (count < chare.length) {
			if (!judgeNum(new String(new char[] { chare[count] }))) {
				if (i != 0) {
					char c1[] = new char[i];
					System.arraycopy(chare, start, c1, 0, i);
					al.add(new String(c1));
				}
				al.add(new String(new char[] { chare[count] }));
				i = 0;
				start = count + 1;
			} else {
				i++;
			}
			count++;
		}
		if (judgeNum(new String(new char[] { chare[--count] }))) {
			al.add(new String(new char[] { chare[count] }));
		}
		// c=(String[])(al.toArray());
		System.out.println(al.toString());
		c = new String[al.size()];
		i = 0;
		for (Object o : al.toArray()) {
			c[i++] = o.toString();
		}
	}

	/**
	 * Description:转换,c为中缀表达式
	 */
	public void transition() {
		int i = 0;
		while (i < c.length) {
			if (s1.empty()) {
				s1.push(c[i]);
			} else {
				if (judgeNum(c[i])) {
					s1.push(c[i]);
				} else if (judgeOperate(c[i])) {
					if (s2.isEmpty()) {
						s2.push(c[i]);
					} else if (judgeLP(s2.peek())) {
						s2.push(c[i]);
					} else if (judgePriority(c[i], s2.peek())) {
						s2.push(c[i]);
					} else {
						s1.push(s2.pop());
						while (!s2.isEmpty() && !s2.peek().equals("(")) {
							if (!judgePriority(c[i], s2.peek())) {
								s1.push(s2.pop());
							} else {
								break;
							}
						}
						s2.push(c[i]);
					}
				} else if (judgeLP(c[i])) {
					s2.push(c[i]);
				} else if (judgeRP(c[i])) {
					while (true) {
						String c_1 = s2.pop();
						if (!judgeLP(c_1)) {
							s1.push(c_1);
							System.out.println("c_1" + c_1);
						} else {
							break;
						}
					}
				}
			}
			i++;
		}
		while (!s2.isEmpty()) {
			String c_1 = s2.pop();
			if (!judgeLP(c_1)) {
				s1.push(c_1);
			}
		}
	}

	/**
	 * 
	 * @param c
	 * @return:是否是数字
	 */
	public boolean judgeNum(String c) {
		try {
			Integer.parseInt(c);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 
	 * @param c
	 * @return:是否是运算符
	 */
	public boolean judgeOperate(String c) {
		if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param c
	 * @return:是否是左括号
	 */
	public boolean judgeLP(String c) {
		if (c.equals("(")) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param c
	 * @return:是否是右括号
	 */
	public boolean judgeRP(String c) {
		if (c.equals(")")) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return:是否a的优先级大于b
	 */
	public boolean judgePriority(String a, String b) {
		if ((a.equals("*") || a.equals("/"))
				&& (b.equals("+") || b.equals("-"))) {
			return true;
		}
		return false;
	}

	/**
	 * 运算
	 */
	public void operate() {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		/*
		 * while(!judgeNum(s2.peek())){ s1.push(s2.pop()); }
		 */
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		while (!s2.isEmpty()) {
			String s = s2.pop();
			if (judgeNum(s)) {
				s1.push(s);
			} else {
				String a = s1.pop();
				String b = s1.pop();
				s1.push(operate_(b, a, s));
				System.out.println(s1.peek());
			}
		}
		System.out.println(s1.pop());
	}

	public String operate_(String a, String b, String c) {
		int ia = Integer.parseInt(a);
		int ib = Integer.parseInt(b);
		if (c.equals("+")) {
			return String.valueOf(ia + ib);
		} else if (c.equals("-")) {
			return String.valueOf(ia - ib);
		} else if (c.equals("*")) {
			return String.valueOf(ia * ib);
		} else if (c.equals("/")) {
			return String.valueOf(ia / ib);
		}
		return "";
	}

	public static void main(String[] args) {
		//String s = JOptionPane.showInputDialog("请输入表达式!");
		String s = "((4+1)*1)+5";
		T_1 t = new T_1(s);// "1+2+3*1+(2-1*4)*2+2"
		t.transition();
		t.operate();
	}
}

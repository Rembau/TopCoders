package projecteuler;

public class P19 {
	public static void func() {
		int x = 2;
		int count = 0;
		for (int i = 1901; i <= 2000; i++) {
			for (int j = 1; j <= 12; j++) {
				int days;
				switch (j) {
				case 2:
					if ((i % 4 == 0 && (i % 100 != 0)) || i % 400 == 0) {
						days=29;
					} else {
						days=28;
					}
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					days = 31;break;
					default: days=30;break;
				}
				System.out.println(days);
				x = (days + x ) % 7;
				if(x==0){
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		func();
	}

}

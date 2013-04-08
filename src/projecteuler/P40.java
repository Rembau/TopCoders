package projecteuler;

public class P40 {
//0.123456789101112131415161718192021...
	//d1  d10  d100  d1000  d10000  d100000  d1000000
	public static void func(){
		int m[] = new int[]{1,10,100,1000,10000,100000,1000000};
		int v[]=new int[10];
		v[0]=1;
		int len =1;
		int r=1;
		int current=0;
		for (int i = 1;;) {
			for (int j = len-1; j >= 0; j--) {
				if(i==m[current]){
					current++;
					r*=v[j];
				}
				if(current>=m.length){
					System.out.println(r);
					return;
				}
				i++;
			}
			for (int j = 0; j < v.length; j++) {
				v[j]++;
				if(v[j]==10){
					v[j]=0;
				} else if(j==len && v[j]==1){
					len++;
					break;
				} else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		long i = System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
	int[] digitsPerDecade = new int[7];


    public int getAnswer(){
        fillDigitsPerDecade();
        int product = digit(1) * digit(10) * digit(100) * digit(1000) * 
          digit(10000) * digit(100000) * digit(1000000) *digit(10000000);
        return product;
    }
    
    private void fillDigitsPerDecade(){
        digitsPerDecade[0] = 9;
        digitsPerDecade[1] = 90*2;
        digitsPerDecade[2] = 900*3;
        digitsPerDecade[3] = 9000*4;
        digitsPerDecade[4] = 90000*5;
        digitsPerDecade[5] = 900000*6;
        digitsPerDecade[6] = 9000000*7;
    }
    
    private int digit(int n){
        int i = 0;
        int base = 1;
        int digitsPerNumber = 1;
        while (n > digitsPerDecade[i]) {
            n -= digitsPerDecade[i++];
            base *= 10;
            digitsPerNumber++;
        }
        int numberOrder = (n-1) / digitsPerNumber + 1;
        int digitOrder = (n-1) % digitsPerNumber;
        int number = base + numberOrder - 1;
        String rep = String.valueOf(number);
        return digitVal(rep.charAt(digitOrder));
    }
    
    private int digitVal(char ch){
        return (int) ch - (int) '0';
    }
}

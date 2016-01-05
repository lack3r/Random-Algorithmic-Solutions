
public class AddWithoutPlus {

	static public int addLeFast(int n1, int n2){
		int res = (n1^n2);
		int reminder=(n1&n2)<<1;
		while (reminder!=0){
			int origRes = res;
			res = (res^reminder);
			reminder=(origRes&reminder)<<1;
		}
		return res;
	}

	static public int addLeFast2(int n1, int n2){
		int res = (n1|n2)&~(n1&n2);
		int reminder=(n1&n2)<<1;
		while (reminder!=0){
			int origRes = res;
			res = (res|reminder)&~(res&reminder);
			reminder=(origRes&reminder)<<1;
		}
		return res;
	}
	
	
	static public int add(int n1, int n2){
		int res = 0;
		int mask =1;
		int p=0;
		for (int i=0;i<=31;i++){
			int bit1 = n1&mask;
			int bit2 = n2&mask;
			int xored = (bit1^bit2^p)<<i;
			res = res|xored;
			n1>>=1;
			n2>>=1;
			p=(bit1&bit2)|(p&bit1)|(p&bit2);
		}
		return res;
	}
	public static void main(String[] args) {
		int a=-3;
		int b=4356;
		System.out.println(add(a, b));
		System.out.println(addLeFast(a, b));
	}

}

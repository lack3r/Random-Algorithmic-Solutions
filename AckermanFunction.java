//The recursive Ackermann function as described here: https://en.wikipedia.org/wiki/Ackermann_function
public class AckermanFunction {
	
	public long A(long m, long n) throws Exception{
		if (m<0 || n<0) {throw new Exception("Both numbers should be positive");}
		
		if (m==0){return n+1;}
		if (n==0){return A(m-1,1);}
		else{return A(m-1,A(m,n-1));
		}
	}
	
	public static void main(String[] args) {
		try {
			//Example
			System.out.println(new AckermanFunction().A(3,8));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

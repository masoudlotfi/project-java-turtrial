
public class Fibonacci {
	public static long calc(long n){
		if (n <= 1) return n;
        else return calc(n-1) + calc(n-2);
	}
}

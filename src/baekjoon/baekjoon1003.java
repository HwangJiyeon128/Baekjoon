package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon1003 {

	static int One, Zero;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), test = 0;
		
		while(test++ < T) {
			int N = Integer.parseInt(br.readLine());
			One = 0;
			Zero = 0;
			fibo(N);
			System.out.println(Zero+" "+One);
		}
	}

	public static int fibo(int n) {
		if(n==0) {
			Zero++;
			return 0;
		}
		if(n==1) {
			One++;
			return 1;
		}
		return fibo(n-1)+fibo(n-2);
	}
}

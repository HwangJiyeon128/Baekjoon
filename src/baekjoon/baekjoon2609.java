package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int val1 = func1(a, b);
		int val2 = val1*(a/val1)*(b/val1);
		System.out.println(val1);
		System.out.println(val2);
	}
	
	public static int func1 (int num1, int num2) {
		if(num1%num2==0)
			return num2;
		return func1(num2, num1%num2);
	}
}

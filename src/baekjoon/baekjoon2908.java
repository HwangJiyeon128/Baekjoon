package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class baekjoon2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String strA = input[0];
		String strB = input[1];
		strA = (new StringBuffer(strA)).reverse().toString();
		strB = (new StringBuffer(strB)).reverse().toString();
		int A = Integer.parseInt(strA);
		int B = Integer.parseInt(strB);
		if(A>B)
			System.out.println(A);
		else
			System.out.println(B);
	}

}

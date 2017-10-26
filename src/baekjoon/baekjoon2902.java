package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class baekjoon2902 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		stack.push(input.charAt(0));
		for(int i=1; i<input.length()-1; i++) {
			if(input.charAt(i)=='-')
				stack.push(input.charAt(i+1));
		}
		for(char x: stack)
			System.out.print(x);
		System.out.println();
	}

}

package baekjoon;

import java.util.*;
/*
 * 좋은 단어
 */
//STACK
public class baekjoon3986_stack {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt(), result = 0;
		String[] str = new String[num];
		Stack <Character> stack = new Stack<> ();
		
		for(int i=0; i<num; i++) {
			str[i] = scanner.next();
		}
		
		for(int i=0; i<num; i++) {
			String tmp = str[i];
			int length = str[i].length();
			
			stack.push(tmp.charAt(0));
			for(int j=1; j<length; j++) {
				char tmpChar = tmp.charAt(j);
				if(stack.isEmpty())
					stack.push(tmpChar);
				else if(stack.peek()==tmpChar) {
					stack.pop();
				}
				else
					stack.push(tmpChar);
			}
			if(stack.isEmpty())
				result++;
			stack.clear();
		}
		System.out.println(result);
		
		
	}

}

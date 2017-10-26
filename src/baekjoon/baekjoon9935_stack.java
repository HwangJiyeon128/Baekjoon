package baekjoon;

import java.util.*;

/*
 * 문자열 폭발
 */

public class baekjoon9935_stack {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();//문자열
		String delStr = scanner.nextLine();//폭발문자열
		
		Stack<String> stack = new Stack<String>();
		Stack<String> delStack = new Stack<String>();
		
		for(int i=0; i<delStr.length(); i++)
			delStack.push(Character.toString(delStr.charAt(i)));
		
		int delSize = delStr.length();
		
		for(int i=0; i<inputStr.length(); i++) {
			char val = inputStr.charAt(i);
			stack.push(Character.toString(val));
			
			//맨 마지막 글자와 비교
			if(val == delStr.charAt(delSize-1)) {

				//이전글자가 삭제할 글자와 같은지 비교
				if(delSize<=stack.size() && stack.subList(stack.size()-delSize, stack.size()).equals(delStack)) {
					for(int j=0; j<delSize; j++)
						stack.pop();
				}
			}
		}
		if(stack.isEmpty())
			System.out.println("FRULA");
		else {
			for(String obj : stack){
			    System.out.print(obj);
			}
		}
	}
}

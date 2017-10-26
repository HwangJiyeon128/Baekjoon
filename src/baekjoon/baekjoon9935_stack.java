package baekjoon;

import java.util.*;

/*
 * ���ڿ� ����
 */

public class baekjoon9935_stack {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();//���ڿ�
		String delStr = scanner.nextLine();//���߹��ڿ�
		
		Stack<String> stack = new Stack<String>();
		Stack<String> delStack = new Stack<String>();
		
		for(int i=0; i<delStr.length(); i++)
			delStack.push(Character.toString(delStr.charAt(i)));
		
		int delSize = delStr.length();
		
		for(int i=0; i<inputStr.length(); i++) {
			char val = inputStr.charAt(i);
			stack.push(Character.toString(val));
			
			//�� ������ ���ڿ� ��
			if(val == delStr.charAt(delSize-1)) {

				//�������ڰ� ������ ���ڿ� ������ ��
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

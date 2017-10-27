package baekjoon;

import java.util.*;

public class baekjoon1316 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		int result = testCase;
		String[] str = new String[testCase];
		for(int i=0; i<testCase; i++) {
			Stack<Character> checkStack = new Stack<>();
			str[i] = scanner.next();
			
			for(int j=0; j<str[i].length(); j++) {
				char tmp = str[i].charAt(j);
				if(checkStack.search(tmp)<0) {
					checkStack.push(tmp);
				}
				else {
					if(str[i].charAt(j-1) != tmp) {
						result--;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}

}

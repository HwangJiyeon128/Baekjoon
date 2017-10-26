package baekjoon;

import java.util.*;

public class baekjoon2002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		//int[] count = new int[N];
		
		Stack<String> beforeStack = new Stack<String>();
		Stack<String> afterStack = new Stack<String>();
		int cnt=0;
		
		for(int i=0; i<N; i++) {
			beforeStack.push(scanner.next());
		}
		for(int i=0; i<N; i++) {
			afterStack.push(scanner.next());
		}
		
		//compare
		for(int i=0; i<N; i++) {
			if(beforeStack.peek() != afterStack.peek()) {
				cnt++;
				beforeStack.pop();
				afterStack.removeElementAt(afterStack.indexOf(beforeStack.peek()));
				//afterStack.remove(afterStack.indexOf(beforeStack.peek()));
			}
			else {
				beforeStack.pop();
				afterStack.pop();
			}
		}

		
		System.out.println(cnt);
//		for(int a=0; a<N; a++)
//			System.out.println(count[a]);
	}

}

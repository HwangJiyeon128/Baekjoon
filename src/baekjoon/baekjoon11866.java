package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.IOException;

public class baekjoon11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> answer = new LinkedList<Integer>();
		for(int i=1; i<=N; i++)
			list.add(i);
		
		int index = M-1;
		while(!list.isEmpty()) {
			answer.add(list.remove(index--));
			index += M;
			if(list.size()==0)
				break;
			if(list.size()==1) {
				answer.add(list.remove(0));
				break;
			}
			while(index >= list.size())
				index -= list.size();
		}
		
		String ans = "<";
		for(int x: answer) {
			ans+=Integer.toString(x)+", ";
		}
		ans = ans.substring(0, ans.length()-2)+">";
		System.out.println(ans);
	}

}

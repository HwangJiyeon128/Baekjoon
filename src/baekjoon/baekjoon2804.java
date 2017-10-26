package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class baekjoon2804 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		ArrayList<Character> word2 = new ArrayList<Character>();
		for(int i=0; i<input[1].length(); i++) {
			word2.add(input[1].charAt(i));
		}
		ArrayList<Character> word1 = new ArrayList<Character>();
		int y=0, x=0;
		for(int i=0; i<input[0].length(); i++) {
			char tmp = input[0].charAt(i); 
			word1.add(tmp);
			if(word2.contains(tmp)) {
				x = i;
				y = word2.indexOf(tmp);
				break;
			}
		}
		for(int i=0; i<input[1].length(); i++) {
			for(int j=0; j<input[0].length(); j++) {
				if(i==y)
					System.out.print(input[0].charAt(j));
				else if(j==x)
					System.out.print(input[1].charAt(i));
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}

}

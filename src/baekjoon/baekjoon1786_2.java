package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class baekjoon1786_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		String str = br.readLine();
		String pattern = br.readLine();
		
		for(int i=0; i<=str.length()-pattern.length(); i++) {
			String tmp = str.substring(i, i+pattern.length());
			if(tmp.equals(pattern))
				list.add(i+1);
		}
		
		System.out.println(list.size());
		for(int x: list)
			System.out.print(x+" ");
		System.out.println();
	}

}

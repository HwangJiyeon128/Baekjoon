package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class baekjoon11478 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Queue<String> q = new LinkedList<String>();
		
		for(int i=1; i<=str.length(); i++) {
			for(int j=0; j<=str.length()-i; j++) {
				String tmp = str.substring(j, j+i);
				if(!q.contains(tmp))
					q.add(tmp);
			}
		}
		System.out.println(q.size());
	}

}

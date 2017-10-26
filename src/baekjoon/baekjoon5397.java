package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Å°·Î°Å
 */

import java.util.*;

public class baekjoon5397 {

	public static void main(String[] args) {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int testCase = 0;
		try {
			testCase = Integer.parseInt(buffer.readLine());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		while(testCase-- > 0) {
			String str = null;
			try {
				str = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			char[] strArray = str.toCharArray();
			LinkedList linkedlist = new LinkedList();
			int cur = 0, len = str.length();
			
			for(int i = 0; i<len; i++) {
				//char ch = str.charAt(i);
				char ch = strArray[i];
				if(ch == '<') {
					if(cur > 0)
						cur--;
					continue;
				}
				else if(ch == '>') {
					if(cur < linkedlist.size())
						cur++;
					continue;
				}
				else if(ch == '-'){
					if(linkedlist != null && cur>0) {
						linkedlist.remove(--cur);
					}
					continue;
				}
				else {
					linkedlist.add(cur, ch);
					cur++;
				}
			}
			for(int i=0; i<linkedlist.size();i++) {
				System.out.print(linkedlist.get(i));
			}
			System.out.println(" ");
		}
	}

}

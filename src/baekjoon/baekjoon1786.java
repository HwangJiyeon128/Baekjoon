package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class baekjoon1786 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pattern = br.readLine();
		kmp(str, pattern);
	}

	public static void kmp(String str, String pattern) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		int n = str.length(), m = pattern.length(), j = 0;
		int[] pi = getPi(pattern);
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		for(int i=0; i<n; i++) {
			while(j>0 && s[i]!=p[j]) {
				j = pi[j-1];
			}
			if(s[i] == p[j]) {
				if(j == m-1) {
					index.add(i-m+2);
					i = i-m+1;
					j = 0;
				}
				else
					j++;
			}
		}
		
		System.out.println(index.size());
		for(int x: index)
			System.out.print(x+" ");
		System.out.println();
	}
	
	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		char[] p = pattern.toCharArray();
		int j = 0, m = pattern.length();
		
		for(int i=1; i<m; i++) {
			while(j>0 && p[i]!=p[j]) {
				j = pi[j-1];
			}
			if(p[i]==p[j]) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
}

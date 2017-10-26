package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 2*n Å¸ÀÏ¸µ
 */

public class baekjoon11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(countTile(n));
	}
	
	public static int countTile (int n) {
		int[] d = new int[n+1];
		d[1] = 1;
		if(n >= 2)
			d[2] = 2;
		
		for(int i=3; i<=n; i++) {
			d[i] = (d[i-1] + d[i-2]) % 10007;
		}
		return d[n];
	}
}

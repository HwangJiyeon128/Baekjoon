package baekjoon;

import java.util.*;

/*
 * ¿¬¼ÓÇÕ
 */

public class baekjoon1912 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] d = new int[n];
		
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		
		d[0] = num[0];
		for(int i=1; i<n; i++) {
			if(num[i]>d[i-1]+num[i]) {
				d[i] = num[i];
			}
			else {
				d[i] = d[i-1]+num[i];
			}
		}
		
		Arrays.sort(d);
		System.out.println(d[n-1]);
	}

}

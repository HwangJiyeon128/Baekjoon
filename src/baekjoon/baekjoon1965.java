package baekjoon;

/*
 * 상자넣기
 */

import java.util.*;

public class baekjoon1965 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int box = scanner.nextInt();
		int[] value = new int[box];
		int[] result = new int[box];
		for(int i=0; i<box; i++) {
			value[i] = scanner.nextInt();
		}
		
		for(int i=0; i<box; i++) {
			result[i] = 1;
			for(int j=0; j<=i; j++) {
				if(value[i]>value[j] && result[i]<result[j]+1) {
					result[i]++;
				}
			}
		}
		Arrays.sort(result);
		System.out.println(result[box-1]);
	}

}

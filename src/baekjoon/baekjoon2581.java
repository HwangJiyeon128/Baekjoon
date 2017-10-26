package baekjoon;

import java.util.*;

public class baekjoon2581 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int min = 0, sum = 0, i, j;

		if (M == 1)
			M++;
		
		for (i = M; i <= N; i++) {
			j = 2;
			while (j != i) { if (i % j++ == 0) break; }
			
			if (j == i) {
				sum += j;
				if (min==0) min = j;
			}
		}
		
		if(sum==0)
			System.out.println("-1");
		else
			System.out.println(sum + "\n" + min);
	}

}

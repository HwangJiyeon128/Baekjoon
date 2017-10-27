package baekjoon;

import java.util.*;

public class baekjoon11052 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(), i, j;
		int max[] = new int[n+1];
		int data[] = new int[n+1];
		
		for(i=1; i<=n; i++)
			data[i] = scanner.nextInt();
		
		max[0] = 0;
		for(i=1; i<=n; i++) {
			for(j=1; j<=i; j++) {
				if(max[i] < max[i-j]+data[j])
					max[i] = max[i-j]+data[j];
			}
		}
		
		System.out.println(max[n]);
	}
	
	public static int MaxValue(int v1, int v2) {
		if(v1>v2)
			return v1;
		return v2;
	}

}

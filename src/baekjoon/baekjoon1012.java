package baekjoon;

import java.util.*;

/*
 * À¯±â³ó ¹èÃß
 */
public class baekjoon1012 {

	static int[][] data;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T-- > 0) {
			
			int count = 0;
			int M = scanner.nextInt();
			int N = scanner.nextInt();

			data = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					data[i][j] = 0;
				}
			}

			int K = scanner.nextInt();
			while(K-- > 0) {
				int X = scanner.nextInt();
				int Y = scanner.nextInt();
				data[Y][X] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(data[i][j] == 1) {
						count++;
						cabbage(i, j, M, N);
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void cabbage(int a, int b, int width, int height) {
		int nextA = a, nextB = b;
		int[] q = new int[] {0, 0, -1, 1};
		int[] w = new int[] {-1, 1, 0, 0};
		
		data[a][b] = 0;
		
		
		for(int i=0; i<4; i++) {
			nextA = a+q[i];
			nextB = b+w[i];
			if((nextB<width) && (nextA<height) && (nextB>=0) && (nextA>=0) && data[nextA][nextB]==1)
				cabbage(nextA, nextB, width, height);
		}
		
		return ;
		
	}
}

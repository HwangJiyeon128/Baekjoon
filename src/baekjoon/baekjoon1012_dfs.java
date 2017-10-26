package baekjoon;

import java.util.*;

public class baekjoon1012_dfs {

	static int T, M, N, K;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		
		while(T-- > 0) {
			int cnt = 0;
			M = scanner.nextInt();//X
			N = scanner.nextInt();//Y
			K = scanner.nextInt();
			map = new int[N][M];
			
			while(K-- > 0) {
				int X = scanner.nextInt();
				int Y = scanner.nextInt();
				map[Y][X] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			
		}
	}
	
	public static void DFS(int y, int x) {
		map[y][x] = 0;
		
		for(int i=0; i<4; i++) {
			int tmpX = x + dx[i];
			int tmpY = y + dy[i];
			
			if(checkRange(tmpX, tmpY))
				DFS(tmpY, tmpX);
		}
	}
	
	public static boolean checkRange(int x, int y) {
		if(x>=0 && y>=0 && x<M && y<N && map[y][x]==1)
			return true;
		return false;
	}

}

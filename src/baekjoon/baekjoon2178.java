package baekjoon;

/*
 * ¹Ì·ÎÅ½»ö
 */

import java.util.*;

public class baekjoon2178 {

	static int[][] map, check;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		check = new int[N][M];
		for(int i=0; i<N; i++) {
			String tmp = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		bfs(0, 0);
		System.out.println(check[N-1][M-1]);
	}

	public static void bfs(int y, int x) {
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qx = new LinkedList<Integer>();
		
		qy.add(y);
		qx.add(x);
		check[y][x] = 1;
		
		while(!qy.isEmpty() && !qx.isEmpty()) {
			int Y = qy.poll();
			int X = qx.poll();
			
			for(int i=0; i<4; i++) {
				int nextY = Y+dy[i];
				int nextX = X+dx[i];
				
				if(nextX>=0 && nextY>=0 && nextX<M && nextY<N) {
					if(map[nextY][nextX]==1 && check[nextY][nextX]==0) {
						qy.add(nextY);
						qx.add(nextX);
						check[nextY][nextX] = check[Y][X]+1;
					}
				}
			}
		}
	}
}

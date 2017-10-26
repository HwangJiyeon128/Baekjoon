package baekjoon;

import java.util.*;

public class baekjoon4963 {

	static int w=0, h=0, cnt;
	static int[][] map, check;
	static int[] dx = { 1, -1, 0, 0, 1, -1, -1, 1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();

		while (w!=0 && h!=0) {
			cnt = 0;
			map = new int[h][w];
			check = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && check[i][j] == 0) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);
			w = sc.nextInt();
			h = sc.nextInt();
		}
	}

	public static void bfs(int y, int x) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();

		qx.add(x);
		qy.add(y);
		check[y][x] = cnt;
		
		while (!qx.isEmpty() && !qy.isEmpty()) {
			int X = qx.poll();
			int Y = qy.poll();
			for (int i = 0; i < 8; i++) {
				int nextX = X + dx[i];
				int nextY = Y + dy[i];
				if (nextX >= 0 && nextY >= 0 && nextX < w && nextY < h) {
					if (map[nextY][nextX]==1 && check[nextY][nextX]==0) {
						check[nextY][nextX] = cnt;
						qx.add(nextX);
						qy.add(nextY);
					}
				}
			}
		}
	}
}

package baekjoon;

/*
 * 영역 구하기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class baekjoon2583 {

	static int[][] map, visit;
	static int M, N, K;
	
	static class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		map = new int[M][N];
		visit = new int[M][N];
		
		while(K-- > 0) {
			String[] input2 = br.readLine().split(" ");
			int x1 = Integer.parseInt(input2[0]);
			int y1 = Integer.parseInt(input2[1]);
			int x2 = Integer.parseInt(input2[2]);
			int y2 = Integer.parseInt(input2[3]);
			y1 = M-1-y1;
			y2 = M-y2;
			x2 = x2-1;
			makeMap(y1, x1, y2, x2);
		}
		
		int cnt = 0;
		int[] val = new int[M*N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0 && visit[i][j]==0) {
					val[cnt++] = bfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
		Arrays.sort(val);
		for(int i=0; i<val.length; i++) {
			if(val[i]>0)
				System.out.print(val[i]+" ");
		}
	}
	
	public static void makeMap(int y1, int x1, int y2, int x2) {
		for(int i=y1; i>=y2; i--) {
			for(int j=x1; j<=x2; j++) {
				map[i][j]++;
			}
		}
	}
	
	public static int bfs(int y, int x) {
		Queue<Pair> q = new LinkedList<Pair>();
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		int area = 1;
		
		q.add(new Pair(y, x));
		visit[y][x] = 1;
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int Y = pair.y;
			int X = pair.x;
			
			for(int i=0; i<4; i++) {
				int nextY = Y + dy[i];
				int nextX = X + dx[i];
				if(nextY>=0 && nextX>=0 && nextY<M && nextX<N) {
					if(visit[nextY][nextX]==0 && map[nextY][nextX]==0) {
						visit[nextY][nextX]++;
						q.add(new Pair(nextY, nextX));
						area++;
					}
				}
			}
		}
		return area;
	}
}

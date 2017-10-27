package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon10451 {
	
	static int[][] num, visit;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int N, circle;
	
	static class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			num = new int[N][N];
			visit = new int[N][N];
			String[] input = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				int j = Integer.parseInt(input[i])-1;
				num[i][j] = 1;
			}
			
			circle = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(num[i][j]==1 && visit[i][j]==0) {
						bfs(i, j);
					}
				}
			}
			System.out.println(circle);
		}
	}

	public static void bfs(int y, int x) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(x, y));
		visit[y][x] = 1;
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			int X = pair.x;
			int Y = pair.y;
			
			for(int i=0; i<N; i++) {
				if(num[Y][i]==1 && visit[Y][i]==0) {
					queue.add(new Pair(i, Y));
					visit[Y][i] = 1;
				}
				if(Y == y) {
					circle++;
					return;
				}
			}
		}
	}
}

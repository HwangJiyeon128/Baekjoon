package baekjoon;

/*
 * ≈‰∏∂≈‰
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon7576 {

	static int M, N;
	static int[][] tomato, date;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	static class Pair {
		int x, y;
		Pair(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MN = br.readLine().split(" ");
		M = Integer.parseInt(MN[0]);
		N = Integer.parseInt(MN[1]);
		tomato = new int[N][M];
		date = new int[N][M];
		int answer = 0, ch = 0;
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				tomato[i][j] = Integer.parseInt(input[j]);
				date[i][j] = -1;
				if(tomato[i][j]==1)
					ch++;
			}
		}
		if(ch != M*N) {
		
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(tomato[i][j]==1)
						bfs(i, j);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(date[i][j]==-1 && tomato[i][j]==0) {
						answer = -1;
						i = N; j = M;
					}
					else if(answer < date[i][j])
						answer = date[i][j];
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					
					System.out.print(date[i][j]);
				}
				System.out.println();
			}
		}
		else {
			answer = 0;
		}
		System.out.println(answer);
	}
	
	public static void bfs(int y, int x) {
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] visit = new int[N][M];
		visit[y][x] = 1;
		date[y][x] = 0;
		q.add(new Pair(y, x));
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int Y = pair.y;
			int X = pair.x;
			
			for(int i=0; i<4; i++) {
				int nextY = Y+dy[i];
				int nextX = X+dx[i];
				
				if(nextY>=0 && nextX>=0 && nextY<N && nextX<M) {
					if(visit[nextY][nextX]==0 && tomato[nextY][nextX]==0) {
						if(date[nextY][nextX] < 0) {
							q.add(new Pair(nextY, nextX));
							visit[nextY][nextX] = 1;
							date[nextY][nextX] = date[Y][X]+1;
						}
						if(date[Y][X]<date[nextY][nextX]) {
							q.add(new Pair(nextY, nextX));
							visit[nextY][nextX] = 1;
							date[nextY][nextX] = date[Y][X]+1;
						}
					}
				}
			}
		}
		date[y][x] = 1;
	}
}

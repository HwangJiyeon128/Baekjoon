package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class baekjoon10026 {
	
	static int[][] RGBvisit;
	static int[][] RGBmap;
	static int[][] RRBvisit;
	static int[][] RRBmap;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int N;
	
	static class Pair{
		int y, x;
		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGBmap = new int[N][N];
		RRBmap = new int[N][N];
		RGBvisit = new int[N][N];
		RRBvisit = new int[N][N];
		int rgb = 0, rrb = 0;
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				if(input.charAt(j) == 'R') {
					RGBmap[i][j] = 0;
					RRBmap[i][j] = 0;
				}
				else if(input.charAt(j) == 'G') {
					RGBmap[i][j] = 1;
					RRBmap[i][j] = 0;
				}
				else {
					RGBmap[i][j] = 2;
					RRBmap[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(RGBvisit[i][j]==0) {
					rgb++;
					RGBbfs(i, j);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(RRBvisit[i][j]==0) {
					rrb++;
					RRBbfs(i, j);
				}
			}
		}
		
		System.out.println(rgb+" "+rrb);
	}

	public static void RGBbfs (int y, int x) {
		Queue<Pair> q = new LinkedList<Pair>();
		int pre = RGBmap[y][x];
		q.add(new Pair(y, x));
		RGBvisit[y][x] = 1;
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int Y = pair.y;
			int X = pair.x;
			
			for(int i=0; i<4; i++) {
				int nextY = Y+dy[i];
				int nextX = X+dx[i];
				
				if(nextY>=0 && nextX>=0 && nextY<N && nextX<N) {
					if(RGBvisit[nextY][nextX]==0 && RGBmap[nextY][nextX]==pre) {
						q.add(new Pair(nextY, nextX));
						RGBvisit[nextY][nextX] = 1;
					}
				}
			}
		}
	}
	
	public static void RRBbfs (int y, int x) {
		Queue<Pair> q = new LinkedList<Pair>();
		int pre = RRBmap[y][x];
		q.add(new Pair(y, x));
		RRBvisit[y][x] = 1;
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int Y = pair.y;
			int X = pair.x;
			
			for(int i=0; i<4; i++) {
				int nextY = Y+dy[i];
				int nextX = X+dx[i];
				
				if(nextY>=0 && nextX>=0 && nextY<N && nextX<N) {
					if(RRBvisit[nextY][nextX]==0 && RRBmap[nextY][nextX]==pre) {
						q.add(new Pair(nextY, nextX));
						RRBvisit[nextY][nextX] = 1;
					}
				}
			}
		}
	}
}

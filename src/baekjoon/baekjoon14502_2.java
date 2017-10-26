package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.IOException;

public class baekjoon14502_2 {
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] map, visitV, visitA;
	static int N, M;
	static boolean finish;
	
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
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		finish = false;
		
		for(int i=0; i<N; i++) {
			String[] tmp = br.readLine().split(" "); 
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		int area = 0;
		Stack<Pair> s = new Stack<Pair>();
		
		
		while(!finish) {
			visitV = new int[N][M];
			visitA = new int[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 0) {
						s.push(new Pair(i, j));
						if(s.size()==3) {
							i = N; j = M;
						}
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 2) {
						virus(i, j);
					}
				}
			}

			int tmpArea = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0 && visitA[i][j]==0) {
						tmpArea += safeArea(0,0);
					}
				}
			}
			if(area<tmpArea)
				area = tmpArea;
			
			Pair pair = s.pop();
			if(pair.y==N-1 && pair.x==M-1)
				s.pop();
			
		}
		
	}
	public static void makeWall() {
		
	}

	//퍼뜨리기
	public static void virus(int y, int x) {
		visitV[y][x] = 2;
		
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(nextX>=0 && nextY>=0 && nextX<N && nextY<N) {
				if(map[nextY][nextX]==0 && visitV[nextY][nextX]==0) {
					virus(nextY, nextX);
				}
			}
		}
	}
	
	//안전지역
	public static int safeArea(int y, int x) {
		Queue<Pair> q = new LinkedList<Pair>();
		int cnt = 1;
		
		q.add(new Pair(y, x));
		visitA[y][x] = 1;
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int Y = pair.y;
			int X = pair.x;
			
			for(int i=0; i<4; i++) {
				int nextY = Y+dy[i];
				int nextX = X+dx[i];
				
				if(nextY>=0 && nextX>=0 && nextY<N && nextX<M) {
					if(map[nextY][nextX]==0 && visitA[nextY][nextX]==0) {
						visitA[nextY][nextX] = 1;
						q.add(new Pair(nextY,nextX));
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}

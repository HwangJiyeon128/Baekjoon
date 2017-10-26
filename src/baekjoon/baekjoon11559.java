package baekjoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class baekjoon11559 {
	
	static int N=12, M=6;
	static int[][] map = new int[12][6];
	static int[][] visit, bomb;
	
	static class Pair{
		int y, x;
		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) { //R:1, G:2, B:3, P:4, Y:5
				switch(input.charAt(j)) {
				case 'R':
					map[i][j] = 1;
					break;
				case 'G':
					map[i][j] = 2;
					break;
				case 'B':
					map[i][j] = 3;
					break;
				case 'P':
					map[i][j] = 4;
					break;
				case 'Y':
					map[i][j] = 5;
					break;
				case '.':
					map[i][j] = 0;
					break;
				}
			}
		}
		
		while(true) {
			int disappear = 0;
			visit = new int[12][6];
			bomb = new int[12][6];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visit[i][j]==0 && map[i][j]>0) {
						disappear += bfs(i, j);
					}
				}
			}
			
			for(int i=0; i<M; i++) {
				for(int j=11; j>=0; j--) {
					if(map[j][i]==0)
						j = -1;
					else if(visit[j][i]==0 && map[j][i]>0) {
						disappear += bfs(j, i);
					}
				}
			}
			
			if(disappear == 0)
				break;
			else {
				answer++;
				erase();
			}
		}
		System.out.println(answer);
	}
	
	public static void erase() {
		for(int i=0; i<M; i++) {
			for(int j=11; j>=0; j--) {
				if(bomb[j][i] == 1) {
					for(int k=j; k>0; k--) {
						if(map[k][i]==0)
							break;
						map[k][i] = map[k-1][i];
						bomb[k][i] = bomb[k-1][i];
					}
					map[0][i] = 0;
					bomb[0][i] = 0;
					j++;
				}
			}		
		}
	}
	
	public static int bfs(int y, int x) {
		Queue<Pair> q = new LinkedList<Pair>();
		Queue<Pair> b = new LinkedList<Pair>();
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		int cnt = 1, type = map[y][x];
		q.add(new Pair(y, x));
		visit[y][x] = 1;
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int Y = pair.y, X = pair.x;
			
			for(int i=0; i<4; i++) {
				int nextY = Y+dy[i];
				int nextX = X+dx[i];
				
				if(nextY>=0 && nextX>=0 && nextY<N && nextX<M) {
					if(visit[nextY][nextX]==0 && map[nextY][nextX]==type) {
						q.add(new Pair(nextY, nextX));
						b.add(new Pair(nextY, nextX));
						visit[nextY][nextX] = 1;
						cnt++;
					}
				}
			}
		}
		if(cnt >= 4) {
			bomb[y][x] = 1;
			for(Pair p: b) {
				bomb[p.y][p.x] = 1;
			}
		}
		
		return cnt;
	}
}

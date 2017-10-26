package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.IOException;

public class baekjoon14502_3 {
	
	static int N, M;
	static int[][] map, visit, copyMap, check, tmpMap;
	
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
		copyMap = new int[N][M];
		tmpMap = new int[N][M];
		check = new int[N][N];
		ArrayList<Pair> list = new ArrayList<Pair>();		
		
		for(int i=0; i<N; i++) {
			String[] input2 = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j] = Integer.parseInt(input2[j]);
				if(map[i][j]==0)
					list.add(new Pair(i, j));
			}
		}
		
		int answer = 0, cnt = 0;
			
		for(int i=0; i<list.size(); i++) {
			for(int j=i+1; j<list.size(); j++) {
				for(int k=j+1; k<list.size(); k++) {
					int safe = 0; 
					Pair p1 = list.get(i);
					Pair p2 = list.get(j);
					Pair p3 = list.get(k);
					
					copyMap[p1.y][p1.x] = 1;
					copyMap[p2.y][p2.x] = 1;
					copyMap[p3.y][p3.x] = 1;
					
					for(int a=0; a<N; a++) {
						for(int b=0; b<M; b++) {
							tmpMap[a][b] = copyMap[a][b];
						}
					}
					
					//바이러스 퍼뜨리기
					visit = new int[N][M];
					for(int a=0; a<N; a++) {
						for(int b=0; b<M; b++) {
							if(tmpMap[a][b]==2)
								virus(a, b);
						}
					}
					
					//안전영역 탐색하기
					visit = new int[N][M];
					for(int a=0; a<N; a++) {
						for(int b=0; b<M; b++) {
							if(tmpMap[a][b]==0)
								safe++;
						}
					}
					
					if(safe > answer)
						answer = safe;
					
					
					copyMap[p1.y][p1.x] = 0;
					copyMap[p2.y][p2.x] = 0;
					copyMap[p3.y][p3.x] = 0;
				}
			}
		}
			
		System.out.println(answer);
			
			
	}

	public static void virus(int y, int x) {
		Queue<Pair> q = new LinkedList<Pair>();
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		q.add(new Pair(y, x));
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int Y = pair.y, X = pair.x;
			
			for(int i=0; i<4; i++) {
				int nextY = Y+dy[i], nextX = X+dx[i];
				if(nextY>=0 && nextX>=0 && nextY<N && nextX<M) {
					if(visit[nextY][nextX]==0 && tmpMap[nextY][nextX]==0) {
						q.add(new Pair(nextY, nextX));
						visit[nextY][nextX] = 1;
						tmpMap[nextY][nextX] = 2;
					}
				}
			}
		}
	}
}

package baekjoon;

import java.util.*;

public class baekjoon2667_bfs {

	static int[][] map;
	static int[][] group;
	static ArrayList<Integer> result;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N, cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		group = new int[N][N];
		int num = 1;
		result = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			String tmp = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = tmp.charAt(j)-48;
			}
		}
		
		for(int a=0; a<N; a++) {
			for(int b=0; b<N; b++) {
				if(map[a][b]==1 && group[a][b]==0) {
					cnt=1;
					bfs(a, b, num);
					result.add(cnt);
					num++;
				}
			}
		}
		
		
		System.out.println(num-1);
		Collections.sort(result);
		for(int x: result) {
			System.out.println(x);
		}
	}
	
	public static void bfs(int y, int x, int num) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.add(x);
		qy.add(y);
		group[y][x] = num;
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			int X = qx.poll();
			int Y = qy.poll();
			
			for(int i=0; i<4; i++) {
				int nextX = X+dx[i];
				int nextY = Y+dy[i];
				
				if(nextX>=0 && nextY>=0 && nextX<N && nextY<N) {
					if(map[nextY][nextX]==1 && group[nextY][nextX]==0) {
						group[nextY][nextX] = num;
						qx.add(nextX);
						qy.add(nextY);
						cnt++;
					}
				}
			}
		}
	}

}

package baekjoon;

import java.util.*;

public class baekjoon2667_dfs {

	static int N, cnt;
	static int[][] map;
	static int[][] group;
	static ArrayList<Integer> result;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		group = new int[N][N];
		result = new ArrayList<Integer>();
		int num = 0;
		
		for(int i=0; i<N; i++) {
			String tmp = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && group[i][j]==0) {
					cnt=1;
					num++;
					dfs(i, j, num);
					result.add(cnt);
				}
			}
		}
		
		System.out.println(num);
		Collections.sort(result);
		for(int x: result) {
			System.out.println(x);
		}
	}

	public static void dfs(int y, int x, int num) {
		group[y][x] = num;
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(nextX>=0 && nextY>=0 && nextX<N && nextY<N) {
				if(map[nextY][nextX]==1 && group[nextY][nextX]==0) {
					cnt++;
					dfs(nextY, nextX, num);
				}
			}
		}
	}
}

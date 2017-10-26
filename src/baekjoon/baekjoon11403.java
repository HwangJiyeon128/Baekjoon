package baekjoon;

/*
 * 경로찾기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class baekjoon11403 {

	static int[][] data;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				data[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dp[i][j] = bfs(i, j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int bfs(int y, int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visit = new int[N];
		q.add(y);
		
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int i=0; i<N; i++) {
				if(data[next][i]==1 && visit[next]==0) {
					q.add(i);
					if(i==x) {
						return 1;
					}
				}
			}
			visit[next]=1;
		}
		return 0;
	}
}

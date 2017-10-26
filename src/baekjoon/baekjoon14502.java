package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.IOException;

public class baekjoon14502 {
	
	static int[][] map, tempMap, copyMap;
	static int n, m;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int ans;
	 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
	    n = Integer.parseInt(input[0]);
	    m = Integer.parseInt(input[1]);
	    map = new int[n][m];
	    tempMap = new int[n][m];
	 
	    for (int i = 0; i < n; i++) {
	    	String[] input2 = br.readLine().split(" ");
	        for (int j = 0; j < m; j++) {
	            tempMap[i][j] = map[i][j] = Integer.parseInt(input2[j]);
	        }
	    }
	 
	    for (int i = 0; i < n * m; i++) {
	        int c = (int) (i / (m * 1.0));
	        int r = i % m;
	 
	        if (tempMap[c][r] == 0) {
	            tempMap[c][r] = 1;
	            dfs(i, 1);
	            tempMap[c][r] = 0;
	        }
	    }
	    System.out.println(ans);
	}
	// 벽 3개 배치 
	public static void dfs(int v, int cnt) {
	    int c = (int) (v / (m * 1.0));
	    int r = v % m;
	 
	    if (cnt == 3) {
	        copyMap = new int[n][m];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                copyMap[i][j] = tempMap[i][j];
	            }
	        }
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (copyMap[i][j] == 2) {
	                    paint(i, j);
	                }
	            }
	        }
	        cal();
	    } else {
	        for (int i = v + 1; i < n * m; i++) {
	            int cc = (int) (i / (m * 1.0));
	            int rr = i % m;
	 
	            if (tempMap[cc][rr] == 0) {
	                tempMap[cc][rr] = 1;
	                dfs(i, cnt + 1);
	            }
	        }
	    }
	    // backtracking
	    tempMap[c][r] = 0;
	    --cnt;
	}
	// 바이러스 퍼트리기
	public static void paint(int y, int x) {
	    for (int i = 0; i < 4; i++) {
	        int nx = dx[i] + x;
	        int ny = dy[i] + y;
	 
	        if (0 <= ny && ny < n && 0 <= nx && nx < m) {
	            if (copyMap[ny][nx] == 0) {
	                copyMap[ny][nx] = 3;
	                paint(ny, nx);
	            }
	        }
	    }
	}
	// 안전 영역 구하기
	public static void cal() {
	    int cnt = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (copyMap[i][j] == 0) {
	                ++cnt;
	            }
	        }
	    }
	    if (cnt > ans) {
	        ans = cnt;
	    }
	}


}

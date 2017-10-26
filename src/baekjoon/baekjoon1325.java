package baekjoon;

/*
 * 효율적인 해킹
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class baekjoon1325 {

	static int N, M;
	static Queue<Pair> com;
	static ArrayList<ArrayList<Integer>> graph;
	
	static class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public boolean equals(Object o) {
		    if (o instanceof Pair) {
		        Pair other = (Pair) o;
		        return x == other.x && y == other.y;
		    }
		    return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> result = new PriorityQueue<Integer>();
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		com = new LinkedList<Pair>();
		graph = new ArrayList<ArrayList<Integer>>(N+1);
		int[] answer = new int[N+1];
		int max = 0;
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			String[] input = br.readLine().split(" ");
			int i1 = Integer.parseInt(input[0]);
			int i2 = Integer.parseInt(input[1]);
			graph.get(i2).add(i1);
			com.add(new Pair(i2, i1));
		}
		
		for(int i=1; i<=N; i++) {
			answer[i] += bfs(i);
			if(max < answer[i])
				max = answer[i];
		}
		
		for(int i=1; i<=N; i++) {
			if(max == answer[i])
				result.add(i);
		}
		
		for(int x: result) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	
	
	public static int bfs(int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visit = new int[N+1];
		int cnt = 1;
		q.add(y);
		visit[y] = 1;

		while(!q.isEmpty()) {
			int X = q.poll();
			for(int i=0; i<graph.get(X).size(); i++) {
				int tmp = graph.get(X).get(i);
				if(visit[tmp] == 0) {
					q.add(tmp);
					visit[tmp] = 1;
					cnt++;
				}
			}
		}
		return cnt;
	}
}

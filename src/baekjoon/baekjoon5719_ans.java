package baekjoon;

import java.util.*;

public class baekjoon5719_ans {
	public static void main(String args[]) {
		Solver s = new Solver();
		s.solve();
	}
}

class Solver {
	Solver() { }

	PriorityQueue<Node> pq = new PriorityQueue<Node>(1, new Comparator<Node>() {
		public int compare(Node n1, Node n2) {
			return n1.cost - n2.cost;
		}
	});

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int point = scanner.nextInt();
			int edge = scanner.nextInt();
			int i;
			if (point == 0)
				break;

			System.out.println("start end point");
			int startPoint = scanner.nextInt();
			int endPoint = scanner.nextInt();
			
			//선언
			ArrayList<Path>[] adj = (ArrayList<Path>[]) new ArrayList[point];
			ArrayList<Path>[] radj = (ArrayList<Path>[]) new ArrayList[point];
			//초기화
			for (i = 0; i < point; ++i) {
				adj[i] = new ArrayList<Path>();
				radj[i] = new ArrayList<Path>();
			}

			for (i = 0; i < edge; ++i) {
				//노드와 경로 정보 저장
				int u = scanner.nextInt();
				Path e = new Path();
				e.next = scanner.nextInt();
				e.value = scanner.nextInt();
				adj[u].add(e);
				
				//여긴 뭐하는 거지? radj는 뭐야?
				Path re = new Path();
				re.next = u;
				re.value = e.value;
				radj[e.next].add(re);
			}

			int[] dist1 = new int[point];
			int[] dist2 = new int[point];
			dijkstra(startPoint, adj, dist1);
			dijkstra(endPoint, radj, dist2);

			int[] dist = new int[point];
			Arrays.fill(dist, (int) 1e9);
			dist[startPoint] = 0;
			pq.add(new Node(startPoint, 0));
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (cur.cost != dist[cur.id])
					continue;
				for (Path path : adj[cur.id]) {
					if (dist1[cur.id] + dist2[path.next] + path.value == dist1[endPoint])
						continue;
					int ndist = dist[cur.id] + path.value;
					if (dist[path.next] > ndist) {
						dist[path.next] = ndist;
						pq.add(new Node(path.next, ndist));
					}
				}
			}

			System.out.println(dist[endPoint] >= (int) 1e9 ? -1 : dist[endPoint]);
		}
	}

	void dijkstra(int position, ArrayList<Path>[] adj, int[] dist) {
		Arrays.fill(dist, (int) 1e9);
		dist[position] = 0;
		pq.add(new Node(position, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.cost != dist[cur.id])
				continue;
			for (Path edge : adj[cur.id]) {
				int ndist = cur.cost + edge.value;
				if (ndist < dist[edge.next]) {
					dist[edge.next] = ndist;
					pq.add(new Node(edge.next, ndist));
				}
			}
		}
	}

	static class Node {
		int id, cost;

		Node(int _id, int _cost) {
			id = _id;
			cost = _cost;
		}
	}

	static class Path {
		int next, value;
	}
}
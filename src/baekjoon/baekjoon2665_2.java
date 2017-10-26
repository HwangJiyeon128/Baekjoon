package baekjoon;

import java.util.*;

/* 미로만들기 */


class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class baekjoon2665_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        int[][] d = new int [n][n];
        Queue<Pair> q = new LinkedList<Pair>();
        Queue<Pair> next_queue = new LinkedList<Pair>();
        q.offer(new Pair(0, 0));
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j] = -1;
            }
        }
        
        d[0][0] = 0;
        
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (d[nx][ny] == -1) {
                        if (a[nx][ny] == 1) {
                            d[nx][ny] = d[x][y];
                            q.offer(new Pair(nx, ny));
                        } else {
                            d[nx][ny] = d[x][y]+1;
                            next_queue.offer(new Pair(nx, ny));
                        }
                    }
                }
            }
            System.out.println("\n[ q ]");
            int cnt=0;
            for(Pair obj : q){
			    System.out.println("deque["+cnt+"].x: "+obj.x+", deque["+cnt+"].y: "+obj.y);
			    cnt++;
			}
            System.out.println("\n[ next_queue ]");
            cnt=0;
            for(Pair obj : next_queue){
			    System.out.println("deque["+cnt+"].x: "+obj.x+", deque["+cnt+"].y: "+obj.y);
			    cnt++;
			}
            if (q.isEmpty()) {
                q = next_queue;
                next_queue = new LinkedList<Pair>();
            }
        }
        System.out.println(d[n-1][n-1]);
    }
}
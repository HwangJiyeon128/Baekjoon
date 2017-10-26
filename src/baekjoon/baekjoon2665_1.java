package baekjoon;

import java.util.*;

//class Pair {
//    int x, y;
//    Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class baekjoon2665_1 {

    public static void main(String args[]) {
        
    	//값 넣기
    	Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[num][num];
        for (int i=0; i<num; i++) {
            String s = sc.nextLine();
            for (int j=0; j<num; j++) {
            	map[i][j] = s.charAt(j) - '0';
            }
        }

        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[][] check = new int [num][num];
        ArrayDeque<Pair> deque = new ArrayDeque<Pair>();
        deque.add(new Pair(0, 0));
        
        //check초기화
        for (int i=0; i<num; i++) {
            for (int j=0; j<num; j++) {
            	check[i][j] = -1;
            }
        }
        check[0][0] = 0;
        
        while (!deque.isEmpty()) {
            Pair p = deque.poll();
            int x = p.x;
            int y = p.y;
            System.out.println("x: "+x+", y: "+y);
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                if (0 <= nx && nx < num && 0 <= ny && ny < num) {
                	System.out.println("nx: "+nx+", ny: "+ny);
                    System.out.println("check[nx][ny]: "+check[nx][ny]+", map[nx][ny]: "+map[nx][ny]);
                    if (check[nx][ny] == -1) {//아직 방문하지 않았고
                        if (map[nx][ny] == 1) { //흰방
                        	check[nx][ny] = check[x][y];
                            deque.addFirst(new Pair(nx, ny));//경로등록
                            
                            System.out.println("\n[ white ]");
                            int cnt=0;
                            for(Pair obj : deque){
                			    System.out.println("deque["+cnt+"].x: "+obj.x+", deque["+cnt+"].y: "+obj.y);
                			    cnt++;
                			}
                        } else { //검은방
                        	check[nx][ny] = check[x][y]+1; //목표까지 가는데 검은 방의 개수
                            deque.addLast(new Pair(nx, ny));
                            System.out.println("\n[ black ]");
                            int cnt=0;
                            for(Pair obj : deque){
                			    System.out.println("deque["+cnt+"].x: "+obj.x+", deque["+cnt+"].y: "+obj.y);
                			    cnt++;
                			}
                        }
                    }
                }
            }
        }
        for(int i=0; i<num; i++) {
        	for(int j=0; j<num; j++) {
        		 System.out.print(check[i][j]+" ");
        	}
        	System.out.println();
        }
        System.out.println(check[num-1][num-1]);
    }
}
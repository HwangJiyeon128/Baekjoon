package baekjoon;

import java.util.*;

public class Main {


	 static int a[][];  
	    static int dx[] = {1,0,-1,0};  
	    static int dy[] = {0,1,0,-1};  
	    static int cnt=2;  
	    static int n;  
	    static int sum[];  

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
        n=sc.nextInt();  
        a=new int[n][n];  
        sum=new int[n*n];  
        for(int i=0;i<n;i++){  
            String str = sc.next();  
            char ch[]=str.toCharArray();  
            for(int j=0;j<ch.length;j++){  
                a[i][j]=ch[j]-'0';  
            }  
        }  
          
        for(int i=0;i<n;i++){  
            for(int j=0;j<n;j++){  
                if(a[i][j]==1){  
                    bfs(i,j);  
                    cnt++;  
                }  
            }  
        }  
  
        Arrays.sort(sum);  
        System.out.println(cnt-2);  
        for(int i=n*n-cnt+2;i<n*n;i++){  
            System.out.println(sum[i]);  
        }  

	}
	
	static void bfs(int x, int y){  

		a[x][y]=cnt;  
        Queue<Integer> qx=new LinkedList<Integer>();  
        Queue<Integer> qy=new LinkedList<Integer>();  
        qx.add(x);  
        qy.add(y);  
        while(!qx.isEmpty() && !qy.isEmpty()){  
            x=qx.peek();  
            y=qy.peek();  
            sum[cnt]++;  
            qx.poll();  
            qy.poll();  
  
            for(int i=0;i<4;i++){  
                int cx=x+dx[i];  
                int cy=y+dy[i];  
                if(cx<n && cx>=0 && cy<n && cy>=0){  
                    if(a[cx][cy]==1){  
                        a[cx][cy]=cnt;  
                        qx.add(cx);  
                        qy.add(cy);  
                    }  
                }  
            }  
        }  

	}

}

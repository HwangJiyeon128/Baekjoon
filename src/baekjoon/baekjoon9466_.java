package baekjoon;


import java.util.*;  

public class baekjoon9466_ {  
    static int a[];  
    static int check[];  
    static int startVertex[];  
      
    public static void main(String args[]){  
        Scanner sc = new Scanner(System.in);  
        int t=sc.nextInt();  
          
        while(t-- > 0)  
        {  
            int n=sc.nextInt();  
            a=new int[n+1];  
            check=new int[n+1];  
            startVertex=new int[n+1];  
              
            for(int i=1;i<=n;i++)  
                a[i]=sc.nextInt();  
              
            int ans=0;  
            for(int i=1;i<=n;i++){  
                if(check[i]==0)  
                    ans+=dfs(i,1,i);  
            }  
            System.out.println(n-ans);  
          
        }  
    }  
    
    static int dfs(int cur, int cnt, int start){  
        if(check[cur]!=0){  
            if(start!=startVertex[cur])  
                return 0;  
            return cnt-check[cur];  
        }  
          
        check[cur]=cnt;  
        startVertex[cur]=start;  
        return dfs(a[cur],cnt+1, start);  
    }  
}  


import java.util.*;
import java.io.*;

public class hwalgo21_구미_5반_박민준 {

    static int n;
    static int[][] map ;
    static boolean[] visited; 
    static int ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;  j < n ; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 12341234;
        visited = new boolean[n];

        dfs(0,0,0);
        System.out.println(ans);

    }
    
    static void dfs(int idx, int cnt, int dist) {
        if(dist >= ans) return;

        if(cnt == n-1) {
			if(map[idx][0]!=0) {
				int temp = dist + map[idx][0];
				ans = Math.min(ans, temp);
			}
			return;
		}
		
        for(int i = 1 ; i < n ; i++){
            if(!visited[i] && map[idx][i]!=0){
                visited[i] = true;
                dfs(i, cnt+1, dist+map[idx][i]);
                visited[i] = false;
            }
        }
    }
    

    

}
import java.io.*;
import java.util.*;

public class bj2636 {
    static int n,m;
	static int[][] map;
	static boolean[][] Visited;
	static int cnt;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Visited = new boolean[n][m];
        int i;
        for(i = 0 ; isCheese(); ++i){
            for(boolean[] arr : Visited) Arrays.fill(arr,false);
            Visited[0][0] = true;
            cnt = 0;

            dfs(0,0);
        }
        System.out.printf("%d\n%d",i,cnt );

    }

    public static boolean isCheese(){
        for(int i = 0; i< n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                if(map[i][j] > 1) map[i][j] = 0;
            }
        }

        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                if(map[i][j] == 1) return true;
            }
        }
        return false;
    }

    public static void dfs(int x, int y){
        for (int i = 0 ; i < 4 ; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if( nx < 0 || ny < 0 || nx >= n || ny >= m ) continue;
            if(!Visited[nx][ny]){
                Visited[nx][ny] = true;
                if(map[nx][ny] == 1){
                    map[nx][ny] = 2;
                    cnt ++;
                }else{
                    dfs(nx,ny);
                }
            }
        }
    }
}

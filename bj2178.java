import java.util.*;
import java.io.*;

public class bj2178{
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int n, m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String str;

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < n ; ++i){
            str = br.readLine();
            for(int j = 0; j < m ; ++j){
                map[j][i] = str.charAt(j)-'0';
                visited[j][i] = false;
            }  
        }

        visited[0][0] = true;
        bfs(0,0);

        System.out.println(map[m-1][n-1]);

        

    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4 ; ++i){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if( nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[ny][nx] || map[ny][nx] == 0) continue;

                q.offer(new int[] {nx, ny});
                map[ny][nx] = map[curY][curX] + 1;
                visited[ny][nx] = true;
            }
        }
    }

}




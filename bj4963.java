import java.util.*;
import java.io.*;

public class bj4963{

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static int[][] map;
        static boolean[][] visited;

        static int[] dx = {0,1,1,1,0,-1,-1,-1};
        static int[] dy = {-1,-1,0,1,1,1,0,-1};
        static int w,h;
        public static void main(String[] args) throws Exception{


        while(true){ 
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // n =  width
            h = Integer.parseInt(st.nextToken()); // m = height

            if(w == 0 && h == 0) break;

            map = new int[h][w]; 
            visited = new boolean[h][w];

            for(int i =0 ; i< h ; ++i){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w ; ++j) map[i][j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            for(int i = 0 ; i < h ; ++i){
                for(int j = 0 ; j < w ; ++j){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        cnt ++;
                    }
                }
            }


            System.out.println(cnt);

        
        }


        }

        static void dfs(int x, int  y){
            visited[x][y] = true;

            for(int i = 0 ; i < 8 ; ++i){
                int nx = x + dx[i]; int ny = y + dy[i];
                if(nx < 0 || nx >= h || ny < 0 || ny >= w)continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]) dfs(nx,ny);
            }
        }
    }




    /*----------------------------------------------------------------


    
            
            for(int i =0 ; i< n ; ++i){
                for(int j = 0; j < m ; ++j) System.out.print(map[j][i]);

                System.out.println();
            }
            

    */



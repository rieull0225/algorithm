import java.util.*;
import java.io.*;

public class Main_16926_박민준{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, r;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int[][] origin = new int[n][m];

        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; ++j){
                origin [i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count, x , y;
        int num = n < m ? n / 2 : m / 2;

        for(int k = 0 ; k < num ; ++k){
            for(int i = 0 ; i < r ; ++i){
                x = k; y= k;
                count = 0;
                int data = origin[y][x];
                while(count < 4){
                    int nx = x + dx[count]; int ny = y + dy[count];
                    if( nx < k || nx >= m - k || ny < k ||  ny >= n - k) ++count;
                    else{
                        int temp = origin[ny][nx];
                        origin[ny][nx] = data;
                        data = temp;
                        x = nx; y = ny;
                    }
                }
                
            } 
        }
        for(int i =0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                System.out.print(origin[i][j] + " ");
            }
            System.out.println();
        }
    }
}
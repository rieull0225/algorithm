import java.util.*;
import java.io.*;

public class Main_17406_박민준{
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] origin;
    static int[][] rotate;
    static int n, m, k;
    static int[][] order;
    static int _min = 5000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        origin = new int[n][m];
        rotate = new int[n][m];

        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; ++j){
                origin [i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[k][3];

        for(int i = 0 ; i < k ; ++i){
            st = new StringTokenizer(st.nextToken());
            
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            order[k][0] = r; order[k][1] = c; order[k][2] = s;
        }
        int[] idx = new int[k];
        for(int i =0; i<k; ++i) idx[i] = i;
        


        for(int i =0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                System.out.print(rotate[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void perm(int[] arr, int idx, int _max){
        if(idx == _max){
            rotate = new int[n][m];

            for(int i = 0 ; i < n ; ++i){
                for( int j = 0; j < m ; ++j) rotate[i][j] = origin[i][j];
            }

            for(int a : arr){

                int r = order[a][0];
                int c = order[a][1];
                int s = order[a][2];

                rotate(r, c, s);
            }
            
        for( int i = 0 ; i < n ; ++i){
            int temp = 0;
            for (int j =0; j < m ; ++j){
                temp += rotate[i][j];
            }
            _min = _min < temp? _min : temp;
        }
        }
        for ( int i = idx; i < _max ; ++i){
            swap(arr, idx, idx + 1);
            perm(arr, ++idx, _max);
            swap(arr, idx, i);
        }

    }

    static void swap(int[] arr, int idx, int i) {
        int temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;
      }
    

    static void rotate(int r, int c , int s){

        
        int count;
        for(int k = 0 ; k < s ; ++k){      
            int x = k; int y= k;
            count = 0;
            while(count < 4){
                int nx = x + dx[count]; int ny = y + dy[count];
                if( nx < k || nx >= c - k || ny < k ||  ny >= r - k) ++count;
                else{
                    rotate[y][x] = origin[ny][nx];
                    x = nx; y = ny;
                }
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class j2447{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static char[][] star;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        star = new char[n][n];

        draw(0,0,n,false);

        sb =new StringBuilder();
        for (int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < n ; ++j) sb.append(star[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static void draw(int x, int y, int n, boolean check){
        if(check){
            for(int i = x; i< x + n ; ++i){
                for(int j = y ; j < y + n ; ++ j){
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1) {star[x][y] = '*';  return;}

        int cnt = 0 ;
        for (int i = x ; i < x + n ; i += n/3){
            for(int j = y ; j < y + n ; j += n/3){
                cnt ++;
                boolean blank = cnt == 5 ? true : false;
                draw(i , j , n/3, blank);
            }
        }
    }
}



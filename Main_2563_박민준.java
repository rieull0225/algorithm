import java.util.*;
import java.io.*;

public class Main_2563_박민준 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[100][100];

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0; i < n ; ++ i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x ; j < x + 10 ; ++j){
                for(int k = y ; k < y + 10 ; ++k ){
                    if(map[j][k] > 0) continue;
                    map[j][k] = 1;
                    ++ans;
                }
            }
        }
        System.out.println(ans);
    }
}


import java.util.*;
import java.io.*;

public class bj5606 {

    static int[][] dp;
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        dp = new int[31][31];


        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(Comb(b,a));
        }
    }
    
    static int Comb(int n, int r){
        if(dp[n][r] > 0) return dp[n][r];

        if(n == r || r == 0) return dp[n][r] = 1;

        return dp[n][r] = Comb(n-1,r-1) + Comb(n-1,r);
    }
}
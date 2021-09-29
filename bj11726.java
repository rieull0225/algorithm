import java.io.*;

public class bj11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[2002];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i <= n ; ++i){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 10007;
        }

        System.out.println(dp[n]);


    }
}

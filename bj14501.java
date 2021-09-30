
import java.util.*;
import java.io.*;

public class bj14501 {

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] ti = new int[n];
        int[] pi = new int[n];
        int[] dp = new int[n+1];

        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(br.readLine());
            ti[i] = Integer.parseInt(st.nextToken());
            pi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < n ; ++i) {
			if (i + ti[i] <= n) dp[i + ti[i]] = Math.max(dp[i + ti[i]], dp[i] + pi[i]);
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[n]);
        }
}
import java.util.*;
public class Main_BJ1463_박민준 {
    public static void main(String[] args){
        
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];

        for(int i = 2 ; i <= n ; ++i) dp[i] = Integer.MAX_VALUE;
        for(int i = 2 ; i <= n ; ++i){
            if(i % 3 == 0) dp[i] = Math.min(dp[i/3]+1, dp[i]);
            if(i % 2 == 0) dp[i] = Math.min(dp[i/2]+1, dp[i]);
            dp[i] = Math.min(dp[i-1]+1, dp[i]);
        }
        System.out.println(dp[n]);
    }
}

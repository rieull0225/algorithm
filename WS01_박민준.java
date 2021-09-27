import java.util.*;

public class WS01_박민준{

    static int[] dp ;
    public static void main(String[] args) {


		@SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        System.out.println(prob1(n));
        System.out.println(prob2(n));


    }
    static int prob1(int n){
    
        dp = new int[n+1];
        dp[1] = 2;
        dp[2] = 3;
        for(int i = 3 ; i <= n ; ++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    static int prob2(int n){
        dp = new int[n+1];
        dp[1] = 2;
        dp[2] = 5;

        for(int i = 3 ; i <= n ; ++i){
            dp[n] = dp[n-1] * 2 + dp[n-2];
        }
        return dp[n];
    }
}
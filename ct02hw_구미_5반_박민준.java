import java.util.*;
import java.io.*;

public class ct02hw_구미_5반_박민준 {
	static int n,r;
	static final long MOD = 1234567891;
    static final int MAX = 1000001;
	static long after[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());

		after = new long[MAX];
		after[0]=1;
		for(int i = 1 ; i < MAX ; ++i) {
			after[i] = after[i-1] * i;
			after[i] %= MOD;
		}
		for(int t = 1 ; t <= test_case ; ++t) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			long num = 1;
            long denom = 1;

			num = after[n];
			denom = (after[n-r]*after[r])%MOD;
			denom = power(denom , MOD-2);
            int ans = Long.valueOf((num * denom) % MOD).intValue();
			System.out.printf("#%d %d\n", t, ans);
		}
	}


    public static long power(long a, long mod) {
		if( mod == 0 ) return 1;
		else if(mod == 1) return a;
		if(mod%2 == 0) {
			long temp = power(a , mod/2);
			return (temp * temp) % MOD;
		}
		long temp = power(a, mod-1) % MOD;
		return (temp * a) % MOD;
	}

    
}

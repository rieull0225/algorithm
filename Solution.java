import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());

		for(int test_case= 1;test_case<=T ; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int[][] floid = new int[n+1][n+1];
			int[] _sum = new int[n+1];
			int min = Integer.MAX_VALUE;

			for(int i = 1 ; i <= n ; ++i){
				for(int j = 1 ; j <= n ; ++j){
					floid[i][j] = Integer.parseInt(st.nextToken());
					if(floid[i][j] == 0 && i!=j) floid[i][j] = n*n;
				}
			}

			for(int k = 1 ; k <= n ; ++k){
				for(int i = 1 ; i <= n ; ++i){
					for(int j = 1 ; j <= n ; ++j){
						floid[i][j] = Math.min(floid[i][j], floid[i][k] + floid[k][j]);
					}
				}
			}

			for(int i = 1 ; i <= n ; ++i){
				for(int j = 1 ; j <=n; ++j){
					_sum[i] += floid[i][j];
				}
				min = _sum[i] < min? _sum[i] : min;
			}

			System.out.printf("#%d %d\n",test_case,min);
			
		}
	}
}

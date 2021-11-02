import java.util.*;
import java.io.*;

public class Solution2 {

	static int n;
	static int idx =0;
	static double ans;
	static int[] arr;
	static Queue<Integer> comb;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= t ; ++ test_case) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n];
			comb = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; ++i) arr[i] = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			
			Combination(arr, n , 0 , 4);
			System.out.printf("#%d %d",test_case, max);
			
			
		
	}
	}
	
	static void Combination(int[] arr, int length, int start, int k) {
		if(k == 0) {
			for(int i = 0 ; i < comb.size();++i) {
				System.out.print(comb.poll());
			}
			System.out.println(comb.poll());
			return;
		}
		
		for(int i= start ; i <= length - k ; ++i) {
			comb.add(arr[i]);
			Combination(arr, length, i+1, k-1);
			comb.poll();
			
		}
	}
}



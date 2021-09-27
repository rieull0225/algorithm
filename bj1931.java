import java.util.*;
import java.io.*;

public class bj1931 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] before = new int[n+1];
		int[] after = new int[n+1];
		int max = 0;
		int temp = 0;

		before[0] = Integer.parseInt(br.readLine());

		for(int i = 1 ; i < n ; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <= i ; ++j) after[j] = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j <= i ; ++j){
				if (j == 0) after[j] += before[j];
				else if(j == i) after[j] += before[j-1];
				else after[j] += Math.max(before[j], before[j-1]);
				
			}
			before = after.clone();
		}
		
		for(int i = 0 ; i < n ; ++i) max = Math.max(max, before[i]);
		System.out.println(max);
		
		
	}
}



import java.util.*;
import java.io.*;
public class swea_3307 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());

		for(int test_case= 1;test_case<=T ; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] array = new int[n];
			int[] lis = new int[n];

			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; ++i) array[i] = Integer.parseInt(st.nextToken());

			int idx = 0;
			lis[idx] = array[0];
			for(int i = 1 ; i < n ; ++i){
				if(lis[idx] < array[i]) lis[++idx] = array[i];
				else{
					int j = Arrays.binarySearch(lis,0,idx,array[i]);
					if(j<0) j = -j - 1;
					lis[j] = array[i];
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_9229_박민준
{
	public static void main(String args[]) throws Exception
	{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] arr;
        int max = 0;
        int res = 0;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(st.nextToken());
            for (int i =0; i < n ; ++i) arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            for(int i =0; i < n; ++i){
                for(int j = n-1; j > i ; --j){
                    if(arr[i] + arr[j] <= m){
                        max = arr[i] + arr[j] ;
                        if(max > res) res = max;
                        if(res == m) break;
                        
                    }
                }
            }
            if(res == 0) res = -1;


            System.out.printf("#%d %d",test_case, res);
		}
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_1228_박민준
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
        StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{   
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> arr = new ArrayList<String>();
            st = new StringTokenizer(br.readLine());
            for(int i  = 0 ; i < n ; ++i) arr.add( st.nextToken());

            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i =0 ; i < num ; ++i){
                st.nextToken();
                int pos = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                for(int j =0; j< cnt ; ++j) arr.add(pos + j, st.nextToken());
            }

            System.out.print("#"+(test_case)+" ");
            for(int i =0; i< 10 ; ++i) System.out.print(arr.get(i)+" ");
            System.out.println();

		}
        
        
	}


}
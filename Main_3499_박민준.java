import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main_3499_박민준
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{   
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            StringBuilder sb= new StringBuilder();
            int mid = n % 2 == 0 ? (int) n / 2 : ((int) n / 2) + 1;
            
            String[] A = new String[mid];
            String[] B = new String[mid];

            for(int i = 0; i < mid ; ++i) A[i] = st.nextToken();
            for(int i = 0; i < (int) n/2 ; ++i) B[i] = st.nextToken();
            

            for(int i =0; i < (int) n/2; ++i) {
                sb.append(A[i]+" ");
                sb.append(B[i]+" ");
        }
            if(n%2 == 1) sb.append(A[A.length-1]);


            System.out.printf("#%d %s\n",test_case,sb);
		}
	}
}
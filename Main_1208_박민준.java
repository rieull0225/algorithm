
import java.util.Scanner;
import java.util.Arrays;

class Main_1208_박민준
{
	public static void main(String args[]) throws Exception
	{
        
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int dump = s.nextInt();
            int max = 0;
            int[] arr = new int[100];
            Arrays.sort(arr);
            for(int i = 0; i < 100; ++i) arr[i] = s.nextInt();
            for(int i =0; i< dump; ++i){
                arr[arr.length-1]--;
                arr[0]++;
                Arrays.sort(arr);
                max = arr[arr.length-1] - arr[0];
                if (max == 0 || max == 1) break;
            }

            System.out.printf("#%d %d\n",test_case, max);
		
			

		}
	}
}
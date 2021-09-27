import java.io.*;
import java.util.*;

class Main_6808_박민준
{
    static int[] perm;
    static int[] a;
    static int[] b;
    static int aWin, bWin;
	public static void main(String args[]) throws Exception
	{   
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] card = new int[19];
            a = new int[9];
            b = new int[9];
            perm = new int[9];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 9 ; ++i){
                int temp = Integer.parseInt(st.nextToken());
                card[temp] = 1;
                a[i] = temp;
            }

            int idx = 0;
            for (int i = 1; i < 19 ; ++i) {
                if(card[i] == 0) b[idx++] = i;
            }

            aWin = 0;
            bWin = 0;
            Perm(0,0);


            System.out.printf("#%d %d %d\n", test_case, aWin, bWin);

        

		}
	}

    static void Perm(int flag, int cnt){
        if(cnt == 9) {
            int sumA = 0;
            int sumB = 0;
            for(int i = 0 ; i < 9; ++i){
                if(a[i] > perm[i]) sumA += a[i] + perm[i];
                else if(a[i] < perm[i]) sumB += a[i] + perm[i];
            }
            if(sumA > sumB) aWin++;
            else if(sumA < sumB) bWin++;
            return;
        }
        for(int i = 0 ; i < 9 ; ++i){
            if((flag & 1 << i ) != 0 ) continue;
            perm[cnt] = b[i];
            Perm(flag | 1 << i , cnt+1);
        }
    }
}
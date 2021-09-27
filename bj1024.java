import java.util.*;
import java.io.*;
 
class bj1024{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long N = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        boolean flag = true;
    
        while(L <= 100){
            long start = N / L - (L - 1) / 2;
            if(start < 0) break;

            if(N == (start * 2 + L - 1) * L / 2){
                for(long i = 0; i < L; i++) sb.append(start + i + " ");
                flag = false;
                break;
            }
            L++;
        }
        
        if(flag)
            System.out.println(-1);   
        System.out.println(sb);
    }
}

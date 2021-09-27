import java.util.*;
import java.io.*;

public class bj1041{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long max = 0;
        long ans = 0;
        int[] dice = new int[6];
        int[] arr = new int[3];

        for(int i = 0 ; i < 6 ; ++i) {
            dice[i] = Integer.parseInt(st.nextToken());
            max = dice[i] > max ? dice[i] : max;
        }

        if(n == 1) {
            for(int i : dice) ans += i;
            ans -= max;
        }else{
            for(int i = 0; i < 3 ; i++) arr[i] = dice[i] < dice[5-i] ? dice[i] : dice[5-i];
            Arrays.sort(arr);

            long n1 = (n-2) * (n-2) + (n-1) * (n-2) * 4;
            long n2 = (n-2) * 4 + (n-1) * 4;
            long n3 = 4;

            ans = n1 * arr[0] + n2 * (arr[0] + arr[1]) + n3 * (arr[0] + arr[1] + arr[2]);
            
        }

        System.out.println(ans);
    }

}




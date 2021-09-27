
import java.io.*;

public class Main_3040_박민준{

    static int[] arr = new int[9];
    static int[] ans = new int[7];
    static int[] num = new int[7];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0; i< 9 ; ++i) arr[i] = Integer.parseInt(br.readLine());
        Comb(0,0,0);
        for(int a : ans) System.out.println(a);


    }

    static void Comb(int cnt, int start, int sum){
        if( cnt == 7 && sum == 100) {ans = num.clone(); return;}
        else if(cnt == 7) return;
        for(int i = start ; i < 9; ++i){
            num[cnt] = arr[i];
            Comb(cnt+1 , i+1, sum+arr[i]);
        }
    }

}




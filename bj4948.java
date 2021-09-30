
import java.io.*;
public class bj4948 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        
        while(n != 0){
            int cnt = 0;
            for(int i = n + 1 ; i <= n*2 ; ++i){
                if(isPrime(i)) cnt++;
            }
            System.out.println(cnt);
            n = Integer.parseInt(br.readLine());
        }

        
    }

    static boolean isPrime(int a){
        if (a < 1) return false;
        if (a ==2) return true;
        for(int i = 2 ; i < Math.sqrt(a) + 1 ; ++i){
            if(a % i == 0) return false;
        }
        return true;
    }
    
}

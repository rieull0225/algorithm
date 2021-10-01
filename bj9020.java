
import java.io.*;

public class bj9020 {

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n ; ++i){ 

            int target = Integer.parseInt(br.readLine());
            int a = target / 2;
            int b = target / 2;

            for(int j = 0 ; j < (target/2) ; ++j){
                if(isPrime(a--) & isPrime(b++)) break;
            }
            System.out.printf("%d %d\n", a+1, b-1);
        }


        }

        static boolean isPrime(int x){
            if(x < 2) return false;
            if(x == 2) return true;
            for(int i = 2 ; i < Math.sqrt(x) + 1 ; ++i){
                if(x%i == 0) return false;
            }
            return true;
        }
}
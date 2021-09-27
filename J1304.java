import java.util.Scanner;

public class J1304 {
    public static void main(String[] args){
        
		@SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for(int i =1; i<=n ; ++i){
            for(int j =0; j< n; ++j) System.out.printf("%d ", i + n * j);
            System.out.println();
        }
    }
}

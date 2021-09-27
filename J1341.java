import java.util.*;

public class J1341 {
    public static void main(String[] args) {
        
		@SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int count = 1;
        for(int i =0; i<m ; i++){
            for(int j=0; j<n; j++){
                System.out.print(count+ " ");
                count++;
            }
            System.out.println();
        }
    }
}

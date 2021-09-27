import java.util.*;

public class J1856 {
    public static void main(String[] args) {
        
		@SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int count = 1;
        for(int i =0; i<m ; i++){
            if(i%2 == 0){
                for(int j=0; j<n; j++){
                    System.out.print(count+ " ");
                    count++;
                }
            }else{
                count += (n-1);
                for(int j=0; j<n; j++){
                    System.out.print(count+ " ");
                    count--;
                }
                count +=n + 1;
            }
            System.out.println();
        }
    }

}

import java.util.Scanner;
 
public class Main_2805_박민준 {
 
    public static void main(String[] args) {

        
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int t=1; t<=test_case; t++) {
            int n = sc.nextInt();
            int sum=0;
            for(int i=n/2; i>=0; i--) {
                String s = sc.next();
                for(int j=i; j<n-i; j++) {
                    sum += s.charAt(j)-'0';
                }
            }
            for(int i=1; i<=n/2; i++) {
                String s = sc.next();
                for(int j=i; j<n-i; j++) {
                    sum += s.charAt(j)-'0';
                }
            }
            System.out.println("#" + t + " " + sum);
        }
    }
 
}
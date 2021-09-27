import java.util.Scanner;

public class bj1057 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int zimin =sc.nextInt();
		int hansu =sc.nextInt();
		int count=0;
		n =n /2;
		while(zimin != hansu) {
			zimin = zimin/2 + zimin%2;
			hansu = hansu/2 + hansu%2;
			count++;
		}
		System.out.println(count);
		
	}
}
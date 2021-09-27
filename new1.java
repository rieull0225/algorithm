
import java.util.*;


public class new1 {

	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;

		for(int i = 1 ; i <= n; ++i){
			for(int j = i; j<= n/i ; j++){
				count ++;
			}
		}

		System.out.println(count);
		
	}

}

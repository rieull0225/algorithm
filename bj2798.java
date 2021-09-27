
import java.io.* ;
import java.util.*;

public class bj2798 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] cards = new int[n];
		int min = m;
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; ++i) cards[i] = Integer.parseInt(st.nextToken());

		for(int i = 0 ; i < n-2 ; ++i){
			for(int j = i+1 ; j < n-1 ; ++j){
				for(int k  = j + 1 ; k<n ; ++k){
					int temp = m - cards[i] -cards[j] - cards[k];
					if(temp < 0) continue;
					if(temp == 0) {min = temp; break;}
					if(min > temp) min = temp;
				}
			}
		}

		System.out.println(m-min);
		
	}

}
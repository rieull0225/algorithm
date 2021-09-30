
import java.io.*;

public class bj2156 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] list = new int[10001];
		int[] sum = new int[10001];

		for(int i = 0 ; i < n ; ++i) list[i] = Integer.parseInt(br.readLine());

		sum[0] = list[0];
		sum[1] = list[0] + list[1];

		for(int i = 2 ; i < n ; ++i){
			sum[i] = max_sum(
			sum[i-2]+list[i]+list[i+1],
			sum[i-1]+list[i+1],
			sum[i]);
		}

		System.out.println(sum[n-1]);

	}
	static int max_sum(int a, int b, int c){
		if(a > b) return a > c ? a : c;
		else return b > c ? b : c;
	}
}



import java.util.*;
import java.io.*;

class Main_SWEA_3289_서로소집합_박민준{   
    static int n, m;
	static int[] rank;
	static int[] seed;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T ; test_case++) {
			
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			seed = new int[n+1];
			rank = new int[n+1];
			for(int i = 0 ; i < n ; ++i) seed[i] = i;

			for(int i = 0 ; i < m ; ++i) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());

				if(op == 0) union(a,b);
				else{
					if(find(a) == find(b)) sb.append("1");
					else sb.append("0");
				}
			}
			
			System.out.printf("#%d %s\n",test_case,sb);
		}
		
	}

	static int find(int x){
		if(seed[x] == x) return x;
		seed[x] = find(seed[x]);
		return seed[x];
	}

	static void union(int x, int y){
		int nx = find(x);
		int ny = find(y);

		if(nx == ny) return;
		else{
			if(rank[nx] > rank[ny]) seed[ny] = nx;
			else if(rank[nx] < rank[ny]) seed[nx] = ny;
			else{
				seed[ny] = nx;
				rank[ny]++;
			}
		}
	}
}
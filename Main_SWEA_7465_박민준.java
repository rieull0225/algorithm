import java.util.*;
import java.io.*;
public class Main_SWEA_7465_박민준 {

	static int n,m;
	static int[] parents;
	static boolean[] isVisited;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case= 1;test_case<=T ; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];
			isVisited = new boolean[n + 1];
			cnt = 0;

			make();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			for (int i = 1; i < n + 1; i++) isVisited[parents[i]] = true;
			for (int i = 1; i < n + 1; i++) if (isVisited[i]) cnt++;

			System.out.printf("#%d %d\n",test_case, cnt);
		}

	}

	static void make() {
		for(int i = 1 ; i < n + 1 ; i++) parents[i] = i;
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		if(aRoot < bRoot) { 
			parents[bRoot] =aRoot;
			for(int i = 1 ; i < n + 1 ; i++) {
				if(parents[i] == bRoot) parents[i] = aRoot;
			}
		}
		else {
			parents[aRoot] = bRoot;
			for(int i = 1 ; i < n + 1 ; i++) {
				if(parents[i] == aRoot) parents[i] = bRoot;
			}
		}
		return true;
	}

	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	
}
 
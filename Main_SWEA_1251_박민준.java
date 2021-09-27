import java.util.*;
import java.io.*;
public class Main_SWEA_1251_박민준 {
	static int n, t;
	static PriorityQueue<load> l;
	static int[] x,y,parent;
	static double answer, e;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case= 1;test_case<=T ; test_case++) {
			n = Integer.parseInt(br.readLine());
			answer = 0;
			parent = new int[n+1];
			for(int i = 1; i<= n ; ++i) parent[i] = i;

			l = new PriorityQueue<load>();
			x = new int[n];
			y = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; ++i) x[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; ++i) y[i] = Integer.parseInt(st.nextToken()); 
			e = Double.parseDouble(br.readLine());
			for(int i = 0 ; i < n ; ++i){
				for(int j = 0 ; j < n ; ++j){
					int distY = y[i] - y[j];
					int distX = x[i] - x[j];
					double total = Math.pow(distX,2) + Math.pow(distY,2);
					l.add(new load(i+1, j+1, total));
				}
			}
			int num = l.size();
			for(int i = 0; i < num ; ++i){
				load peek = l.poll();
				union(peek.a, peek.b, peek.dist);
			}

			System.out.printf("#%d %.0f\n",test_case, answer);
		}
	}

	static void union(int a, int b, double dist){
		a = find(a);
		b = find(b);
		if(a != b){
			answer += e * dist;
			if(a>b) parent[a]= b;
			else parent[b] = a;
		}
	}

	static int find(int a){
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
}

class load implements Comparable<load>{
	int a ,b;
	double dist;
	public load(int a, int b, double dist){
		super();
		this.a = a; this.b = b; this.dist = dist;
	}
	@Override
	public int compareTo(load o){
		if(this.dist == o.dist) return 0;
		return this.dist < o.dist ? -1 : 1;
	}
}
 
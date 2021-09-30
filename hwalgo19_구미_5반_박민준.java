import java.util.*;

public class hwalgo19_구미_5반_박민준 {
	static int n, e;
	static int[] parent;
	static boolean[] Visited; 
	static ArrayList<Edge> arr;
	static PriorityQueue<Edge> pq;
    
	static class Edge { 
		int start, end, value;

		Edge(int start, int end, int value) {
			start = this.start;
			end = this.end;
			value = this.value;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T;test_case++) {
			n = sc.nextInt();
			e = sc.nextInt();
			
			Visited = new boolean[n+1];
			parent = new int[n+1];
			pq = new PriorityQueue<>(new EdgeComparator());
			arr = new ArrayList<>();
			
			for(int i=0; i<e; i++) {
				int st = sc.nextInt();
				int end = sc.nextInt();
				int v = sc.nextInt();
				pq.add(new Edge(st,end,v));
			}
			
			kruskal();
			long sum = 0;
			for(int i=0; i<arr.size(); i++) sum += arr.get(i).value;
			System.out.println("#"+test_case+" "+sum);
			sc.close();
		}
	}
	
	static void kruskal() {
		for(int i=1; i<=n; i++) parent[i] = i;

		for(int i=0; i<e; i++) {
			Edge edge = pq.poll(); 
			if(find(edge.start) == find(edge.end)) continue;
			union(edge.start, edge.end); 
			arr.add(edge);
		}
		
	}
	static int find(int n) { 
		if (parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}

	static void union(int n1, int n2) { 
		int p1 = find(n1);
		int p2 = find(n2);
		if (p1 != p2) parent[p1] = p2;
	}

	static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value > o2.value ? 1 : -1;
		}

	}
	
}
import java.util.*;
import java.io.*;

public class Main {


	static int n, m , start;
	static int count;
	static int[][] map;
	static boolean[] Visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		start = 1;

		map = new int[n+1][n+1];
		Visited = new boolean[n+1];

		for(int i = 0 ; i < m ; ++i){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}

		count = 0;
		dfs(start);

		System.out.println(count-1);

	}
	static void dfs(int idx){
		if(Visited[idx]) return;
		Visited[idx] = true;
		count++;

		for(int i = 1; i <= n ; ++i){
			if(map[idx][i] == 1) dfs(i);
		}

	}

}



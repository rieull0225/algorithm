package Testing;

import java.io.*;
import java.util.*;

public class Main {

	static int n,cnt;
	static int[][] map;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		cnt = 0;
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for(int i = 0 ; i < k ; ++i){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		
		dfs(0);
	

	}


	static void dfs(int val){
		if(visited[val]) return;
		visited[val] = true;

		for()

	}
}

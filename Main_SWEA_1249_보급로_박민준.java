import java.util.*;
import java.io.*;
public class Main_SWEA_1249_보급로_박민준 {

	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int n;
	static int[][] map;
	static boolean[][] Visited;
	static int[][] distance;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			for(int i = 0 ; i < n ; ++i){
				String[] str = br.readLine().split("");
				for(int j = 0 ; j < n ; ++j){
					map[i][j] = Integer.parseInt(str[j]);
				}
			}

			dijkstra(0,0);
			System.out.printf("#%d %d\n",test_case,distance[n-1][n-1]);
		}
	}


	static void dijkstra(int x, int y){
		Visited = new boolean[n][n];
		distance = new int[n][n];

		for(int i = 0 ; i < n ; ++i) Arrays.fill(distance[i], Integer.MAX_VALUE);

		distance[x][y] = 0;
		Visited[x][y] = true;

		for(int i = 0 ; i < 4 ; ++i){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			if(!Visited[nx][ny]) distance[nx][ny] = map[nx][ny];
		}

		for(int k = 0 ; k < n*n-2 ; ++k){
			int min = Integer.MAX_VALUE;
			int minX = -1;
			int minY = -1;

			for(int i = 0; i < n ; ++i){
				for(int j = 0 ; j < n ; ++j){
					if(!Visited[i][j] && distance[i][j] != Integer.MAX_VALUE){
						if(distance[i][j] < min) {
							min = distance[i][j];
							minX = i;
							minY = j;
						}
					}
				}
			}

			Visited[minX][minY] = true;

			for(int i = 0 ; i < 4 ; ++i){
				int nx = minX + dx[i];
				int ny = minY + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(!Visited[nx][ny]){
					if(distance[nx][ny] > distance[minX][minY] + map[nx][ny])
					distance[nx][ny] = map[nx][ny] + distance[minX][minY];
				}
			}
		}
	}

}

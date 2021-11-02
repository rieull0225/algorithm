import java.util.*;
import java.io.*;

public class Solution {

	static int n,x,y,cnt;
	static int[][] map;
	static int[][] Visited;

	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0 ,1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= t ; ++ test_case) {
			cnt = 0;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			Visited = new int[n][n];
			for(int i = 0 ; i < n ; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if(map[i][j]==2) {
						x = i;
						y = j;
					}
					map[x][y] = 0;
				}
			}
			Find(x,y,0, map);
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
	
	static void Find(int x, int y, int num , int[][] map) {
		if(num >= 3) return;


		for(int i = 0 ; i < 4 ; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int flag = 0;

			while(flag <= 2) {

				if(nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                boolean isOne = false;
				if(flag == 1 && map[nx][ny] == 1 && Visited[nx][ny] == 0) {
					Visited[nx][ny] = 1;
					cnt ++;
                    map[nx][ny] =0;
                    isOne = true;
				}	
				
				if(flag != 0) Find(nx,ny,num+1, map);
                if(isOne) map[nx][ny] = 1;
			
				if(map[nx][ny] == 1) flag ++;
				nx += dx[i];
				ny += dy[i];
						
			}
		}
	}
}



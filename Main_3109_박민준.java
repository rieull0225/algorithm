
import java.util.*;
import java.io.*;

public class Main_3109_박민준 {
	public static int r, c;
	public static char[][] map;
	public static StringBuilder sb = new StringBuilder();
	public static int ans = 0;
	public static int[] dx = {-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];

		for(int i = 0 ; i < r ; ++i){
			map[i] = br.readLine().toCharArray();
		}
	
		for(int i = 0 ; i < r ; ++i) dfs(i,0);

		System.out.println(ans);

	}

	static boolean dfs(int x, int y){
		if(y == c - 1){
			ans++;
			return true;
		}
		for(int i = 0 ; i < 3 ; ++i){
			int nx = x + dx[i];
			int ny = y + 1;
			if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
			if(map[nx][ny] == 'x') continue;
			map[nx][ny] = 'x';
			if(dfs(nx,ny)) return true;
		}
		return false;
	}
}
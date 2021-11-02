package Testing;

import java.io.*;
import java.util.*;

 
public class bj14889 {
	
	static int n;
	static int x;
	static int[][] map;
	static boolean[] visit;
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n];
 
 
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
			
		}
		comb(0, 0);
		System.out.println(Min);
 
	}
	static void comb(int idx, int cnt) {
		if(cnt == n / 2) {
			diff();
			return;
		}
 
		for(int i = idx; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;	
				comb(i + 1, cnt + 1);	
				visit[i] = false;	
			}
		}
	}
 
	static void diff() {
		int team_start = 0;
		int team_link = 0;
 
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {

				if (visit[i] == true && visit[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}

				else if (visit[i] == false && visit[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		int ans = Math.abs(team_start - team_link);
		
		if (ans == 0) {
			System.out.println(ans);
			System.exit(0);
		}
		
		Min = Math.min(ans, Min);
				
	}
 
}
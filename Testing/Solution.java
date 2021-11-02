package Testing;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map1 , map2;
	static int N, X, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

            map1 = new int[N][N];
            map2 = new int[N][N];
			count = 0;
            
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map1[i][j] = Integer.parseInt(st.nextToken());
					map2[j][i] = map1[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				if (simul(map1, i)) count++;
				if (simul(map2, i)) count++;
				
			}
			System.out.printf("#%d %d\n",test_case, count);
		}
	}

	private static boolean simul(int[][] map, int idx) {
		int count = 1;
		int height = map[idx][0];

		for (int i = 1; i < N; i++) {
			if (height == map[idx][i]) count++;
			else if (map[idx][i] - height == 1) {
				if (count < X) return false;
				else {
					count = 1;
					height = map[idx][i];
				}
			} else if (height - map[idx][i] == 1) {
				if (N < X + i) return false;
				
				for (int j = 1; j < X; j++) {
					if (height - map[idx][++i] != 1) return false;
				}
				height = map[idx][i];
				count = 0;
			} else return false;
			
		}
		return true;
	}
}
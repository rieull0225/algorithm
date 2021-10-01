import java.util.*;
import java.io.*;
public class Solution {
	static int row, col, ty, tx, tt, result;
	static int[][] arr, check;

	final static int dx[] = { 0, 1, 0, -1 };
	final static int dy[] = { -1, 0, 1, 0 };
	final static int dir[][] = {{ 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 },
								{ 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 } };
	public static class Pump {
		int x, y, time;
		public Pump(int y, int x, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static void ans() {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (check[i][j] == 1) result++;
	}

	static void bfs() {
		PriorityQueue<Pump> q = new PriorityQueue<Pump>();
		q.offer(new Pump(ty, tx, 1));
		int cx, cy, ct, nx, ny, ca, na;
		while (!q.isEmpty()) {
			Pump pump = q.poll();
			cx = pump.x;
			cy = pump.y;
			ct = pump.time;
			ca = arr[cy][cx];
			if (ct == tt)
				continue;
			for (int i = 0; i < 4; i++) {
				nx = cx + dx[i];
				ny = cy + dy[i];
				if(nx > 0 || ny > 0 || nx <= col || ny <= row ) continue;
				if(check[ny][nx] == 0 && dir[ca][i] == 1) {
					na = arr[ny][nx];
					if(na<=0) continue;

				}
				
			}

		}
		ans();
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= test; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());
			tx = Integer.parseInt(st.nextToken());
			tt = Integer.parseInt(st.nextToken());

			result = 0;
			check = new int[row][col];
			arr = new int[row][col];

			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			check[ty][tx] = 1;
			bfs();
			System.out.printf("#%d %d\n" ,test_case, result);
		}
	}
}


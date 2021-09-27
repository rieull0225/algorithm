
import java.io.*;

public class Main_1992_박민준{

	public static int[][] map;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for(int i = 0 ; i < n ; ++i){
			String str = br.readLine();
			for(int j = 0 ; j < n ; ++j){
				map[i][j] = str.charAt(j) - '0';
			}
		}

		quadTree(0,0,n);
		System.out.println(sb);

	}

	public static void quadTree(int x, int y, int size){
		if(isComplete(x,y,size)){
			sb.append(map[x][y]);
			return;
		}

		int temp = size / 2;
		int[] dirX = new int[]{0,0,temp,temp};
		int[] dirY = new int[]{0,temp,0,temp};
		sb.append('(');
		for(int i = 0 ; i < 4; ++i) quadTree(x+dirX[i], y+dirY[i], temp);
		sb.append(')');
	}

	public static boolean isComplete(int x, int y, int size){
		int temp = map[x][y];

		for(int i = x; i< x + size ; ++i){
			for(int j = y ; j < y + size ; ++j){
				if(temp != map[i][j]) return false;
			}
		}
		return true;
	}
}
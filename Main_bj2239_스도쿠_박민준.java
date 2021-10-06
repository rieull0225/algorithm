
import java.io.*;
import java.util.*;

public class Main_bj2239_스도쿠_박민준 {

	static int map[][];
	static ArrayList<Pos> arr;
	
	static class Pos{
		int x,y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

    public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		arr = new ArrayList<Pos>();
		for(int i = 0 ; i < 9 ; ++i){
			String input = br.readLine();
			for(int j = 0 ; j < 9 ; ++j){
				map[i][j] = input.charAt(j) - '0';
				if (map[i][j] == 0) arr.add(new Pos(i,j));
			}
		}


		dfs(0);

	}

	static void dfs(int val){
		if(arr.size() == val){
			
			for(int i = 0 ; i < 9 ; ++i){
				for(int j = 0 ; j < 9 ; ++j){
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		int x = arr.get(val).x;
		int y = arr.get(val).y;

		boolean[] check = new boolean[10];

		for(int i = 0 ; i < 9 ; ++i){
			if(map[x][i] != 0) check[map[x][i]] = true;
		}
		for(int i = 0 ; i < 9 ; ++i){
			if(map[i][y] != 0) check[map[i][y]] = true;
		} 

		int startX = (x/3) * 3;
		int startY = (y/3) * 3;
		for(int i = startX ; i < startX + 3 ; ++i){
			for (int j = startY ; j < startY + 3 ; ++j){
				if (map[i][j] !=0) check[map[i][j]] = true;
			}
		}

		for(int i = 1 ; i <= 9 ; ++i){
			if(!check[i]){
				map[x][y] = i;
				dfs(val+1);
				map[x][y] = 0;
			}
		}


	}

}

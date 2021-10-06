package Testing;

import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] pop;
	static int[][] map;


    public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		pop = new int[n];
		map = new int[n][n];

		for(int i = 0 ; i < n ; ++i) pop[i] = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < n ; ++i){
			st = new StringTokenizer(br.readLine());


		}
		


	}


}

package Testing;

import java.util.*;
import java.io.*;

public class Solution {
    
    static int[][] wheel;
    static int[][] temp;
    static int[][] order;
    static boolean[] rotated;
	public static void main(String args[]) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{

            int n = Integer.parseInt(br.readLine());
            wheel = new int[4][8];
            temp = new int[4][8];
            order = new int[n][2];

            for(int i = 0 ; i < 4 ; ++i){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 8 ; ++j){
                    wheel[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0 ; i < n ; ++i){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 2 ; ++j){
                    order[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0 ; i < n ; ++i){
                rotated = new boolean[4];
                rotate(order[i][0]-1, order[i][1]);
                
            }
            int ans = 0;
            for(int i = 0 ; i < 4 ; ++i){
                ans += Math.pow(2, i) * wheel[i][0];
            }
            System.out.printf("#%d %d\n", test_case, ans);
		
		}
	}

    static void rotate(int num, int dir){
        if(rotated[num] == true) return;

        int cnt = 0;
        if (dir == 1) cnt = 7;
        else cnt = 9;

        for(int i = 0 ; i < 8 ; ++i) temp[num][i] = wheel[num][(i+cnt)%8];
        wheel[num] = temp[num].clone();
        rotated[num] = true;

        if(dir == 1){
            if(num > 0 && wheel[num][7] != wheel[num-1][2]){
                rotate(num-1, dir*-1);
            }
            if(num < 3 && wheel[num][3] != wheel[num+1][6]){
                rotate(num+1, dir*-1);
            }
        }else{
            if(num > 0 && wheel[num][5] != wheel[num-1][2]){
                rotate(num-1, dir*-1);
            }
            if(num < 3 && wheel[num][1] != wheel[num+1][6]){
                rotate(num+1, dir*-1);
            }
        }

    }
    
}

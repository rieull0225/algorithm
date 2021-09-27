
import java.util.Scanner;

public class Main_1954_박민준
{
	public static void main(String args[])
	{
        
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int cnt = 2;
            int[] dirX = new int[]{1,0,-1,0};
            int[] dirY = new int[]{0,1,0,-1};

            int num = sc.nextInt();
            int temp = 0;
            int x = 0; int y = 0;
            int[][] map = new int[num][num];
            map[0][0] = 1;

            while(cnt <= num * num){
                int nx = x + dirX[temp]; int ny = y + dirY[temp];

                if(nx >= 0 && nx < map.length &&
                   ny >= 0 && ny < map.length &&
                   map[ny][nx] == 0){

                    x += dirX[temp]; y += dirY[temp]; 
                    map[y][x] = cnt;
                    cnt ++;
                }else{
                    temp = (temp + 1) %4;
                }
            }

            System.out.printf("#%d\n",test_case);
            for(int[] a : map){
                for(int b : a){
                    System.out.print(b+" ");
                }
                System.out.println();
            }
		
			

		}
	}
}


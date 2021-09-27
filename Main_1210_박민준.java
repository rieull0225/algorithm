
import java.util.Scanner;

public class Main_1210_박민준
{
	public static void main(String args[])
	{
        
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int T;
		T=10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            s.nextInt();
            int[][] map = new int[100][100];
            int x =0; int y =99;

            for(int i =0; i < 100 ; ++i){
                for(int j =0; j < 100; ++j){
                    map[j][i] = s.nextInt();
                }
            }

            for(int i = 0; i< 100; ++i){
                if(map[i][99]==2) x = i;
            }

            while(y != 0){
                if(x >= 1 && map[x-1][y] == 1){
                    while(x >= 1 && map[x-1][y] == 1) {
                        x--;
                    }
                }else if(x < 99 && map[x+1][y] == 1){
                    while(x < 99 && map[x+1][y] == 1) {
                        x++;
                    }
                }
                y--;
            }
            System.out.printf("#%d %d\n",test_case, x);
		
			

		}
	}
}

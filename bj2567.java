
import java.util.Scanner;

public class bj2567 {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        int dx[] = new int[]{1,0,-1,0};
        int dy[] = new int[]{0,1,0,-1};
		
		int map[][] = new int[101][101];
		for(int t = 0 ; t < T ; ++t) {
			int x= sc.nextInt();
			int y= sc.nextInt();
			
			for(int i = 0 ; i < 10 ; i++) {
				for(int j = 0 ; j < 10 ; j++) 
					map[x+i][y+j] = 1;
			}
		}
		int sum = 0;
		for(int i = 0 ; i < 101 ; ++i) {
			for(int j = 0 ; j < 101 ; ++j) {
                if(i < 1 || i >= 100 || i < 1 || i >= 100) continue; 
                if(map[i][j] == 1){
                    for(int k = 0 ; k < 4 ; ++k) {
                        if(map[i+dx[k]][j+dy[k]] == 0) sum++;
                    }
                }
			}
		}
		
		System.out.println(sum);
	}
}
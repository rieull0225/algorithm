import java.util.Scanner;

public class Main_2001_박민준 {
    
    static int[][] map;
    static int n ;
    static int _max;

    public static void main(String[] args) {

        
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        sc.nextInt();

        n = sc.nextInt();
        _max = sc.nextInt();

        map = new int[n][n];
        int ans = 0;

        for(int i =0; i<n; ++i){
            for(int j =0; j<n; ++j){
                map[j][i] = sc.nextInt();
            }
        }

        for(int i =0; i < n - _max + 1; ++i){
            for(int j =0; j < n - _max + 1 ; ++j){
                if( ans < _sum(i,j)) ans = _sum(i,j);
            }
        }

        System.out.println(ans);
    }

    static int _sum(int x, int y){
        int res = 0;
        for(int k = x; k < x+_max; k++ ){
            for(int q = y; q < y+_max; q++){
                res += map[q][k];
            }
        }
        return res;
    }
    
}

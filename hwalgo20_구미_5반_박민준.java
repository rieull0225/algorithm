import java.util.*;
import java.io.*;
public class hwalgo20_구미_5반_박민준 {

    static int[] posX;
    static int[] posY;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int tc = 0; tc < t; tc++){
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n+2][n+2];
            posX = new int[n+2];
            posY = new int[n+2];

            for(int i = 0 ; i < n+2 ; ++i){
                st = new StringTokenizer(br.readLine());
                posX[i] = Integer.parseInt(st.nextToken());
                posY[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < n+2; ++i ){
                for(int j = 0 ; j < n+2 ; ++j){
                    if(i!=j) map[i][j] = 54321;
                }
            }

            for(int i = 0 ; i < n+2 ; ++i){
                for(int j = 0 ; j < n+2 ; ++j){
                    if(i==j) continue;
                    if(isPossible(i,j)) map[i][j] = 1;
                }
            }

            for(int k = 0 ; k < n+2 ; ++k){
                for(int i = 0 ; i < n+2 ; ++i){
                    for(int j = 0 ; j < n+2 ; ++j){
                        map[i][j] = Math.min(map[i][j], map[i][k]+ map[k][j]);
                    }
                }
            }

            if(map[0][n+1] > 0 && map[0][n+1] < 54321) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    static boolean isPossible(int i,int j){
        return (Math.abs( posX[i]-posX[j] ) + Math.abs( posY[i]-posY[j]) <= 1000) ?  true : false ;
    }
}
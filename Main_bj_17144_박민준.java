import java.util.*;
import java.io.*;

public class Main_bj_17144_박민준 {

    static int r,c,t;
    static int[][] map;
    static int[][] diff;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static List<Integer> cleaner = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for(int i = 0 ; i < r ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < c ; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] < 0) cleaner.add(i);
            }
        }

        while(t-- > 0){
            dust();
            clean();
        }

        System.out.println(sum());


    }

    static void dust(){
        diff = new int[r][c];
        for(int x = 0 ; x < r ; ++x){
            for(int y = 0 ; y < c ; ++y){
                if (map[x][y] == -1) {
                    diff[x][y] = -1;
                    continue;
                }

                diff[x][y] += map[x][y];

                for(int i = 0 ; i < 4 ; ++i){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if(map[nx][ny] == -1) continue;
        
                    diff[nx][ny] += map[x][y] / 5;
                    diff[x][y] -= map[x][y] / 5;
                }
            }
        }
        map = diff;
    }


    static void clean(){
        int top = cleaner.get(0);
        for(int x = top - 1 ; x > 0 ; --x) map[x][0] = map[x-1][0];
        for(int y = 0 ; y < c-1 ; ++y) map[0][y] = map[0][y+1];
        for(int x = 0 ; x < top ; ++x) map[x][c-1] = map[x+1][c-1];
        for(int y = c-1 ; y > 1 ; --y) map[top][y] = map[top][y-1];
        map[top][1] = 0;

        int bot = cleaner.get(1);
        for(int x = bot+1; x < r-1 ; ++x) map[x][0] = map[x+1][0];
        for(int y = 0 ; y < c-1 ; ++y) map[r-1][y] = map[r-1][y+1];
        for(int x = r-1 ; x > bot ; --x) map[x][c-1] = map[x-1][c-1];
        for(int y = c-1 ; y > 1 ; --y) map[bot][y] = map[bot][y-1];
        map[bot][1] = 0 ; 
    }

    static int sum(){
        int sum = 2;
        for(int i = 0 ; i < r ; ++i){
            for(int j = 0 ; j < c ; ++j){
                sum += map[i][j];
            }
        }
        return sum;
    }
}
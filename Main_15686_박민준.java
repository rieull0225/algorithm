import java.util.*;
import java.io.*;

public class Main_15686_박민준{
    static int n,m;
    static int[][] map;
    static ArrayList<Pos> chicken;
    static ArrayList<Pos> home;
    static Pos[] select;
    static int globalMin = 100000;
    
    static class Pos{
        int x; int y;
        public Pos(int x, int y){
            x= this.x;
            y= this.y;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        select = new Pos[m];
        map = new int[n][n];

        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) home.add(new Pos(i,j));
                else if(map[i][j] == 2) chicken.add(new Pos(i,j));
            }
        }
        
        Comb(0,0);
        System.out.println(globalMin);

    }

    static void Comb(int start, int cnt){
        if(cnt == m){
            dist();
            return;
        }

        for(int i = start; i < chicken.size(); ++i){
            select[cnt] = chicken.get(i);
            Comb(i+1, cnt+1);
        }
    }

    static void dist(){
        int ans = 0;

        for(int i=0; i<home.size(); ++i) {
			int dist = Integer.MAX_VALUE;
			for(int j=0; j<select.length; ++j) {
				dist = Math.min(dist, Math.abs(home.get(i).x-select[j].x) + Math.abs(home.get(i).y-select[j].y));
			}
			ans += dist;
            if(ans > globalMin) return;
		}
        globalMin = ans > globalMin ? globalMin : ans;
    }

}




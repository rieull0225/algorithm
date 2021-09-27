import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
 
    static class Pos {
        int x;
        int y;
        int day;
 
        public Pos(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        box = new int[M][N];
 
        for(int i = 0 ; i < M ; ++i ) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; ++j) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
		}
        bfs();
    }
 
    static void bfs() {
        Queue<Pos> q = new LinkedList<Pos>();
        int day = 0;

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(box[i][j] == 1) q.offer(new Pos(i, j, 0));
            }
        }

        while(!q.isEmpty()) {
            Pos pos = q.poll();
            day = pos.day;
 
            for(int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
 
                if(0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if(box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new Pos(nx, ny, day+1));
                    }
                }
            }
        }
 
        if(isDecay()) System.out.println(day);
        else System.out.println(-1);
    }    

    static boolean isDecay() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
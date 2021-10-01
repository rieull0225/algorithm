
import java.util.*;
import java.io.*;

public class Main_BJ_17143_낚시왕_박민준{

    static class Shark{
        int r, c, speed, dir, size;

        public Shark(int r, int c, int speed, int dir, int size){
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

    }

    private static int R, C, M, sharkNum, ans;
    private static int[][] map, temp;
    private static int[] dx = {-1, 0 , 1, 0}; // 왼 위 오 아
    private static int[] dy = {0, -1, 0, 1};
    private static Queue<Shark> q = new LinkedList<Shark>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];

        sharkNum = 0;
        ans = 0;

        int r, c, speed, dir, size;
        for(int i = 0; i < M ; ++i){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            speed = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            size = Integer.parseInt(st.nextToken());
            if(dir == 1) dir = 0;
            else if (dir == 4) dir = 1;
            q.add(new Shark(r,c,speed,dir,size));

            map[r][c] = size;
        }


        for(int i = 1 ; i <= C ; ++i){
            if(M == 0 || M == sharkNum) break;
            Catch(i);
            temp = new int[R+1][C+1];
            Move();
        }

        System.out.println(ans);

    
    }

    private static void Catch(int pos){
        for(int i = 1 ; i <= R ; ++i){
            if(map[i][pos] != 0){
                ans += map[i][pos];
                map[i][pos] = 0;
                sharkNum++;
                break;
            }
        }
    }

    private static void Move(){
        int length = q.size();
        for (int i = 0 ; i < length ; ++i){
            Shark shark = q.poll();
            if(map[shark.r][shark.c] != shark.size) continue;
            int x = shark.r;
            int y = shark.c;
            int Tspeed = shark.speed;
            int dir = shark.dir;
            int size = shark.size;


            if(dir == 0 || dir == 2) Tspeed = Tspeed % ((R - 1) * 2);
            else Tspeed = Tspeed % ((C - 1) * 2);

            for(int k = 0 ; k < Tspeed ; ++k){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx <= 0 || nx > R || ny <= 0 || ny > C ) dir = (dir + 2) % 4;
                x += dx[dir];
                y += dy[dir];
            }
            if(temp[x][y] > size) continue;
            temp[x][y] = size;
            q.add(new Shark(x, y, shark.speed, dir, size));

        }

        map = temp.clone();
    }
}
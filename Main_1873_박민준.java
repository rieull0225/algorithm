
import java.util.Scanner;
class Main_1873_박민준

{
    static char[] elements = new char[]{};
    static char[][] map;
    static int[][] delta = new int[][] {{0,-1}, {1,0}, {0,1},{-1,0} }; // 상 우 하 좌
    static char[] tank = new char[]{'^', '>', 'v', '<'};
    static int h,w;
	public static void main(String args[]) throws Exception
	{
        
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{

            int dir = 0;
            h = sc.nextInt();
            w = sc.nextInt();
            String orders = " ";
            map = new char[h][w];
    
            int x =0 ; int y = 0;
    
            for(int i = 0; i < h ; ++i) {
                map[i] = sc.next().toCharArray();
                for(int j = 0; j< w ; ++j) {
                    if(map[i][j] == '>' || map[i][j] == '<'|| map[i][j] == '^'|| map[i][j] == 'v'){
                        y = i; x = j; //탱크 좌표 x, y
                    } 
                }
            }
            int orderNum = sc.nextInt();
            orders = sc.next();
            char[] odr = new char[orderNum];
            odr = orders.toCharArray();
            if (map[y][x] == '^') dir = 0;
            else if(map[y][x] == '>') dir = 1;
            else if(map[y][x] == 'v') dir =2;
            else if(map[y][x] == '<') dir =3;
    
            for(int i =0; i < odr.length ; ++i){
                switch (odr[i]){
                    case 'U':
                        dir = 0;
                        if(isMovable(x,y, dir)) {move(x,y,dir); y--;}
                        else show(x,y,0);
                        
                        break;
                    case 'R':
                        dir = 1;
                        if(isMovable(x,y,dir)) {move(x,y,dir); x++;}
                        else show(x,y,dir);
                        break;
                    case 'D':
                        dir =2;
                        if(isMovable(x,y,dir)) {move(x,y,dir); y++;}
                        else show(x,y,dir);
                        break;
                    case 'L':
                        dir= 3;
                        if(isMovable(x,y,dir)) {move(x,y,dir); x--;}
                        else show(x,y,dir);
                        break;
                    case 'S':
                        shoot(x,y, dir);
                        break;
                    default:
                        break;
            }
    
            }
            
            System.out.printf("#%d ", test_case);
            for(char[] corX : map){
                for(char a : corX){
                    System.out.print(a);
                }
            System.out.println();
    
    

		} }
	}
    static void show(int x, int y,int dir){
        map[y][x] = tank[dir];
    }

    static void move(int x, int y, int dir){
        map[y][x] = '.';
        show(x+delta[dir][0],y+delta[dir][1],dir);
    }

    static void shoot(int x, int y, int dir){
        char cannon = ' ';
        while(true){
            y= y+delta[dir][1]; x=x+delta[dir][0];
            if(y < 0 || y >= h||  x < 0 || x >= w) break;
            cannon = map[y][x];
            if(cannon == '*'){map[y][x] = '.'; break;}
            if(cannon == '#') break;
            
        }
    }

    static boolean isMovable(int x, int y, int dir){
        int dx = x + delta[dir][0];
        int dy = y + delta[dir][1];

        if(dx < 0 || dx >= w || dy < 0 || dy >= h)  return false;
        if(map[dy][dx] != '.') {return false;}

        return true;
    }
}
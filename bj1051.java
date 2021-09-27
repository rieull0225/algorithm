
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class bj1051 {
    public static char[][] map;
 
    public static boolean checkSquare(int i, int j, int l) {
        int temp = map[i][j];
        if(temp == map[i+l][j] && temp == map[i][j+l] && temp == map[i+l][j+l]) return true;
        return false;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) map[i][j] = s.charAt(j);
        }
        int maxLength = Math.max(N, M);
        int curLength = 1;
        outer:for(int l = maxLength; l>0; l--) {
            for(int i=0; i<N-l; i++) {
                for(int j=0; j<M-l; j++) {
                    if(checkSquare(i, j, l)) {
                        curLength = l+1;
                        break outer;
                    }
                }
            }
        }
        System.out.println(curLength*curLength);
    }
}
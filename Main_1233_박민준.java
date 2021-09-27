import java.util.*;
import java.io.*;


public class Main_1233_박민준 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        for(int test_case = 1 ; test_case < T ; test_case++) {
            int n = Integer.parseInt(br.readLine());

            char[] tree = new char[n+1];
            int answer = 1;

            for (int i = 0 ; i < n ; ++i){
                
                st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                tree[index] = st.nextToken().charAt(0);

                if(isNum(tree[index]) && isNum(tree[(int)index/2])){
                    answer = 0;
                }
            }
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    public static boolean isNum(char c){
        if(c != '+' && c != '-' && c != '*' && c != '/') return true;
        else return false;
    }
}

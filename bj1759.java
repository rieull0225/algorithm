import java.util.*;
public class bj1759{
    static char[] a;
    static int n, m;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        a = new char[n];
        for(int i=0; i<n; i++)
            a[i] = in.next().charAt(0);
        Arrays.sort(a);
        dfs(0,0,0,0,"");
        in.close();
    }
    static void dfs(int index, int cnt, int col, int con, String s){
        if(cnt==m){
            if(col>=1 && con>=2) System.out.println(s);
            return;
        }
        if(index==n) return;
        if (a[index] == 'a' || a[index] == 'e' || a[index] == 'i' || a[index] == 'o' || a[index] == 'u')
            dfs(index + 1, cnt + 1, col + 1, con, s + a[index]);
        else
            dfs(index + 1, cnt + 1, col, con + 1, s + a[index]);
        dfs(index+1, cnt, col, con, s);
    }
}

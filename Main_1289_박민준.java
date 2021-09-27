import java.util.Scanner;
 
public class Main_1289_박민준
{
    public static void main(String args[]) throws Exception
    {
        
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] temp = sc.next().split("");
            String pre = temp[0];
            int cnt = pre.equals("1")? 1:0;
            for(String num : temp) {
                if(!pre.equals(num)) {
                    ++cnt;
                }
                pre = num;
            }
            System.out.printf("#%d %d\n",test_case,cnt);
 
        }
    }
}
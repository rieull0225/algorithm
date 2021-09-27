
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Main_1225_박민준 {
    public static void main(String[] args) throws IOException {
        
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
		int T;
		T=10;
        StringBuilder sb= new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case ++){
            sb.append("#"+test_case+" ");
            sc.nextInt();

            Queue<Integer> q = new LinkedList<Integer>();
            for(int i =0; i < 8; ++i){
                q.offer(sc.nextInt());
            }
            int cycle = 1;

            while(true){
                int temp = q.peek();
                temp = temp >= cycle ? temp-cycle : 0;
                q.poll(); q.offer(temp);
                if(temp == 0) break;
                cycle = cycle == 5 ? 1 : ++cycle;
            }

            for(int queue : q) sb.append(queue +" ");

            sb.append("\n");
        }
        System.out.println(new String(sb));
    }    
}

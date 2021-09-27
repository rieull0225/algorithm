import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class J2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		Stack<int[]> top = new Stack<>(); 


		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!top.isEmpty()) {
				if(top.peek()[0] < num) top.pop();
				else { 
					System.out.print(top.peek()[1] + " ");
					break;
				}
			}
			
			if(top.empty()) System.out.print("0 ");
			top.push(new int[] {num, i+1});
		}
			
	}
    
}

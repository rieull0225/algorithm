import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_5215_박민준{
 
	static int T;
	static int n,m;
	static int score[],cal[];
	static boolean isSelected[];
	static int maxScore=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); 
		StringTokenizer st;
		for(int test_case=1 ; test_case<=T ; test_case++) {
			maxScore = 0;
			
			st = new StringTokenizer(br.readLine());	
			n = Integer.parseInt(st.nextToken()); 
			m = Integer.parseInt(st.nextToken()); 

			score = new int[n];
			cal= new int[n];
			isSelected = new boolean[n];

			for(int i = 0 ; i < n ; ++i) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			Diet(0);
			System.out.printf("#%d %d\n", test_case, maxScore);
		}

	}

	static void Diet(int cnt) {
		if(cnt == n) {
			int sumCal = 0;
			int sumScr = 0;
			
			for(int i = 0 ; i < n ; ++i) {
				if(isSelected[i]) {
					sumCal += cal[i];
					sumScr += score[i];
				}
			}
			if(sumCal<=m && sumScr>maxScore)
				maxScore = sumScr;
			return;
		}
	
			isSelected[cnt] = true;
			Diet(cnt+1);
			isSelected[cnt] = false;
			Diet(cnt+1);
	}
}
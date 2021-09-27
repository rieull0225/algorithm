import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1861_박민준 {
    static int n;
	static int[][] map;
	static int[] xpos= {0,0,1,-1};
	static int[] ypos= {1,-1,0,0};
	static int ans,len,start;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			start=n*n+1;
			ans=0;
			for (int i = 0; i < n; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					len=0;
					move(i,j,1);
					if(len>=ans) {
						if(len>ans) start=map[i][j];
						else if(len==ans && map[i][j]<start) start=map[i][j];
						ans= len;
		
					}
				}
			}
			System.out.printf("#%d %d %d\n",test_case,start,ans);
		}
		
	}

	private static void move(int y, int x,int cnt) {
		
		boolean possible=false;
		for (int i = 0; i < 4; i++) {
			int nx=x+xpos[i];
			int ny=y+ypos[i];
			if(nx<0 || ny<0 || nx>=n || ny>=n)continue;
			if(map[ny][nx]==map[y][x]+1) {
				possible=true;
				move(ny,nx,cnt+1);
			}
		}
		if(!possible && len< cnt) {
			len= cnt;
		}
	}
}
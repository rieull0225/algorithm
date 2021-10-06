import java.util.*;
import java.io.*;


public class Main {
	static int v,p,l;
	static int[] vil;
	static int[] min;
	static boolean[] visited;
	static List<Integer> comb;
	

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		//tc 입력부
		for(int test_case = 1; test_case <= t ; ++test_case) {
			st = new StringTokenizer(br.readLine());
			
			v = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			vil = new int[v];
			visited = new boolean[v];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < v ; ++i)vil[i] = Integer.parseInt(st.nextToken());
			
			//이진탐색으로 풀 수 있을거 같은데
			int left = 0; // 마을과 경찰서가 다 겹치면 0
			int right = l / 2 * v; // 아무리 멀리 떨어져 있다해도 원이기때문에 절반이고
			//몰려있으면 마을 갯수만큼 곱해준다, 최악의 경우 l이 1000이고, 마을이 1~100, 경찰서가 550인 경우이다.
			
			//반드시 left와 right사이에 한 점에 존재하므로, 이진탐색을 사용해 찾을 수 있을것이라고 판단.
			
			while(left <= right) {
				int mid = (left + right) /2;
				//여기서 거리의 합이 mid임을 판별해야하는데 아마 조합?
				//조합으로 풀 수 있을 것 같다.
				//경찰서는 마을 위에 지어야하므로, 조합의 갯수는 vCp가 되겠다. 시간이 좀 애매할거같은데
				
				if(comb(vil, visited, 0, v, p, mid)) right  = mid - 1;
				else left = mid + 1;			
			}
			
			
			
			
			System.out.printf("#%d %d\n",left, test_case); // 출력
		}
		
		
	}
	static boolean comb(int[] arr, boolean[] visited, int start, int n, int r ,int mid) {
	    if(r == 0) {//조합이 완성되었을 때, 거리의 합이 mid보다 작으면 true, 크면 false;
	    	int res = 0;
	        for(int i = 0 ; i < arr.length ; ++i) {
	        	if(visited[i]) { //arr[i] = 경찰서 좌표  arr[j] = 마을 좌표
		        	for(int j = 0 ; j < arr.length ; ++j) {
		        		int abs = Math.abs(arr[i]-arr[j]);
		        		res += Math.min(abs, l-abs);
		        		if(res > mid) return false;
		        		}
		        	}
	        	}
	        return true;
	    }

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        comb(arr, visited, i + 1, n, r - 1, mid);
	        visited[i] = false;
	    }
		return false;
	}
}

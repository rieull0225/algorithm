import java.util.*;
public class ssafy_0914_knapsack {
    public static void main(String[] args){
        
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
    
    
        int[] weights = new int[n+1];
        int[] profits = new int[n+1]; 
    
    
        for(int i = 0; i<=n ; i++){
            weights[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }
        int[][] D = new int[n+1][n+1];
    
        for (int i = 0; i<= n ; ++i){
            for (int j = 1; j <= w; j++){
                if(weights[i] <= j){
                    D[i][j] = Math.max(D[i-1][j], profits[i]+D[i-1][w-weights[i]]);
                }else{
                    D[i][w] = D[i-1][j];
                }
            }
        }
    }
    

}

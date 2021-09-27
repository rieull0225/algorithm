import java.util.*;
public class hwalgo18_구미_5반_박민준{

    static int red = 0;
    static int green = 1;
    static int blue = 2;
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][3];

        for (int i = 0 ; i < n ; ++i){
            cost[i][red] = sc.nextInt();
            cost[i][green] = sc.nextInt();
            cost[i][blue] = sc.nextInt();
        }

        for(int i = 1 ; i < n ; ++i){
            cost[i][red] += Math.min(cost[i-1][green], cost[i-1][blue]);
            cost[i][green] += Math.min(cost[i-1][red], cost[i-1][blue]);
            cost[i][blue] += Math.min(cost[i-1][red], cost[i-1][green]);
        }

        System.out.println(Math.min(Math.min(cost[n-1][red],cost[n-1][green]),cost[n-1][blue]));
    }

}

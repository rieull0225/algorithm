import java.util.Scanner;

public class Main_1244_박민준 {
    static int[] swch;
    public static void main(String[] args)  {
        
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt()+1;
        swch = new int[num];

        for(int i =1; i<num;++i) swch[i] = sc.nextInt();

        int n = sc.nextInt();
        for(int i =0; i< n; ++i){
            int gender = sc.nextInt();
            int rcv = sc.nextInt();

            if (gender == 1){
                for(int j = rcv; j < num; j+= rcv) turn(j);
                
            }else{
                int left = rcv-1; int right = rcv+1;
                while( true){
                    if(right >= num || left <1 ) break;
                    if(swch[left] != swch[right]) break;
                    left--; right++;
                }
                
                for(int j = left+1 ; j <right ; j++ ) turn(j);
            }
        }
        for(int i = 1; i<num ; i++){
            System.out.print(swch[i]+" ");
            if(i%20 == 0) System.out.println();
        }
    }
    
    static void turn(int target){
        swch[target] = swch[target] == 0 ? 1 : 0;
    }
}

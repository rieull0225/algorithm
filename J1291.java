import java.util.*;

public class J1291 {
    public static void main(String[] args){
        
		@SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int start = 0;
        int end = 0;
        
        do{
        start = s.nextInt();
        end = s.nextInt();
        if (!isRange(start) || !isRange(end)){
            System.out.println("INPUT ERROR!");
        }
        else break;
    }while(true);
        

        if (start > end) decN(start, end);
        else incN(start,end);

        
    }

    static boolean isRange(int a){
        if(a >= 2 && a <=9) return true;
        else return false;
    }

    static void incN(int start, int end){
        for(int j = 1; j<=9;j++){
            for (int i = start ; i <=end; i++){
                System.out.printf("%d * %d = %2d", i,j, i*j);
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    static void decN(int start, int end){
        for(int j = 1; j<=9;j++){
            for (int i = start ; i >=end; i--){
                System.out.printf("%d * %d = %2d", i,j, i*j);
                System.out.print("   ");
            }
            System.out.println();
        }
        
    }
    
}

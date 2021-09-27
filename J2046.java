import java.util.Scanner;

public class J2046{

    public static void main(String[] args){

        
		@SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int level = s.nextInt();

        switch (level){
            case 1:
                for(int i =0; i<n; i++){
                    for (int j =0; j<n; j++) System.out.printf("%d ",i);
                    System.out.println();
                }
                break;
            case 2:
                for(int i =0; i<n; i++){
                    for (int j =0;j<n; j++){
                        if (i%2 == 0) System.out.printf("%d ", j+1);
                        else System.out.printf("%d ", n-j);
                    }System.out.println();
                }
                break;
            case 3:
                for(int i=0; i<n;i++){
                    for (int j =0; j<n; j++) System.out.printf("%d ", (i+1) * (j+1));
                    System.out.println();
                }
                break;
            default:
                break;
        }

    }
}
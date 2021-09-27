import java.util.Scanner;

public class J1307 {
    public static void main(String[] args){
        
		@SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();

        char[][] map = new char[n][n];
        char alpha = 'A';

        alpha += n*n-1;
        while (alpha > 90) alpha -= 26;

        for(int i =0; i<n; ++i){
            for(int j =0; j<n; ++j){
                map[j][i] = alpha--;
                if (alpha == 64) alpha = 90; 
            }
        }

        for(char[] c : map){
            for (char aph : c) System.out.printf("%c ", aph);
            System.out.println();
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class J1422{
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());

        String[] num = new String[n-1];
        int[] intNum = new int[n]; 
        String answer = "";
        for(int i = 0; i< n ; ++i) {
            intNum[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(intNum);

        String max = Integer.toString(intNum[intNum.length-1]);

        for(int i =0 ; i < n-1; ++i) num[i] = Integer.toString(intNum[i]);

        Arrays.sort(num);
        

        for(int i =0; i < m - n + 1 ; i++) answer += max;
        for(int i = 0; i < num.length; i++){
            if(isBig(intNum[i],max)){
            }else{
                answer = answer + Integer.toString(intNum[i]);
            }
        }
        System.out.println(answer);
    }

    static boolean isBig(int i, String max){
        String temp = Integer.toString(i);
        return Integer.parseInt(temp + max) > Integer.parseInt(max+temp);
    }

}
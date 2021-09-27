import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class J1002{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n ; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dist = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));

            if(dist == 0 && r1 == r2) System.out.println(-1);
            else if(dist > Math.abs(r2-r1) && dist < r1+r2) System.out.println(2);
            else if(dist == Math.abs(r2-r1) || r2+r1 ==dist) System.out.println(1);
            else if(dist == 0 || r1+r2 < dist || Math.abs(r2-r1) > dist) System.out.println(0);

            
        }



    }


}
package Testing;

import java.util.*;
import java.io.*;

public class Main {

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; ++i) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 1;
        int end = arr[n-1] - arr[0]; 
        int ans = 0;
        while(start <= end){
            int mid = (start + end)/ 2;
            int prev = arr[0];
            int cnt = 1;
            for(int i = 1 ; i < n ; ++i){
                if(arr[i] - prev >= mid){
                    cnt++;
                    prev = arr[i];
                }
            }

            if(cnt >= c){
                ans = mid;
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(ans);

        }

}
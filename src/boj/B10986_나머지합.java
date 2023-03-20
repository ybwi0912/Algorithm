package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(token.nextToken()); // 수의 개수 N개
        int M = Integer.parseInt(token.nextToken()); // 합이 M으로 나누어떨어지는 ..

        long[] arr = new long[N];
        long ans = 0;
        long count[] = new long[M];

        token = new StringTokenizer(bf.readLine());
        arr[0] = Integer.parseInt(token.nextToken());

        for(int i=1; i<N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(token.nextToken());
        }

        for(int i=0; i<N; i++){
            int remainder = (int)(arr[i] % M);
            if(remainder==0) ans++;
            count[remainder]++;
        }

        for(int i=0; i<M; i++){
            ans += count[i] * (count[i]-1) / 2;
        }
        System.out.println(ans);

    }
}

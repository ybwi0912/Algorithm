package boj_3월;

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

        int[] arr = new int[N];
        int[] sumArr = new int[N];

        token = new StringTokenizer(bf.readLine());
        arr[0] = Integer.parseInt(token.nextToken());
        sumArr[0] = arr[0];

        for(int i=1; i<N; i++) {
            arr[i] = Integer.parseInt(token.nextToken()); // N개의 수
            sumArr[i] = sumArr[i-1] + arr[i];
        }
        int ans = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if((sumArr[i] - sumArr[j])%M==0)
                    ans++;
            }
        }

        System.out.println(ans);
    }
}

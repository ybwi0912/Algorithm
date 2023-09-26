package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int wine[] = new int[n+1];
        for(int i=1; i<n+1; i++) wine[i] = Integer.parseInt(bf.readLine());

        int dp[] = new int[n+1];

        dp[1] = wine[1];
        if(n>1) dp[2] = wine[1] + wine[2];

        for(int i=3; i<n+1; i++){
            dp[i] = Integer.max(Integer.max(dp[i-2], dp[i-3]+wine[i-1]) + wine[i], dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}

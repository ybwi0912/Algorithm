package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken());
        int[][] triangle = new int[n][n+1];

        for(int i=0; i<n; i++){
            token = new StringTokenizer(bf.readLine());

            for(int j=0; j<i+1; j++){
                triangle[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        // input

        for(int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        // operation

        System.out.println(triangle[0][0]);
        // output
    }
}

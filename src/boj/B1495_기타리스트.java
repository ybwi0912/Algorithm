package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

/*
* 2023-08-03
* BOJ 1495: 기타리스트
* ! 조합으로 풀려고 했으나 N<=50이라 시간 초과가 염려됨
*
* */

public class B1495_기타리스트 {
    static int N;
    static int S;
    static int M;
    static int[] V;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(token.nextToken()); // 곡의 개수
        S = Integer.parseInt(token.nextToken()); // 시작 볼륨
        M = Integer.parseInt(token.nextToken()); // 볼륨의 최댓값

        V = new int[N+1];
        token = new StringTokenizer(bf.readLine());

        for(int i=1; i<N+1; i++) V[i] = Integer.parseInt(token.nextToken());

        isVisited = new boolean[N+1][M+1];

        checkVol(1, S); // 첫 번째 곡부터 체크, 시작 볼륨 S

        int ans = -1;

        for(int i=M; i>=0; i--){
            if(isVisited[N][i]==true){
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    static void checkVol(int i, int p){ // 몇 번째 곡인지 인덱스, 현재 볼륨 p
        if(i==N+1) return;

        int plus = p+V[i];
        if(plus<=M){
            if(!isVisited[i][plus]){ // 방문하지 않은 노드라면
                isVisited[i][plus] = true;
                checkVol(i+1, plus);
            }
        }

        int minus = p-V[i];
        if(minus>=0){
            if(!isVisited[i][minus]){ // 방문하지 않은 노드라면
                isVisited[i][minus] = true;
                checkVol(i+1, minus);
            }
        }
    }
}

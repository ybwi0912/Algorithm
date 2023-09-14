package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 2023-09-14
* BOJ 11729번: 하노이 탑 이동 순서
* 옮긴 횟수 K, 수행 과정 A B(A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다) 출력
*
* */

public class B11729_하노이탑이동순서 {
    static int K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        hanoi(N, 1, 3, 2);

        System.out.println(K);
        System.out.println(sb);
    }

    static void hanoi(int n, int start, int end, int temp){
        if(n==1){
            K++;
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(n-1, start, temp, end);
        sb.append(start + " " + end + "\n");
        K++;
        hanoi(n-1, temp, end, start);
    }
}
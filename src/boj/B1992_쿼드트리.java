package boj;

/*
* 2023-08-31
* BOJ 1992번: 쿼드트리
* Z(B1074)랑 비슷한 문제
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1992_쿼드트리 {
    static int N; // N x N 크기의 영상이 주어짐. N은 언제나 2의 제곱수. 1 <= N <= 64
    static String[] video;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        video = new String[N];

        for(int i=0; i<N; i++)
            video[i] = bf.readLine();
        // input

        String ans = compression(0, 0, N);
        // operation

        System.out.println(ans);
        // output
    }


    /**
     * @param x : 시작 좌표
     * @param y : 끝 좌표
     * @param length : 탐색 길이
     * 첫 좌표에 위치하는 문자를 확인하고, 처음부터 끝까지 돌면서 만약 탐색 범위 내의 모든 문자가 같은 문자라면 해당 문자를 반환한다
     * 만약 범위 내에 첫 좌표에 위치하는 문자와 다른 문자가 존재하면 해당 범위를 4등분해서 각 범위마다 재귀 함수를 호출해 이 과정을 반복한다
     * */
    static String compression(int x, int y, int length){ // 시작 좌표, 끝 좌표, 길이
        char ch = video[x].charAt(y);

        for(int i=x; i<x + length; i++) {
            for(int j=y; j<y+length; j++) {
                if(ch != video[i].charAt(j))
                    return "(" + compression(x, y, length / 2) + compression(x, y + length / 2, length / 2)
                            + compression(x + length / 2, y, length / 2) + compression(x + length / 2, y + length / 2, length / 2) + ")";
            } // 순서 주의
        }

        return String.valueOf(ch); // 첫 좌표의 문자와 다른 문자가 존재하지 않으면 if문에 걸리지 않고 해당 return문에 도달. 첫 좌표에 존재하는 문자를 반환한다
    }
}
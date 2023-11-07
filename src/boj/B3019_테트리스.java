package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://void2017.tistory.com/112

public class B3019_테트리스 {
    static int[][] board;
    static int[] height;
    static int C, P;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        C = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());
        int ans = 0;

        board = new int[105][C];
        height = new int[C];

        token = new StringTokenizer(bf.readLine());

        for(int i=0; i<C; i++){
            height[i] = Integer.parseInt(token.nextToken());
            for(int j=0; j<height[i]; j++) board[j][i]++;
        }

        switch(P){ // 블럭이 바닥에 닿았을 때의 높낮이를 표현
            case 1 : // 1 * 4 블럭
                ans += func(new int[] {0}); // 일자로 세웠을 때
                ans += func(new int[] {0, 0, 0, 0}); // 길게 눕혔을 때
                break;
            case 2: // 2 * 2 블럭
                ans += func(new int[] {0, 0});
                break;
            case 3: //
                ans += func(new int[]{0, 0, 1});
                ans += func(new int[]{1, 0});
                break;
            case 4:
                ans += func(new int[]{1, 0, 0});
                ans += func(new int[]{0, 1});
                break;
            case 5:
                ans += func(new int[] {0, 0, 0}); // ㅗ
                ans += func(new int[] {1, 0}); // ㅓ
                ans += func(new int[] {1, 0, 1}); // ㅜ
                ans += func(new int[] {0, 1}); // ㅏ
                break;
            case 6:
                ans += func(new int[] {0, 0, 0});
                ans += func(new int[] {2, 0});
                ans += func(new int[] {0, 1, 1});
                ans += func(new int[] {0, 0});
                break;
            case 7:
                ans += func(new int[] {0, 0, 0});
                ans += func(new int[] {0, 0});
                ans += func(new int[] {1, 1, 0});
                ans += func(new int[] {0, 2});
                break;
        }
        System.out.println(ans);
    }

    static int func(int[] n){
        int count = 0;

        // 체크해야하는 테트리스 넓이만큼 빼고 계산
        for(int i = 0; i <= C-n.length; i++) {
            int num = height[i];
            int cnt = 0;

            for(int j = 0; j < n.length-1; j++) {
                if(n[0] >= n[j+1]) { // 기준 높이가 다음 높이보다 크거나 같을 때
                    int xx = n[0] - n[j+1];
                    if(num - xx >= 0) {
                        if(board[num-xx][i+j+1] == 0) {
                            if(num-xx-1 == -1) cnt++; // 범위를 벗어나는 경우
                            if(num-xx-1 >= 0 && board[num-xx-1][i+j+1] == 1) cnt++;
                        }
                    }
                } else { // 기준 높이가 다음 높이보다 작을 때
                    int xx = n[0] + n[j+1];
                    if(num + xx >= 0) {
                        if(board[num+xx][i+j+1] == 0) {
                            if(num+xx-1 >= 0 && board[num+xx-1][i+j+1] == 1) cnt++;
                        }
                    }
                }
            }
            if(cnt == (n.length-1)) count++;
        }
        return count;
    }
}

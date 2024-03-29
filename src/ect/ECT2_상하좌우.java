package ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 2023-09-04
* 이것이 코딩 테스트다 2. 그리디 & 구현
* [문제] 상하좌우
* 여행가 A는 N x N 크기의 정사각형 공간 위에 서 있습니다. 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있습니다.
* 가장 왼쪽 위 좌표는 (1, 1)이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당합니다.
* 여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1, 1)입니다.
* 우리 앞에는 여행가 A가 이동할 계획이 적힌 계획서가 놓여 있습니다.
* 계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L, R, U, D 중 하나의 문자가 반복적으로 적혀 있습니다. 각 문자의 의미는 다음과 같습니다.
* - L : 왼쪽으로 한 칸 이동 | R : 오른쪽으로 한 칸 이동
* - U : 위로 한 칸 이동 | D : 아래로 한 칸 이동
* 이때 여행가 A가 N x N 크기의 정사각형 공간을 벗어나는 움직임은 무시합니다.
* 시간 제한 2초 | 메모리 제한 128MB
* [입력 조건]
* - 첫째 줄에 공간의 크기를 나타내는 N이 주어집니다. (1 <= N <= 100)
* - 둘째 줄에 여행가 A가 이동할 계획서 내용이 주어집니다. (1 <= 이동 횟수 <= 100)
* [출력 조건]
* - 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (X, Y)를 공백을 기준으로 구분하여 출력합니다.
* [입력 예시]
* 5
* R R R U D D
* [출력 예시]
* 3 4
*
* [문제 해결 아이디어]
* 요구사항대로 구현하면 되는 문제
* */

public class ECT2_상하좌우 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int x = 1, y = 1; // 시작 좌표는 항상 (1, 1)

        StringTokenizer token = new StringTokenizer(bf.readLine());
        while(token.hasMoreTokens()){
            String s = token.nextToken();

            if(s.equals("L") && x > 1){
                x--;
            }
            else if(s.equals("R") && x < N){
                x++;
            }
            else if(s.equals("U") && y > 1){
                y--;
            }
            else if(s.equals("D") && y < N){
                y++;
            }
        }
        // input


        // operation

        System.out.println(y + " " + x); // 최종적으로 도착할 지점의 좌표
        // output
    }
}

package ect;

/*
* 2023-09-03
* 이것이 코딩 테스트다 2. 그리디 & 구현
* [문제] 1이 될 때까지
* 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 합니다. 단 두 번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있습니다.
* 1. N에서 1을 뺍니다.
* 2. N을 K로 나눕니다.
* N과 K가 주어질 때 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하는 프로그램을 작성하세요.
* 시간 제한 2초 | 메모리 제한 128MB
* [입력 조건] 첫째 줄에 N(1 <= N <= 100,000)과 K(2 <= K <= 100,000)가 공백을 기준으로 하여 각각 자연수로 주어집니다.
* [출력 조건] 첫째 줄에 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 횟수의 최솟값을 출력합니다.
* [입력 예시] 25 5
* [출력 예시] 2
* 문제 해결 아이디어 : 주어진 N에 대하여 최대한 많이 나누기! 나눌 수 있으면 나누고, 그렇지 않으면 -1을 뺀다
* */

import java.util.Scanner;

public class ECT2_1이될때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 어떠한 수 N
        int K = sc.nextInt(); // N을 나누는 수 K
        int ans = 0;
        // input

        while(N > 1){
            if(N>=K && N%K==0) N /= K;
            else N--;

            ans++;
        }
        // operation

        System.out.println(ans);
        // output
    }
}

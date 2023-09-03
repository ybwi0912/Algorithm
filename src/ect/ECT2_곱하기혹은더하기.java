package ect;

/*
* 2023-09-03
* 이것이 코딩 테스트다 2. 그리디 & 구현
* [문제] 곱하기 혹은 더하기
* 각 자리가 숫자(0부터 9)로만 이루어진 문자열 S가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며
* 숫자 사이에 'X' 혹은 '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구하는 프로그램을 작성하세요.
* 단, +보다 X를 먼저 계산하는 일반적인 방식과는 달리, 모든 연산은 왼쪽에서부터 순서대로 이루어진다고 가정합니다.
* 만들어질 수 있는 가장 큰 수는 항상 20억 이하의 정수가 되도록 입력이 주어집니다.
* 시간 제한 1초 | 메모리 제한 128MB
* [입력 조건] 첫째 줄에 여러 개의 숫자로 구성된 하나의 문자열 S가 주어집니다. (1 <= S의 길이 <= 20)
* [출력 조건] 첫째 줄에 만들어질 수 있는 가장 큰 수를 출력합니다.
* [입력 예시 1] 02984 | [출력 예시 1] 576
* [입력 예시 2] 567 | [출력 예시 2] 210
* 문제 해결 아이디어: 두 수에 대하여 연산을 수행할 때, 두 수 중에서 하나라도 1 이하인 경우에는 더하며, 두 수가 모두 2 이상인 경우에는 곱하면 정답
* */

import java.util.Scanner;

public class ECT2_곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int ans = Integer.parseInt(String.valueOf(S.charAt(0)));
        int next = Integer.parseInt(String.valueOf(S.charAt(1)));

        if(ans<=1 || next <= 1) ans += next;
        else ans *= next;

        for(int i=2; i<S.length(); i++){
            int x = Integer.parseInt(String.valueOf(S.charAt(i)));

            if(x<=1) ans += x;
            else ans *= x;
        }

        System.out.println(ans);
    }
}

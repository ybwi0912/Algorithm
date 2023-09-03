package ect;

/*
* 2023-09-03
* 이것이 코딩 테스트다 2. 그리디 & 구현
* [문제] 모험가 길드
* 한 마을에 모험가가 N명 있습니다. 모험가 길드에서는 N명의 모험가를 대상으로 '공포도'를 측정했는데,
* '공포도'가 높은 모험가는 쉽게 공포를 느껴 위험 상황에서 제대로 대처할 능력이 떨어집니다.
* 모험가 길드장인 동빈이는 모험가 그룹을 안전하게 구성하고자 공포도가 X인 모험가는 반드시 X명 이상
* 으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있도록 규정했습니다.
* 동빈이는 최대 몇 개의 모험가 그룹을 만들 수 있는지 궁금합니다. N명의 모험가에 대한 정보가 주어졌을
* 때, 여행을 떠날 수 있는 그룹 수의 최댓값을 구하는 프로그램을 작성하세요.
* 시간 제한 1초 | 메모리 제한 128MB
* [입력 조건] 첫째 줄에 모험가의 수 N이 주어집니다. 둘째 줄에 각 모험가의 공포도의 합을 N 이하의 자연수로 주어지며, 각 자연수는 공백으로 구분합니다.
* [출력 조건] 여행을 떠날 수 있는 그룹 수의 최댓값을 출력합니다.
* [입력 예시]
* 5
* 2 3 1 2 2
* [출력 예시] 2
* [문제 해결 아이디어] 오름차순 정렬 후, 공포도가 가장 낮은 모험가부터 하나씩 확인한다.
* 앞에서부터 공포도를 하나씩 확인하며 현재 그룹에 포함된 모험가의 수가 현재 확인하고 있는 공포도보다 같거나 크다면 이를 그룹으로 설정한다.
* -> 항상 최소한의 모험가의 수만 포함하여 그룹을 결성하게 된다
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ECT2_모험가길드 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer token = new StringTokenizer(bf.readLine());
        int[] hunters = new int[N];
        int[] count = new int[N+1];
        for(int i=0; i<N; i++){
            hunters[i] = Integer.parseInt(token.nextToken());
            count[hunters[i]]++;
        }
        // input

        int ans = 0;
        for(int i=1; i<N+1; i++){
            ans += count[i]%i;
        }
        // operation

        System.out.println(ans);
        // output
    }
}

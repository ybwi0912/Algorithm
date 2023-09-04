package ect;

/*
* 2023-09-04
* 이것이 코딩 테스트다 2. 그리디 & 구현
* [문제] 문자열 재정렬
* 알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어집니다.
* 이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에, 그 뒤에 모든 숫자를 더한 값을 이어서 출력합니다.
* 예를 들어 K1KA5CB7이라는 값이 들어오면 ABCKK13을 출력합니다.
* 시간 제한 1초 | 메모리 제한 128MB
* [입력 조건] 첫째 줄에 하나의 문자열 S가 주어집니다. (1 <= S의 길이 <= 10,000)
* [출력 조건] 첫째 줄에 문제에서 요구하는 정답을 출력합니다.
* [입력 예시 1] K1KA5CB7 | [출력 예시 1] ABCKK13
* [입력 예시 2] AJKDLSI412K4JSJ9D | [출력 예시 2] ADDIJJJKKLSS20
*
* [문제 해결 아이디어]
* 요구사항대로 구현 - 숫자의 경우 합계를 따로 계산, 알파벳의 경우 별도의 리스트에 저장 후 정렬해 양식에 맞게 출력한다
* */

import java.util.*;

public class ECT2_문자열재정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        List<Character> characters = new ArrayList<>();
        int sum = 0;

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c>=65){
                characters.add(c);
            } else {
                sum += (c - 48);
            }
        }

        Collections.sort(characters);

        for(char c : characters){
            System.out.print(c);
        }
        System.out.println(sum);
    }
}

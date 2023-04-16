package prog;

import java.util.Arrays;

/**
 * 전상희, 2023-04-15
 * Sorting
 * */

public class P42748_K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        // input

        int[] ans = Solution.solution(array, commands);
        // operation

        System.out.println(Arrays.toString(ans));
        // output
    }

    static class Solution {
        public static int[] solution(int[] array, int[][] commands) {
            int count = 0;
//            for(int[] a : commands){
//                count++;
//            }
//            int[] answer = new int[count];
            int[] answer = new int[commands.length];
            /*
            * for문 자체도, for문 안에서 생성되는 a 변수도 메모리와 시간을 잡아먹기 때문에 .length 메소드 활용이 나아 보인다
            * */
            count = 0;

            for(int[] comArr : commands){ // 각 연산
//                int len = comArr[1] - comArr[0] + 1;
//                int[] newArr = new int[len]; // 각 연산마다 새로 생기는 배열
//                for(int i=0; i<len; i++){
//                    newArr[i] = array[comArr[0]-1+i];
//                }
                int[] newArr = Arrays.copyOfRange(array, comArr[0]-1, comArr[1]);
                /*
                * 어차피 Arrays를 import할 거면 .copyOfRange 메소드를 활용하는 것이 속도도 빠르고
                * 매번 크기(len)을 계산하는 번거로움도 줄일 수 있다
                * copyOfRange(원본 배열, 시작 인덱스, 끝 인덱스) - 원본 배열이 그대로 유지된다
                * */

                Arrays.sort(newArr);
//                int i = newArr[comArr[2]-1];
//                answer[count] = i;
//                count++;
                answer[count++] = newArr[comArr[2]-1];
                /*
                * 불필요한 i 변수 선언 대신 한 줄로 줄일 수 있다
                * */

            }
            return answer;
        }
    }
}

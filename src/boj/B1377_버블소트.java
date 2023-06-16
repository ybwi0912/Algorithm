package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2023-06-16
 * Bubble Sort + 책 풀이 참고
 * 문제에서 주어진 알고리즘은 버블 정렬을 하면서 한번도 swap이 일어나지 않았을 때 몇 번째 루프를 돌고 있는지 출력하는 코드이다
 * */

public class B1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 수의 개수
        arrIdx[] arr = new arrIdx[N];

        for(int i=0; i<N; i++){
            arr[i] = new arrIdx(Integer.parseInt(bf.readLine()), i); // value, index i 저장
        }
        // input

        Arrays.sort(arr);

        int max = 0;
        for(int i=0; i<N; i++){
            if(max < arr[i].index - i){
                max = arr[i].index - i;
            }
        }
        // operation

        System.out.println(max + 1);
        // output
    }
}

class arrIdx implements Comparable<arrIdx>{
    // 기존 인덱스와 값을 함께 저장해두기 위한 별도의 클래스 생성
    int value;
    int index;

    public arrIdx(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(arrIdx o){
        return this.value - o.value;
    } // sort() 돌렸을 때 value 기준으로 오름차순 정렬하기 위해 compareTo 재정의
}

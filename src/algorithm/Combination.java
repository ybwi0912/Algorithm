package algorithm;
import java.util.ArrayList;

public class Combination {
    static char[] arr;
    static int[] selection; // 현재 선택한 요소
    // 인덱스가 저장된다
    static int R; // 선택할 개수
    static boolean[] isSelected; // 마킹 배열 - 선택했는지 체크

    public static void combination(int r, int start) {
        // r(뽑은 개수) + 파라미터를 추가
        // 이전에 뽑은 값을 기억할 수 있도록
        if(r==R) { // R개 선택 완료
            for(int i=0; i<R; i++) System.out.print(arr[selection[i]]);
            System.out.println();
            return;
        }

        for(int i=start; i<arr.length; i++) { // 지나간 값들은 안 본다
            if(isSelected[i]) continue; // 중복된 값을 뽑았을 경우 스킵

            isSelected[i] = true;
            selection[r] = i;
            combination(r+1, i);
            isSelected[i] = false;

        } // 중복 선택 X
    }

    public static void main(String[] args) {
        arr = new char[] {'A', 'B', 'C', 'D'};
        R = 2; // 선택할 개수 지정
        selection = new int[R];
        isSelected = new boolean[arr.length]; // 크기를 R로 했더니 안 돌아갔다!!
        combination(0, 0);
    }

}

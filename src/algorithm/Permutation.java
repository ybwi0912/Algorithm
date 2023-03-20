package algorithm;

public class Permutation {
    static char[] arr = {'b', 'e', 'i', 'n'};
    static int[] selection; // 현재 선택한 요소
    static int R; // 선택할 개수
    static boolean[] isSelected; // 마킹 배열 - 선택했는지 체크

    // 백트래킹 (23.03.20)

    public static void permutation(int r) {
        if(r==R) { // R개 선택 완료
            for(int i=0; i<R; i++) System.out.print(arr[selection[i]]);
            System.out.println();
            return;
        } // 종료

        for(int i=0; i<arr.length; i++) {
            if(isSelected[i]) continue; // 중복된 값을 뽑았을 경우 스킵

            isSelected[i] = true;
            selection[r] = i;
            permutation(r+1);
            isSelected[i] = false; // 중복 허용 X (마킹 해제)

        } // 분기
    }

    public static void main(String[] args) {
        R = 4; // 선택할 개수 지정
        selection = new int[R];
        isSelected = new boolean[arr.length]; // 크기를 R로 했더니 안 돌아갔다!!

        permutation(0);
    }
}

package boj;

import java.util.Scanner;
/**
 * 23. 03. 20
 * 전상희
 * 백준 9663번 : N x N 체스판에 퀸 N개 배치 - 같은 행 X, 같은 열 X, 대각선 X
 * 풀이 1 ) 1부터 N까지 돌면서 행 열 대각선 조건이 맞을 때만 DFS 재귀 진행, 끝까지 돌면 count++ << 내 풀이 !!
 * 풀이 2 ) 순열로 만든 다음에 각각의 핀들이 대각선 조건에 걸리는지 체크
 * */
public class B9663_NQueen3 {
    static int N;
    static int arr[];
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 크기가 N x N인 체스판
        // 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수

        count = 0;
        arr = new int[N]; // 일차원 배열 - 인덱스를 행으로 봄
        dfs(0);
        System.out.println(count);

    }

    static void dfs(int level){
        if(level == N) count++;
        else{
            for(int i=0; i<arr.length; i++){
                arr[level] = i;
                if(check(level)) dfs(level+1);
            }
        }
    }

    static boolean check(int num){
        for(int i=0; i<num; i++){
            if(arr[i] == arr[num]) return false; // 같은 열에 위치하는지 체크
            else if(Math.abs(arr[i]-arr[num]) == Math.abs(i-num)) return false;
            // 두 점이 만드는 직선의 기울기가 1이라면 두 점이 대각선 자리에 위치했음을 의미한다 
        }
        return true;
    }
}

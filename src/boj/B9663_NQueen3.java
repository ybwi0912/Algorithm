package boj;

import java.util.Scanner;

public class B9663_NQueen3 {
    static int N;
    static int arr[];
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 크기가 N x N인 체스판
        // 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수

        count = 0;
        arr = new int[N];
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
            if(arr[i] == arr[num]) return false;
            else if(Math.abs(arr[i]-arr[num]) == Math.abs(i-num)) return false;
        }
        return true;
    }
}

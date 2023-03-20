package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 23- 03 - 20
 * 전상희
 * 백준 13023번 - 사람 N명 중에서 A-B-C-D-E 친구 관계가 존재한다면 1, 없다면 0을 출력
 * */
public class B13023_ABCDE {
    static ArrayList<Integer>[] people;
    static int flag;
    static boolean[] isVisited;

    static void DFS(int startV, int count) { // count : depth 확인. 4보다 커지는 순간 조건이 True가 된다
        isVisited[startV] = true; // 체크 ㅇ
        //System.out.println(count);
        if(count >= 4) {
            flag = 1;
            return; // 종료 조건
        }
        //System.out.print(startV + " ");
        for(int nextNode : people[startV]) {
            if(isVisited[nextNode]) continue;

            DFS(nextNode, count + 1);

            isVisited[nextNode] = false; // 체크 해제 << 이 부분이 중요!
        } // 백트래킹에서 가장 중요한 부분 !!
        // 말단 노드를 만났거나 조건에 안 맞는 노드를 만났을 때
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(token.nextToken()); // 사람의 수(5~2000)
        int M = Integer.parseInt(token.nextToken()); // 친구 관계의 수(1~2000)

        people = new ArrayList[N];
        isVisited = new boolean[N];
        //count = new int[N];
        for(int i=0; i<N; i++){
            people[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            token = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());

            people[u].add(v);
            people[v].add(u);
        }

        /*for(int i=0; i<N; i++) {
            Collections.sort(people[i]);
            // System.out.println(people[i]);
        }*/

        flag = 0;

        for(int i=0; i<N; i++){ // 모든 노드에 대해서 탐색을 돌린다
            isVisited = new boolean[N];
            DFS(i, 0);
            // System.out.println();
            if(flag == 1) break;
        }
        // DFS(0);

        System.out.println(flag);

        // System.out.println(Arrays.toString(count));
    }
}

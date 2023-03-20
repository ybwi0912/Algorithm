package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13023_ABCDE {
    static ArrayList<Integer>[] people;
    static int flag;
    static boolean[] isVisited;

    static void DFS(int startV, int count) {
        isVisited[startV] = true;
        //System.out.println(count);
        if(count >= 4) {
            flag = 1;
            System.out.println(count +" " + flag);
            return;
        }
        //System.out.print(startV + " ");
        for(int nextNode : people[startV]) {
            if(isVisited[nextNode]) continue;

            DFS(nextNode, count + 1);

            isVisited[nextNode] = false;
        }
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

        for(int i=0; i<N; i++){
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

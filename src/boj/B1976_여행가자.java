package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976_여행가자 {
    static int city[];
    static int find(int x){
        if(x == city[x]) return x;
        return city[x] = find(city[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(x<y) city[y] = x;
            else city[x] = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // 도시의 수
        int M = Integer.parseInt(bf.readLine()); // 여행 계획에 속한 도시의 수

        city = new int[N]; // 도시 목록
        for(int i=0; i<N; i++){
            city[i] = i;
        }

        for(int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(token.nextToken());
                if(a == 1){ // 자기 자신은 검사 X
                    union(i, j);
                }
            }
        }

        int[] plan = new int[M]; // 여행 계획이 들어갈 배열
        StringTokenizer token = new StringTokenizer(bf.readLine());

        for(int i=0; i<M; i++)
            plan[i] = Integer.parseInt(token.nextToken()) - 1;

        int flag = 0;

        for(int i=0; i<M-1; i++){ // 여행 계획에 대해 -
            if(find(plan[i]) != find(plan[i+1])) flag = 1;
        }

        if(flag ==1) System.out.println("NO");
        else System.out.println("YES");

    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1717_집합의표현 {
    static int parent[];
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(x<y) parent[y] = x;
            else parent[x] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken()); // n+1개의 집합이 주어진다
        int m = Integer.parseInt(token.nextToken()); // 입력으로 주어지는 연산의 개수
        parent = new int[n+1];

        for(int i=0; i<n+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            token = new StringTokenizer(bf.readLine());
            int operator = Integer.parseInt(token.nextToken());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            if(operator == 0){
                union(a, b);
            }
            else if(operator == 1){
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}

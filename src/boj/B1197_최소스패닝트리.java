package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1197_최소스패닝트리 {
    static int parent[];
    static class Edge{
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return "[" + this.start + ", " + this.end + ", " +  this.weight + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        
        int V = Integer.parseInt(token.nextToken()); // 정점의 개수
        int E = Integer.parseInt(token.nextToken()); // 간선의 개수

        int ans = 0;
        parent = new int [V+1];
        Arrays.setAll(parent, i->i); // 초기화

        Edge[] edges = new Edge[E]; // 간선의 개수 E개만큼
        
        for(int i=0; i<E; i++){
            token = new StringTokenizer(bf.readLine(), " ");
            int u = Integer.parseInt(token.nextToken()); // 시작
            int v = Integer.parseInt(token.nextToken()); // 끝
            int weight = Integer.parseInt(token.nextToken()); // 가중치
            edges[i] = new Edge(u, v, weight);
        } 
        
        // 간선들을.. 가중치를 기준으로 오름차순 정렬해줘야
        Arrays.sort(edges, (a, b) -> (a.weight - b.weight)); // 람다식 !!!!

        // 구현부
        for(int i=0; i<E; i++){
            Edge a = edges[i];
            int start = a.start;
            int end = a.end;
            //Edge b = edges[i];
            if(find(start) != find(end)) {
                union(start, end);
                ans += a.weight;
            }
        }

        System.out.println(Arrays.toString(parent));
        System.out.println(ans);
    }

    // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}

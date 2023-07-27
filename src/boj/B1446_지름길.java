package boj;

import java.io.*;
import java.util.*;

/*
* 2023-07-27
* BOJ 1446: 지름길
* 다익스트라
* */

public class B1446_지름길 {
    static int N, D; // 지름길의 개수, 고속도로의 길이

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken()); // 지름길의 개수
        D = Integer.parseInt(token.nextToken()); // 고속도로의 길이

        List<Graph> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            token = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int len = Integer.parseInt(token.nextToken());

            if(end > D) continue; // 목적지를 지나쳐 가는 경우 역주행 불가능

            if(end - start <= len) continue; // 지름길이 아닌 경우

            list.add(new Graph(start, end, len));
        }
        // input

        // list 정렬 과정 필요 (comparator)
        Collections.sort(list, new Comparator<Graph>() {
            @Override
            public int compare(Graph o1, Graph o2) {
                if(o1.start == o2.start) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int index = 0; // 리스트 인덱스 확인 위한 변수
        int move = 0; // 어디까지 진행했는지 확인하기 위함

        int[] dist = new int[101]; // padding(모든 위치와 길이는 10000보다 작거나 같은 자연수)
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        while(move < D){ // 목적지까지
            if(index < list.size()){
                Graph g = list.get(index);
                if(move == g.start){
                    dist[g.end] = Math.min(dist[move] + g.len, dist[g.end]);
                    index++;
                } else{
                    dist[move + 1] = Math.min(dist[move+1], dist[move] + 1);
                    move++;
                }
            } else {
                dist[move + 1] = Math.min(dist[move + 1] , dist[move] + 1);
                move++;
            }
        }
        // operation

        System.out.println(dist[D]);
        // output
    }

    static class Graph{
        int start; // 시작 위치
        int end; // 도착 위치
        int len; // 지름길의 길이

        public Graph(int start, int end, int len){
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }
}

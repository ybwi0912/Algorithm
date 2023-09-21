package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
* 2023-09-21
* BOJ 2841번: 외계인의 기타 연주
*
* */

public class B2841_외계인의기타연주 {
    static int N; // 멜로디에 포함되어 있는 음의 수
    static int P; // 한 줄에 있는 프렛의 수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());

        Stack<Integer>[] strings = new Stack[6];
        for(int i=0; i<6; i++){
            strings[i] = new Stack();
        }

        int count = 0;

        for(int i=0; i<N; i++){
            token = new StringTokenizer(bf.readLine());
            int line = Integer.parseInt(token.nextToken()) - 1;
            int fret = Integer.parseInt(token.nextToken());

            while(!strings[line].isEmpty() && strings[line].peek()>fret){
                strings[line].pop();
                count++;
            }

            if(strings[line].empty() || (!strings[line].isEmpty() && strings[line].peek() < fret)){
                strings[line].add(fret);
                count++;
            }
        }

        System.out.println(count);
    }
}

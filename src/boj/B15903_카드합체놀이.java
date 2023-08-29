package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B15903_카드합체놀이 {
    static int n, m;
    static long[] cards;
    static long sum = 0;
    static PriorityQueue<Long> input;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        cards = new long[n];
        input = new PriorityQueue<>();

        token = new StringTokenizer(bf.readLine());

        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(token.nextToken());
            input.add(Long.parseLong(token.nextToken()));
        }
        // input

        sol1();
        sol2();
        // operation

        System.out.println(sum);
        // output
    }

    private static void sol1() {
        for(int i=0; i<m; i++){
            Arrays.sort(cards);
            long add = cards[0] + cards[1];
            cards[0] = add;
            cards[1] = add;
        }

        for(long i : cards){
            sum += i;
        }
    }

    private static void sol2(){
        long x = 0, y = 0;

        for(int i=0; i<m; i++){
            if(!input.isEmpty()) x = input.poll();
            if(!input.isEmpty()) y = input.poll();

            long add = x + y;
            input.add(add);
            input.add(add);
        }

        sum = 0;
        while(!input.isEmpty()){
            sum += input.poll();
        }
    }
}

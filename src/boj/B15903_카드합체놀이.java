package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15903_카드합체놀이 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        long[] cards = new long[n];

        token = new StringTokenizer(bf.readLine());

        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(token.nextToken());
        }

        for(int i=0; i<m; i++){
            Arrays.sort(cards);
            long add = cards[0] + cards[1];
            cards[0] = add;
            cards[1] = add;
        }

        long sum = 0;
        for(long i : cards){
            sum += i;
        }

        System.out.println(sum);
    }
}

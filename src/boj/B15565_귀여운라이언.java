package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15565_귀여운라이언 {
    static int min = Integer.MAX_VALUE;
    static int[] dolls;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        dolls = new int[N];
        List<Integer> d = new ArrayList<>();
        token = new StringTokenizer(bf.readLine());

        for(int i=0; i<N; i++) {
            dolls[i] = Integer.parseInt(token.nextToken());
            if (dolls[i]==1){
                d.add(i);
            }
        }

        System.out.println(d);
        for (int i=0; i<d.size()-K+1; i++){
            int s = d.get(i+K-1) - d.get(i) + 1;
            System.out.println(i + " " + d.get(i+K-1) + " " + d.get(i));
            min = Integer.min(min, s);
        }

        if (min==Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }
}

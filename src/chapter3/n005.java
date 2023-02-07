package chapter3;

import java.util.Scanner;

public class n005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] S = new long[N];
        long[] count = new long[M];
        long answer = 0;
        S[0] = sc.nextInt();

        for (int i=1; i<N; i++){
            S[i] = S[i-1] + sc.nextInt();
        }

        for(int i=0; i<N; i++){
            int remainder = (int)(S[i] % M);
            if(remainder == 0 ){
                answer++;
            }
            count[remainder]++;
        }

        for(int i=0; i<M; i++){
            answer += count[i] * (count[i]-1) / 2 ;
        }

        System.out.println(answer);

    }
}

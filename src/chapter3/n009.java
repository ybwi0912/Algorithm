package chapter3;

import java.util.Scanner;

public class n009 {
    static int min[];
    static int now[];
    static int ans;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // 주어질 DNA 문자열의 길이
        int P = sc.nextInt(); // 부분 문자열의 길이
        String dna= sc.next(); // DNA 문자열
        char[] arrS = new char[S];
        dna.getChars(0, S, arrS, 0); // 문자열을 char 배열 A에 저장

        min = new int[4]; // 비밀번호 체크 배열
        for(int i=0;i<4;i++){
            min[i] = sc.nextInt();
        }
        now = new int[4];
        ans = 0;

        for (int i=0; i<P; i++){
            Add(arrS[i]);
        }
        Check();

        for(int i=P; i<S; i++){
            Remove(arrS[i-P]);
            Add(arrS[i]);
            Check();
        }
        System.out.println(ans);
    }

    private static void Add(char c){
        switch(c){
            case 'A':
                now[0]++;
                break;
            case 'C':
                now[1]++;
                break;
            case 'G':
                now[2]++;
                break;
            case 'T':
                now[3]++;
                break;
        }
    }

    private static void Remove(char c){
        switch(c){
            case 'A':
                now[0]--;
                break;
            case 'C':
                now[1]--;
                break;
            case 'G':
                now[2]--;
                break;
            case 'T':
                now[3]--;
                break;
        }
    }

    private static void Check(){
        int count=0;
        for(int i=0;i<4;i++){
            if(min[i]<=now[i]) count++;
        }
        if(count==4) ans++;
    }
}

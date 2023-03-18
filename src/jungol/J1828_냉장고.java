package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class J1828_냉장고 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        int N = Integer.parseInt(bf.readLine()); // 화학 물질의 수
        int[][] material = new int[N][2];

        int count = 1; // 냉장고

        for(int i=0; i<N; i++){
            token = new StringTokenizer(bf.readLine());
            material[i][0] = Integer.parseInt(token.nextToken());
            material[i][1] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(material, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int max = material[0][1];

        for(int i=0; i<N; i++){
            if(material[i][0] <= max){
                if(material[i][1]<max){
                    max = material[i][1];
                }
                continue;
            }
            else{
                max = material[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}

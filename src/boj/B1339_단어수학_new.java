package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1339_단어수학_new {
    static int N;
    static ArrayList<String> arr = new ArrayList<>(); // N개의 단어
    static int[] alphabet = new int[26]; // A to Z

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine()); // 단어의 개수
        int index = 9; // 9~0 수
        int sum = 0;

        for(int i=0; i<N; i++) {
            arr.add(bf.readLine());
        }
        // input

        for(int i=0; i<N; i++){
            int temp = (int)Math.pow(10,arr.get(i).length()-1);
            for(int j=0; j<arr.get(i).length(); j++){
                alphabet[(int)arr.get(i).charAt(j)-65]+=temp;
                temp /=10;
            }
        }
        Arrays.sort(alphabet);

        for(int i=alphabet.length-1; i>=0; i--){
            if(alphabet[i] == 0){
                break;
            }
            sum+= alphabet[i]*index;
            index--;
        }
        System.out.println(sum);

    }
}

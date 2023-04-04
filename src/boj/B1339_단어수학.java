package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1339_단어수학 {
    static int N;
    static int[] newChars = new int[10]; // 0부터 9까지의 숫자를 저장
    static int count = 9;
    static ArrayList<String> arr = new ArrayList<>(); // N개의 단어
    static int[] len = new int[10];
    static ArrayList<Integer> nums = new ArrayList<>(); // N개의 수 (변환됨)
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine()); // 단어의 개수

        for(int i=0; i<N; i++) {
            arr.add(bf.readLine());
            len[i] = arr.get(i).length();
        }
        // input

        while(!arr.isEmpty()){
            // arr가 빌 때까지
            int max = 0;
            int idx = 0;
            for(String str : arr){
                if(max<str.length()) {
                    max = str.length();
                    idx = arr.indexOf(str);
                }
            }

            String str = arr.get(idx);
            System.out.println(str);
            for(int i=0; i<str.length(); i++){
                char now = str.charAt(i);
                if (now >= 65) {
                    System.out.println(now + " " + (int)now);
                    if(newChars[now-65] == 0) {
                        newChars[now-65] = count;
                        count--;
                    }
                    System.out.println(count + " " + Arrays.toString(newChars));
                    System.out.println(newChars[now-65] + " : " + (char)(newChars[now-65]+'0'));
                    str = str.replace(now, (char) (newChars[now-65]+'0'));
                    System.out.println(str);
                }
            }

            System.out.println("str = " + str);
            arr.remove(idx);
            System.out.println(max + " " + idx);
            nums.add(Integer.parseInt(str));

        }

        System.out.println(nums);
        for(int i : nums) answer += i;

        System.out.println(answer);
        // output
    }
}

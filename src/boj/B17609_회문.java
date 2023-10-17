package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609_회문 {
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int i=0; i<T; i++){
            String input = bf.readLine();

            int start = 0;
            int end = input.length() - 1;
            int ans = 0;

            while(start < end){
                if(input.charAt(start) == input.charAt(end)){
                    start++;
                    end--;
                }
                else if(check2(input.substring(start, end))){ // start ~ end - 1
                    ans = 1;
                    break;
                }
                else if(check2(input.substring(start + 1, end + 1))) { // start + 1 ~ end
                    ans = 1;
                    break;
                }
                else {
                    ans = 2;
                    break;
                }
            }
            sb.append(ans + "\n");
        }

        System.out.println(sb.toString());
    }

    static boolean check2(String s){
        int start = 0;
        int end = s.length() - 1;

        while(start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
}

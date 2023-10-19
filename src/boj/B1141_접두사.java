package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class B1141_접두사 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String[] input = new String[N];

        for(int i=0; i<N; i++) input[i] = bf.readLine();

        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });

        HashSet<String> set = new HashSet<>();

        set.add(input[0]);

        for(int i=1; i<N; i++){
            boolean check = false;
            for(String s : set){
                if(s.indexOf(input[i])==0) check = true;

            }
            if(!check) set.add(input[i]);
        }

        System.out.println(set.size());
    }
}

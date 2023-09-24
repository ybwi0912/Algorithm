package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int arr[] = new int[N];

        StringTokenizer token = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(token.nextToken());
        int ans[] = new int[N];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            int now = arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] < now) {
                stack.pop();
            }

            if(!stack.isEmpty()) ans[i] = stack.peek() + 1;
            stack.push(i);

        }

        for(int i=0; i<N; i++) System.out.print(ans[i] + " ");
    }
}

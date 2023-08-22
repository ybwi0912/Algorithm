package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20055_컨베이어벨트위의로봇 {
    static int N, K; // 컨베이어 벨트의 길이 N, 내구도가 0인 칸의 개수가 K개 이상일 때 과정 종료
    static int[] conveyor; // 컨베이어 벨트 칸의 내구도
    static boolean[] isExist; // 컨베이어 벨트의 해당 칸에 로봇이 존재하는지 체크하기 위한 배열
    static int cnt, zero; // 단계 cnt, 내구도가 0인 칸의 개수 zero

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(token.nextToken()); // 컨베이어 벨트의 길이
        K = Integer.parseInt(token.nextToken()); // 과정 종료 조건

        conveyor = new int[2*N + 1];
        isExist = new boolean[2*N + 1];
        token = new StringTokenizer(bf.readLine());

        for(int i=1; i<2*N + 1; i++){
            conveyor[i] = Integer.parseInt(token.nextToken());
        }

        cnt = 0;
        zero = 0;

        while(true){
            rotate(); // 벨트 회전
            move(); // 로봇 이동
            cnt++;

            if(zero >= K) break;
        }

        System.out.println(cnt);
    }

    static void move(){
        if(isExist[N] == true){
            isExist[N] = false;
            // 내리는 위치(N번 칸)에 로봇이 존재한다면 로봇을 내린다
        }

        for(int i=N-1; i>0; i--){ // 내리는 위치와 가까운 칸부터 1번 칸까지 체크
            if(isExist[i]) {
                if (!isExist[i + 1] && conveyor[i + 1] > 0) {
                    // 만약 해당 위치에 로봇이 존재하고, 다음 칸에 로봇이 없고, 다음 칸의 내구도가 0 이상이라면
                    isExist[i] = false; // 해당 위치에서 로봇을 들어서
                    isExist[i + 1] = true; // 다음 칸으로 옮기고
                    if (--conveyor[i + 1] <= 0) zero++; // 다음 칸의 내구도를 1 감소시킨다
                    // 만약 이동한 칸의 내구도가 0이 되었다면 zero를 1 증가시킨다
                }
            }
        }

        if(!isExist[1] && conveyor[1] > 0){
            isExist[1] = true;
            if(--conveyor[1] <= 0) zero++;
        }

        if(isExist[N] == true){
            isExist[N] = false;
            // 내리는 위치(N번 칸)에 로봇이 존재한다면 로봇을 내린다
        }
    }

    static void rotate(){
        conveyor[0] = conveyor[2*N];
        for(int i=2*N; i>1; i--){
            conveyor[i] = conveyor[i-1];
        }
        conveyor[1] = conveyor[0];
        // 컨베이어 벨트 한 칸씩 이동

        isExist[0] = isExist[2*N];
        for(int i=2*N; i>1; i--){
            isExist[i] = isExist[i-1];
        }
        isExist[1] = isExist[0];
        // 컨베이어 벨트 위에 존재하는 로봇들도 한 칸씩 이동
    }
}

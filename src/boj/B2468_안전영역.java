package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* BOJ 2468번: 안전 영역
* [ 문제 ]
* 재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다.
* 먼저 어떤 지역의 높이 정보를 파악한다. 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다.
* 이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
* 어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다.
* 어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.
*
* [ 입력 ]
* 첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다. N은 2 이상 100 이하의 정수이다.
* 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다.
* 각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다.
* 높이는 1이상 100 이하의 정수이다.
*
* [ 출력 ]
* 첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.
*
* [ 예제 입력 1 ]
* 5
* 6 8 2 6 2
* 3 2 3 4 6
* 6 7 3 3 2
* 7 2 5 3 6
* 8 9 5 2 7
*
* [ 예제 출력 1 ]
* 5
*
* [ 예제 입력 2 ]
* 7
* 9 9 9 9 9 9 9
* 9 2 1 2 1 2 9
* 9 1 8 7 8 1 9
* 9 2 7 9 7 2 9
* 9 1 8 7 8 1 9
* 9 2 1 2 1 2 9
* 9 9 9 9 9 9 9
*
* [ 예제 출력 2 ]
* 6
*
* [ 노트 ]
* 아무 지역도 물에 잠기지 않을 수도 있다.
 * */

public class B2468_안전영역 {
    static int[][] field;
    static boolean[][] isvisited;
    static int N;
    static int answer = 1;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());

        field = new int[N][N];

        int max = 0;

        for(int i=0; i<N; i++){
            token = new StringTokenizer(bf.readLine());

            for(int j=0; j<N; j++){
                field[i][j] = Integer.parseInt(token.nextToken());
                max = Integer.max(field[i][j], max);
            }
        }
        // input

        for(int i=1; i<max; i++){
            isvisited = new boolean[N][N];
            int count = 0;
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(field[j][k]<=i) isvisited[j][k] = true;
                    // 물에 잠기는 영역을 방문 처리해 탐색 시 방문하지 못하게 한다
                }
            }

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(!isvisited[j][k]){
                        count++;
                        isvisited[j][k] = true;
                        search(j, k);
                    }
                }
            }

            answer = Integer.max(answer, count);
//            System.out.println(i + "까지 물에 잠길 때, 영역의 최대 개수 " + count);
        }
        // operation

        System.out.println(answer);
        // output
    }

    static void search(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny < 0 || nx >=N || ny >= N) continue;

            if(!isvisited[nx][ny]){
                isvisited[nx][ny] = true;
                search(nx, ny);
            }
        }
    }
}

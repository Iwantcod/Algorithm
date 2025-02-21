import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int[][] ary = new int[n][m];
        int youngTomatoCnt = 0; // 덜익은 토마토 카운트
        int days = 0;
        int tmpCnt = 0; // 해당 시점에 익은 토마토가 몇 개인지 기록하는 카운트 변수

        Queue<Integer[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                ary[i][j] = tmp;
                if(tmp == 0) {
                    youngTomatoCnt++;
                } else if(tmp == 1) {
                    q.add(new Integer[]{i, j}); // 익은 토마토의 좌표를 큐에 담는다.
                    tmpCnt++;
                }
            }
        }

        if(youngTomatoCnt == m * n) { // 상자의 모든 토마토가 익지 않았으면, 모두 익지 못하는 상황이다.
            bw.write("-1");
        } else if(q.size() == m * n) { // 상자의 모든 토마토가 있었으면, 계산할 필요 없다.
            bw.write("0");
        } else if(q.isEmpty()) { // 익은 토마토가 아예 없으면, 계산할 필요 없다.
            bw.write("-1");
        }else {
            // 각 방향으로 익지 않은 토마토를 익게 만들었는지 여부 기록(하루 단위)
            boolean up = false;
            boolean left = false;
            boolean down = false;
            boolean right = false;


            // 상하좌우 방향으로 BFS하는 것과 유사하다.
            while(!q.isEmpty()) {
                Integer[] arr = q.poll();
                tmpCnt--;
                int i = arr[0];
                int j = arr[1];
                ary[i][j] = 2;

                if(i > 0) { // 윗 방향 조회
                    if(ary[i-1][j] == 0) {
                        ary[i-1][j] = 1;
                        q.add(new Integer[]{i-1, j});
                        up = true;
                        youngTomatoCnt--;
                    }
                }
                if(j > 0) { // 왼 방향 조회
                    if(ary[i][j-1] == 0) {
                        ary[i][j-1] = 1;
                        q.add(new Integer[]{i, j-1});
                        left = true;
                        youngTomatoCnt--;
                    }
                }
                if (i < n - 1) { // 아래 방향 조회
                    if(ary[i+1][j] == 0) {
                        ary[i+1][j] = 1;
                        q.add(new Integer[]{i+1, j});
                        down = true;
                        youngTomatoCnt--;
                    }
                }
                if(j < m - 1) { // 오른 방향 조회
                    if(ary[i][j+1] == 0) {
                        ary[i][j+1] = 1;
                        q.add(new Integer[]{i, j+1});
                        right = true;
                        youngTomatoCnt--;
                    }
                }

                if(tmpCnt == 0) {
                    // 현재 시점(하루 단위)에서 익은 토마토가 전염(?)을 모두 마쳤을 때를 의미한다.
                    // 그 다음 시점에서는 익은 토마토가 몇 개인지 계산해서 값을 설정한다.
                    // 이때, 이전에 계산에 사용된 토마토는 제외한다.
                    tmpCnt = q.size();
                    if(up || down || left || right) {
                        // 인근에 익지 않은 토마토가 하나라도 발견되어야 기간을 카운트한다.
                        days++;
                    } else if(youngTomatoCnt == 0) {
                        // 인근에 익지 않은 토마토가 없고, 더 이상 익지 않은 토마토 자체가 아예 없을 때는 모든 연산 종료, 소요 시간을 출력
                        bw.write(String.valueOf(days));
                        break;
                    } else {
                        // 위 두 가지 경우가 아니라면 모두 익게 만드는 것에 실패했음을 의미한다.
                        bw.write("-1");
                    }
                    up = down = left = right = false; // 다음 시점에서의 계산을 위해
                }
            }
        }
        bw.close();
    }
}
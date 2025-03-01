import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int INF = 900000000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    map[i][j] = 0; // 자기 자신에게 가는 비용은 0
                } else {
                    map[i][j] = INF; // 연결되지 않은 노드의 거리는 무한대(입력범위 밖)로 나타낸다.
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            if(map[src][dest] > cost) {
                map[src][dest] = cost; // 새로 입력되는 값과 기존 값을 비교하여 더 작은 비용을 기록
            }
        }
        // 계산 시작
        for (int k = 0; k < n; k++) { // k: 경유 노드
            for (int i = 0; i < n; i++) { // i: 출발 노드
                if(k == i) {
                    continue;
                }
                for (int j = 0; j < n; j++) { // j: 도착 노드
                    if(i == j || k == j) {
                        continue;
                    }
                    // k: i 노드와 j 노드의 징검다리 역할을 하는 경유 노드의 경우의 수를 순회하기 위해 존재하는 반복자
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                    // 기본값으로 주어지는 엣지 값을 포함한 i 노드와 j 노드를 경유하는 k노드를 거치는 모든 경우의 수 중 가장 작은 값을 기록
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j || map[i][j] == INF) { // 도달할 수 없는 곳은 0으로 표시한다.
                    map[i][j] = 0;
                }
                bw.write(String.valueOf(map[i][j])+" ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
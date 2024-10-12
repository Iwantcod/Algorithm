import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 유류비 제일 싼 지역 인덱스값 확인(마지막 지역은 제외)
        // 각 지역에서 다음 지역까지의 거리만큼만 기름 충전
        // 그러다가 가장 유류비가 저렴한 지역에 도착하면, 남은 모든 거리만큼의 기름 충전

        // 도시의 수
        int N = Integer.parseInt(br.readLine());

        long[] road = new long[N-1];
        long[] cost = new long[N];

        // 유류비 가장 싼곳에 도착했을 때 사용하기 위한 남은 총 도로의 길이
        long lengthLeft = 0;

        // 각 도시를 잇는 도로의 길이
        StringTokenizer strtk1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N-1; i++) {
            road[i] = Integer.parseInt(strtk1.nextToken());
            lengthLeft += road[i];
        }

        StringTokenizer strtk2 = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < N-1; j++) {
            cost[j] = Integer.parseInt(strtk2.nextToken());
        }


        long minCost = cost[0];
        long result = road[0] * cost[0];
        for (int k = 1; k < N-1; k++) {
            // minCost == 현재 가본 도시들 중에서, 가장 저렴한 유류비를 기록한 변수
            if(cost[k] < minCost) {
                minCost = cost[k];
            }
            result += minCost * road[k];
        }
        System.out.print(result);
    }
}
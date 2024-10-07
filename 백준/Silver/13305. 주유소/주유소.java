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

        int[] road = new int[N-1];
        int[] cost = new int[N];

        // 유류비 가장 싼곳에 도착했을 때 사용하기 위한 남은 총 도로의 길이
        long lengthLeft = 0;

        // 각 도시를 잇는 도로의 길이
        StringTokenizer strtk1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < road.length; i++) {
            road[i] = Integer.parseInt(strtk1.nextToken());
            lengthLeft += road[i];
        }

        int minCost = 0;
        StringTokenizer strtk2 = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < cost.length; j++) {
            cost[j] = Integer.parseInt(strtk2.nextToken());
            if(j == 0) {
                minCost = cost[j];
            } else if(cost[j] < minCost && j != (cost.length-1)) {
                minCost = cost[j];
            }
        }

        long result = 0;
        for (int k = 0; k < N-1; k++) {
            if(cost[k] != minCost) {
                result += road[k]*cost[k];
                lengthLeft -= road[k];
            } else if(cost[k] == minCost) {
                result += cost[k]*lengthLeft;
                break;
            }
        }
        System.out.println(result);
    }
}
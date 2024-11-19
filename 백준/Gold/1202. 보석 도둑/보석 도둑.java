import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer nAndK = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(nAndK.nextToken());
        int K = Integer.parseInt(nAndK.nextToken());

        int[][] jewelInfo = new int[N][2]; // 순서대로 무게와 가격을 정보로 가진다.
        int[] bagSize = new int[K];

        for (int i = 0; i < N; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            jewelInfo[i][0] = Integer.parseInt(strtk.nextToken());
            jewelInfo[i][1] = Integer.parseInt(strtk.nextToken());
        }
        Arrays.sort(jewelInfo, ((o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        }));

        for (int j = 0; j < K; j++) {
            bagSize[j] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagSize);

        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 보석을 순회하기 시작하는 지점을 계속해서 저장함 -> 모든 모석을 딱 한번씩만 순회
        // 같은 보석을 여러 번 pq에 넣는 상황을 막을 수 있음.
        int startPoint = 0;
        for (int i = 0; i < K; i++) { // 가방 순서
            while(startPoint < N) { // 보석 순회
                if(jewelInfo[startPoint][0] <= bagSize[i]) {
                    // 우선순위 큐에 값을 추가할 때마다 다음 시작 인덱스를 1 증가
                    pq.add(jewelInfo[startPoint++][1]);
                } else {
                    // 보석이 i번째 가방의 적재가능 무게보다 더 무겁다면 반복문 종료
                    break;
                }
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.print(result);
    }
}
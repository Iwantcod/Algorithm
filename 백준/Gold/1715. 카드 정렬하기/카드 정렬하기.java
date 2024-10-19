import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long result = 0;
        int N = Integer.parseInt(br.readLine());
        // heap: 완전 이진 트리 구조를 가진다. 우선순위 큐를 구현할 수 있다.
        // 우선순위 큐: 우선순위가 가장 높은 값(최대값 or 최소값)을 빠르게 찾아낼 수 있도록 만들어진 자료구조
        // min heap 자료구조 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        // 가장 작은 값 두 개를 우선순위 큐에서 뺀다.
        // 그 두 값을 더한 값을 결과값에 더한다.
        // 그 값을 우선순위 큐에 다시 삽입한다.
        // 이 과정을 큐의 길이가 1이 될 때까지 반복한다. (길이가 1이 되면 결과 계산이 완료된 것이다.)
        for (int j = 0; j < N; j++) {
            if(pq.size() != 1) {
                int tmp = pq.poll() + pq.poll();
                result += tmp;
                pq.add(tmp);
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
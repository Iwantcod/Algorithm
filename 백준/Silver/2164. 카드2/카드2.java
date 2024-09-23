import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queueInt = new LinkedList<>();

        // queue 초기값 설정
        for (int i = 1; i <= N; i++) {
            queueInt.add(i);
        }

        for (int i = 0; i < N-1; i++) {
            queueInt.poll();

            // Queue 사이즈가 1이면 맨 위 카드를 아래로 옮기는 작업을 수행하지 않는다.(수행불가)
            if(queueInt.size() > 1) {
                int tmp = queueInt.poll();
                queueInt.add(tmp);
            }
        }
        bw.write(String.valueOf(queueInt.poll()));
        bw.close();
    }
}
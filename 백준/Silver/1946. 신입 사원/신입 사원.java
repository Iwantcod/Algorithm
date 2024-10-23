import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> mapInt = new HashMap<>();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int result = N;
            // 값 입력
            for (int j = 0; j < N; j++) {
                StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
                mapInt.put(Integer.parseInt(strtk.nextToken()), Integer.parseInt(strtk.nextToken()));
            }


            // 탈락자 수 계산
            // 첫번째 심사의 1순위부터 꼴찌까지의 순서대로 두번째 심사의 순위를 읽는다. 이때 읽은 값을 tmp라고 하자.
            // 첫번째 심사의 순위가 1인 사람의 tmp값이 데드라인이 된다.
            // 그 다음 사람의 tmp값을 읽었을 때, 데드라인보다 값이 높다면 탈락자가 된다. 값이 더 적은 경우 데드라인이 갱신된다.
            // 사람이 7명인 경우, (5순위 1순위)가 존재하면, 첫 심사의 6~7순위의 사람은 반드시 탈락하게 된다.
            int deadLine = mapInt.get(1);
            for (int k = 2; k <= N; k++) {
                if(mapInt.get(k) > deadLine) {
                    result--;
                } else if (mapInt.get(k) < deadLine) {
                    deadLine = mapInt.get(k);
                }
            }
            mapInt.clear();
            bw.write(String.valueOf(result)+"\n");
        }
        bw.close();
    }
}
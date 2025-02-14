import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int M = Integer.parseInt(br.readLine()); // 연산 수행 횟수
        int S = 0;

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("all")) {
                S = (1 << 21) - 1; // 1 ~ 20까지의 비트 자릿수가 모두 1이된다.
            } else if(order.equals("empty")) {
                S = 0;
            } else {
                int x = Integer.parseInt(st.nextToken());
                if(order.equals("add")) {
                    S |= (1 << x);
                } else if(order.equals("remove")) {
                    S &= ~(1 << x);
                } else if(order.equals("check")) {
                    bw.write(String.valueOf((S & (1 << x)) != 0 ? 1 : 0)+"\n");
                } else if(order.equals("toggle")) {
                    S ^= (1 << x);
                }
            }
        }
        bw.close();
    }
}
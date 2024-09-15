import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stackInt = new Stack<>();

        int tmp = -1;
        for (int i = 0; i < K; i++) {
            tmp = Integer.parseInt(br.readLine());
            if(tmp == 0) {
                stackInt.pop();
            } else {
                stackInt.push(tmp);
            }

        }

        int result = 0;
        while(!stackInt.isEmpty()) {    // stack이 empty가 될때까지 반복
            result += stackInt.pop();   // 스택의 값을 pop한 반환값을 변수에 더해간다.
        }
        
        bw.write(String.valueOf(result));
        bw.close();
    }
}
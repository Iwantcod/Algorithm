import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int duplI = 0;
        int sum = 0;
        int result = 0;

        for (int i = 1; i < input; i++) {
            duplI = i;
            sum = i;        // 초기값을 i로 잡음.
            int numLength = String.valueOf(i).length();
            for (int j = 0; j < numLength; j++) {       // 각 자릿수에 해당하는 숫자를 모두 더해줌.
                int minusNum = (int)Math.pow(10, numLength - 1 - j);
                sum += duplI / minusNum;
                duplI -= (duplI / minusNum) * minusNum;
            }
            if(sum == input) {
                result = i;
                break;
            }
        }
        System.out.print(result);
    }
}
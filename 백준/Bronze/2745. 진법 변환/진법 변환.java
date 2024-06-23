import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        String Nx = "";
        int B = 0;
        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        Nx = strtk.nextToken();     // 자릿수 계산을 위해서 일단은 문자열로 입력받음
        B = Integer.parseInt(strtk.nextToken());
        int[] N = new int[Nx.length()];

        for (int i = 0; i < Nx.length(); i++) {
            int testNum = (int)Nx.charAt(i);
            if(testNum >= 48 && testNum <= 57) {        // 문자열 0 ~ 9의 아스키코드는 48 ~ 57이므로 이에 맞게 변환
                N[i] = testNum - 48;
            } else if (testNum >= 65 && testNum <= 90) {    // 이 또한 경우에 맞게 변환
                N[i] = testNum - 55;
            }
            result += Math.pow(B, Nx.length() - 1 - i) * N[i];      // 변환 후, 해당 자리에 대응되는 자릿값*입력값을 결과값에 계속 더해감
        }
        System.out.print(result);
    }
}
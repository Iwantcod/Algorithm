import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = "";
        int sum = 0;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == -1)     // -1이 입력되면 반복문 탈출
                break;
            for (int i = 1; i <= n; i++) {
                if(n % i == 0 && n != i) {
                    result += String.valueOf(i)+" + ";
                    sum += i;
                }
            }
            result = result.substring(0, result.length()-3);    // .substring 메서드를 이용하여 마지막에 붙는 " + "를 제거한다.

            if(n - sum == 0) {  // n이 완전수인 경우 "n = x + y + ..." 형태로 출력
                bw.write(String.valueOf(n)+" = "+result+"\n");
            } else {            // 완전수가 아닌 경우, 다음과 같이 출력
                bw.write(String.valueOf(n)+" is NOT perfect.\n");
            }
            bw.flush();
            result = "";        // 다음 숫자 검증을 위해 초기화
            sum = 0;
        }
        bw.close();
    }
}
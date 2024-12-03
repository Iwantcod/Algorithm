import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 대문자 A: 아스키코드로 65, 대문자 알파벳에서 65를 뺀 값이 해당 알파벳을 의미하는 인덱스(행 번호)이다.
        String[] input = new String[N];
        int[] alpha = new int[26]; // 각 인덱스는 A~Z 하나씩을 의미한다.
        // 입력받은 자릿수에 대응하는 수(4번째 자리면 1000, 2번째 자리면 10)를 각 인덱스에 더하여 기록

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            int tmp = (int)Math.pow(10, input[i].length()-1);
            for (int j = 0; j < input[i].length(); j++) {
                // 입력받은 각 알파벳이 자신에 자릿수에 대응하는 10의 제곱수를 alpha의 자신에 해당하는 인덱스에 더한다.
                alpha[(int)input[i].charAt(j)-65] += tmp;
                // 그 다음 자리의 알파벳은 한 자릿수가 작아지므로 tmp를 나누기 10 해준다.
                tmp /= 10;
            }
        }

        Arrays.sort(alpha);
        int num = 9;
        int result = 0;

        // alpha[]를 역순으로 조회 (오름차순으로 정렬되었기 때문)
        for (int i = 25; i >= 0; i--) {
            if(alpha[i] == 0) {
                break;
            }
            result += alpha[i] * num;
            num--;
        }
        System.out.println(result);
    }
}
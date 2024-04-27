import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1~1000 사이의 소수 판별
        boolean[] isNotPow = new boolean[1000];     // n이 가질수 있는 최대의 자연수가 1000이므로, 1~1000 중 소수를 걸러내기 위한 배열 선언
        isNotPow[0] = true; // 1은 소수가 아니고, 이를 연산에 적용하려면 번거로우므로 미리 true로 설정

        for(int j = 2; j < Math.sqrt(1000); j++) {
            for(int z = 2; z * j <= 1000; z++) {
                isNotPow[z*j - 1] = true;   // 2의 배수부터 시작하여, j의 배수에 해당하는 수에 대응되는 인덱스의 값을 true로 변경
            }
        }


        String a = " ";
        int n = 0;
        while(n>100 || n<1) {
            a = br.readLine();
            n = Integer.parseInt(a);        // 입력할 숫자의 개수(n)
        }


        int x;
        int cnt = 0;
        int isNotNum = 1;

        while(isNotNum != 0) {      // 범위 내의 올바른 숫자를 입력했는지의 여부를 알려주는 변수가 0이어야 끝남.
            isNotNum = 0;
            cnt = 0;
            String[] b = br.readLine().split(" "); // 공백을 기준으로 각 인덱스에 입력받은 값들을 저장
            for (int g = 0; g < n; g++) {
                x = Integer.parseInt(b[g]);
                if (x > 1000 || x < 1) {
                    isNotNum = 1;       // 입력한 숫자 중 하나라도 범위를 벗어나면 오류발생. 다시 입력받음.
                }
                if(isNotNum == 0 && isNotPow[x-1] == false) {
                    cnt++;
                }
            }

        }
        br.close();

        String c = String.valueOf(cnt);
        bw.write(c);
        bw.close();
    }
}

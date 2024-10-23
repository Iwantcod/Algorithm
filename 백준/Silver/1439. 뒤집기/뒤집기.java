import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        // 각각 0의 집합의 개수, 1의 집합의 개수
        int cnt_0 = 0;
        int cnt_1 = 0;

        for (int i = 1; i < s.length(); i++) {
            // 현재 인덱스의 문자와 이전 인덱스의 문자가 다를 때: 수가 바뀌었다는 것 -> 집합 수 카운트
            if(s.charAt(i) != s.charAt(i-1)) {
                if(s.charAt(i) == '0') {
                    cnt_0++;
                } else if (s.charAt(i) == '1') {
                    cnt_1++;
                }
            }
        }

        // 위 방식으로는 첫 번째 문자를 검증할 수 없으니, 추가적으로 검증
        if(cnt_0 + cnt_1 != 0 && s.length() > 1) {
            if(s.charAt(0) == '0'){
                cnt_0++;
            } else if(s.charAt(0) == '1') {
                cnt_1++;
            }
        }
        bw.write(String.valueOf(Math.min(cnt_0, cnt_1)));
        bw.close();
    }
}
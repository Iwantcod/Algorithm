import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0;
        do {
            n = Integer.parseInt(br.readLine());
        } while (n > 100 || n < 1);

        String[] ary = new String[n];
        for (int i = 0; i < n; i++) {
            ary[i] = br.readLine();
        }
        br.close();

        int result = n;
        boolean isOver_1 = false;

        for (int i = 0; i < n; i++) {       // i번째 단어를 검사
            boolean isGroupWord = true;     // i번째 단어가 그룹단어인지에 대한 정보
            for (int j = 0; j < ary[i].length(); j++) {
                char a = ary[i].charAt(j);          // 현재 단어의 j번째 문자를 저장
                for (int k = j; k < ary[i].length(); k++) { // j번째 문자가 서로 떨어져서 존재하는지 여부 검증
                    int diff = k - j;
                    if(k>1) {       // k가 1 이상일 경우 k-1번째 문자를 조회
                        isOver_1 = ary[i].charAt(k-1) != a;
                    }
                    if(diff > 1 && ary[i].charAt(k) == a && isOver_1) {
                        isGroupWord = false;
                    }
                }
            }
            if(!isGroupWord) {
                result--;
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
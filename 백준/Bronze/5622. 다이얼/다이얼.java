import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String call = br.readLine();
        br.close();
        char[][] ary = new char[8][4];

        int cnt = 0;
        int ascii = 65;

        for(int i = 0; i<8; i++) {      // 배열 초기값 설정
            if(i == 5 || i == 7) {
                cnt = 4;
            } else {
                cnt = 3;
            }
            for(int j = 0; j < cnt; j++) {
                ary[i][j] = (char)ascii;
                ascii++;
            }
        }

        int result = 0;     // 결과 저장 변수
        for(int z = 0; z<call.length(); z++) {      // 입력문자열의 길이만큼 반복
            for (int i = 0; i < 8; i++) {           // 2차원배열을 순회하며 이번순서의 문자와 일치하는게 있는지 확인
                for (int j = 0; j < 4; j++) {       // 일치한다면 해당 행번호+3을 저장
                    if(ary[i][j] == call.charAt(z)) {
                        result += i+3;
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
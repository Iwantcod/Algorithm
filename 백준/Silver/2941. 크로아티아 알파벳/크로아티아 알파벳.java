import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        do {
            str = br.readLine();
        } while (str.length() > 100);
        int result = str.length();

        if(str.length() > 1) {      // 한글자만 입력된 경우 검증할게 없음.
            for (int i = 1; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case '-' :
                        switch (str.charAt(i-1)) {
                            case 'c':
                                result--;
                                break;
                            case 'd':
                                result--;
                                break;
                        }
                        break;

                    case '=':
                        switch (str.charAt(i-1)) {
                            case 'c':         // or 연산 적용가능
                                result--;
                                break;
                            case 's':
                                result--;
                                break;
                            case 'd':
                                result--;
                                break;

                            case 'z':       // "z="와 "dz="가 겹치는 부분이 있으므로 따로 빼주기
                                if(i >= 2) {
                                    if(str.charAt(i-2) == 'd')      // i가 2 이상인 경우에만 (i-2)번째 인덱스를 조회할 수 있도록 함
                                        result -= 2;
                                    else
                                        result--;
                                } else {
                                    result--;
                                }
                                break;
                        }
                        break;

                    case 'j':
                        if(str.charAt(i-1) == 'l' || str.charAt(i-1) == 'n') {
                            result--;
                        }
                        break;

                    default:
                        break;
                }
            }
        }
        System.out.print(result);
    }
}
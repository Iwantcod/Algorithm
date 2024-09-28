import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String fomula = br.readLine();
        int startPoint = 0, tmpNum = 0, result = 0;
        boolean isStartMinus = false;

        for (int i = 0; i < fomula.length(); i++) {
            if(fomula.charAt(i) == '+') {
                // 빼기 연산자가 나타날 때 tmpNum을 결과값에 반영한다.
                // 아래는 연산자가 나타날 때마다 정수를 구하는 반복문
                for (int j = startPoint; j < i; j++) {
                    tmpNum += (fomula.charAt(j) - '0') * (int)Math.pow(10, i-j-1);
                }
                startPoint = i+1;

            } else if(fomula.charAt(i) == '-') {
                // 빼기 연산자가 등장하면 빼기 연산자 뒤에 괄호를 연다. 빼기 연산자가 다시 등장하면 괄호를 닫고, 그 값을 반영한다.
                for (int j = startPoint; j < i; j++) {
                    tmpNum += (fomula.charAt(j) - '0') * (int)Math.pow(10, i-j-1);
                }
                startPoint = i+1;

                if(isStartMinus) {
//                    System.out.println("tmp: -"+tmpNum);
                    result -= tmpNum;
                    tmpNum = 0;
                } else {
//                    System.out.println("tmp: +"+tmpNum);
                    result += tmpNum;
                    tmpNum = 0;
                    isStartMinus = true;
                }

            } else if(i == fomula.length()-1) {
                for (int j = startPoint; j <= i; j++) { // 마지막 인덱스의 문자는 숫자이기 때문에 범위를 i까지 잡는다.
                    tmpNum += (fomula.charAt(j) - '0') * (int)Math.pow(10, i-j);
                }
                if(isStartMinus) {
//                    System.out.println("tmp: -"+tmpNum);
                    result -= tmpNum;
                    tmpNum = 0;
                } else {
//                    System.out.println("tmp: +"+tmpNum);
                    result += tmpNum;
                    tmpNum = 0;
                }
            }
        }

        System.out.print(result);
    }
}
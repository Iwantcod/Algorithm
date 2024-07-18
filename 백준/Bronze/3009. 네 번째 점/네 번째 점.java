import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] aryX = new int[1001];     // 1 ~ 1000 사이의 숫자를 인덱스 번호로 기록하기 위해 길이를 1001로 설정
        int[] aryY = new int[1001];

        // 답 찾는법: 각각의 좌표에는 두 개의 숫자가 두 번씩 나와야 한다.
        // 좌표 숫자에 해당하는 인덱스의 값을 1씩 늘린다. 값이 1인 인덱스 번호가 각 축에 필요한 좌표값이다.
        for (int i = 0; i < 3; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            aryX[Integer.parseInt(strtk.nextToken())]++;
            aryY[Integer.parseInt(strtk.nextToken())]++;
        }
        int xResult = 0, yResult = 0;
        for (int j = 1; j <= 1000; j++) {
            if(aryX[j] == 1)
                xResult = j;
            if(aryY[j] == 1)
                yResult = j;
        }

        bw.write(String.valueOf(xResult)+" "+String.valueOf(yResult));
        bw.close();
    }
}
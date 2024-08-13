import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] ary = new boolean[2000001];   // 수의 범위: -1,000,000 ~ 1,000,000 --> 0 ~ 2,000,000 총 2백만 1개

        // 입력되는 수는 중복되지 않는다. 따라서 bool타입의 배열을 만들어 수에 해당하는 인덱스의 값을 true로 바꾸는 방식으로 입력값을 저장(기억)한다.
        // 그리고 마지막에 1백만 번을 반복하는 for문을 돌리면서 값이 true인 인덱스의 번호를 출력하면 된다.
        int num = 0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine())+1000000;
            ary[num] = true;
        }

        for (int j = 0; j < ary.length; j++) {
            if(ary[j]) {
                bw.write(String.valueOf(j-1000000)+"\n");
            }
        }
        bw.close();
    }
}
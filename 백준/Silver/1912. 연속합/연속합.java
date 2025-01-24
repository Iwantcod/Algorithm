import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNum = 0; // 입력받은 수가 모두 음수인 경우처럼 단일 수가 최대값이 될 가능성이 있다. 그 경우를 위한 최대값 저장 변수
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());

            if(i == 0) {
                maxNum = ary[i];
            } else if (ary[i] > maxNum) { // 배열 내 최대값
                maxNum = ary[i];
            }
        }

        boolean isNatural = true; // 부분 수열의 합이 자연수인지 나타냄. 아니라면, 아무 것도 하지않음.
        // 그러나 다음 수가 자연수인 경우, true로 바꾼 다음 다음 수에서 다른 로직을 실행
        if(ary[0] < 0) {
            isNatural = false;
        }

        for (int i = 1; i < n; i++) {
            int curr = ary[i];
            int prev = ary[i - 1];

            // 부분수열의 총합이 음수가 아닌 경우에 실행할 로직
            if(isNatural) {
                if(prev + curr < 0) { // prev는 해당 위치까지의 최대 부분수열의 값을 가지고 있다.
                    // 부분수열의 누적합이 음수가 되었을 경우, 부분수열은 거기서 끝난다.
                    ary[i] = prev;
                    isNatural = false;
                } else {
                    ary[i] = prev + curr;
                }
            } else {
                if(curr > 0) {
                    isNatural = true;
                }
            }

            if(ary[i] > maxNum) { // 이 반복문을 수행하는 도중 maxNum보다 큰 값이 나온다면, 갱신
                maxNum = ary[i];
            }

        }
        bw.write(String.valueOf(maxNum));
        bw.close();
    }
}
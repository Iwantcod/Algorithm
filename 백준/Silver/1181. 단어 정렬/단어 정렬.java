import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] ary = new String[N];

        for (int i = 0; i < N; i++) {
            ary[i] = br.readLine();
        }

        Arrays.sort(ary, (o1, o2) -> {
            if(o1.length() == o2.length()) {
                // 문자열 사전순 비교 메서드. o1이 작으면 음수 반환, 크면 양수 반환.
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        });

        for (int i = 0; i < N; i++) {
            if(i>0) {
                if(!ary[i-1].equals(ary[i])) { // 중복되지 않은 경우 출력
                    bw.write(String.valueOf(ary[i])+"\n");
                }
            } else {
                bw.write(String.valueOf(ary[i])+"\n");
            }
        }
        bw.close();
    }
}
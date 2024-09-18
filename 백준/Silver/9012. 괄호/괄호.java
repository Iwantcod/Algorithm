import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int cnt = 0;
            String str = br.readLine();
            // 문자 하나씩 읽어나간다. '('가 나오면 +1, ')'가 나오면 -1을 하여 결과적으로 cnt값이 0이면 올바른 괄호 문자열.
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    cnt++;
                } else if(str.charAt(j) == ')') {
                    cnt--;
                }
                
                if(cnt < 0) {       // 닫힌괄호가 열린괄호보다 더 많이 나온 이상, 올바른 괄호 문자열이 될 수 없다.
                    cnt -= 100;
                }
            }
            if(cnt == 0) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.close();
    }
}
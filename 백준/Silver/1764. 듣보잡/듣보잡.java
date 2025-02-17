import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] ary = new String[m];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            ary[i] = br.readLine();
        }
        // 두번째로 입력받는 m개의 단어들만 정렬하고, 그렇게 정렬된 단어들을 순서대로 HashSet에 존재하는지 검사 -> 출력 결과 또한 정렬
        Arrays.sort(ary);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if(set.contains(ary[i])) {
                cnt++;
                sb.append(ary[i]).append("\n");
            }
        }
        sb.insert(0, cnt + "\n");
        bw.write(sb.toString());
        bw.close();
    }
}
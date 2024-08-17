import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        int[] ary = new int[N];
        // HashMap 사용. Integer 타입의 key와 Integer 타입의 value를 사용. 크기는 N.
        HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>(N);

        // 입력된 값들을 배열에 순서대로 담음
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(strtk.nextToken());
            ary[i] = num;
        }
        // 순서대로 담은 배열을 복제해서 따로 보관
        int[] repAry = ary.clone(); // 결과값을 입력값의 순서대로 출력하기 위해 기존의 입력순서를 배열 형태로 저장

        // 값을 저장한 배열 내의 숫자들을 오름차순으로 정렬
        Arrays.sort(ary);


        int cnt = 0; // 값이 작은 순위를 매길 때 사용되는 수. 가장 작은 수에게는 0이 부여됨.
        for (int i = 0; i < N; i++) {
            // key: 입력받은 수, value: 값이 작은 순위
            // hashmap에 해당 key값이 존재하지 않는 경우(중복되지 않는 경우) 저장 및 순위 부여
            if(!h1.containsKey(ary[i])) {
                h1.put(ary[i], cnt);
                cnt++;
            }
        }

        // 입력값 순서가 그대로 저장돼있는 복제배열을 순회하며, 배열 내의 값을 키값으로 하여 value를 출력
        for (int x : repAry) {
            bw.write(String.valueOf(h1.get(x))+" ");
        }
        bw.close();
    }
}
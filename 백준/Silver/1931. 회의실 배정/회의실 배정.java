import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0;
        n = Integer.parseInt(br.readLine());
        while (n < 1 || n > 100000) {
            n = Integer.parseInt(br.readLine());
        }
        int[][] time = new int[n][2];       // 시작시간, 종료시간을 가진 2차원 배열 선언

        for (int i = 0; i < n; i++) {
            do {
                String a = br.readLine();
                time[i][0] = Integer.parseInt(a.split(" ")[0]);       // 시작시간
                time[i][1] = Integer.parseInt(a.split(" ")[1]);       // 종료시간
            } while (time[i][0] < 0 || time[i][1] < time[i][0]);
            }
            br.close();

        Arrays.sort(time, new Comparator<int[]>() {            // 배열을 정렬하는 sort 메서드 사용. 두번째 인자로 정렬 기준의 내용을 가지는 Comparator 객체 선언
            @Override    // 인터페이스를 상속받은 경우 반드시 오버라이딩하여 사용해야 한다. -> 정렬 기준을 아래와 같이 재정의
            public int compare(int[] o1, int[] o2) {        // 회의 두 개를 비교한다.
                if (o1[1] == o2[1]) {               // 종료 시간이 서로 같으면 시작 시간을 기준으로 오름차순 정렬
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int endTime = 0;        // 직전 회의의 종료시간을 저장하기 위한 변수
        int cnt = 0;            // 회의 최대개수 카운팅 변수
        for (int k = 0; k < n; k++) {
            if (time[k][0] >= endTime) {        // 현재 회의의 시작시간이 직전 회의의 종료시간보다 같거나 크다면 카운팅
                cnt++;
                endTime = time[k][1];       // 카운팅 후 현재 회의 종료시간을 저장(다음회의와 비교를 위함)
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}

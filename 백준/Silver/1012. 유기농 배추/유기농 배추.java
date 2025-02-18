import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int M = 0;
    public static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] ary = new boolean[N][M]; // 농장 크기
            int[][] coords = new int[K][2]; // 배추의 좌표(순서대로 가로, 세로 좌표값 저장)
            int wormCnt = 0;


            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 0 ~ M: 가로좌표
                int y = Integer.parseInt(st.nextToken()); // 0 ~ N: 세로좌표
                ary[y][x] = true;
                coords[j][0] = x;
                coords[j][1] = y;
            }

            for (int j = 0; j < K; j++) {
                int x = coords[j][0];
                int y = coords[j][1];
                if(ary[y][x]) { // 해당 좌표에 배추가 심어져 있으면 인근 배추 탐색을 시작한다. (이전에 탐색된 배추의 경우 false가 되므로 중복탐색 안하게 된다)
                    search(x, y, ary);
                    wormCnt++;
                }
            }

            bw.write(String.valueOf(wormCnt)+"\n");
        }
        bw.close();
    }

    // 입력 좌표의 값 0(false)로 변경
    // 입력받은 좌표의 상하좌우 방향의 좌표값이 1인지 검사(한 칸 만큼 검사)
    // 1. 인근에 값이 1인 칸이 없으면: 이후 아무런 행동을 하지 않고 종료
    // 2. 인근에 1인 칸이 있으면: 해당 좌표를 파라메터로 함수를 재귀호출
    // 2-1. 재귀호출을 반복하다 1의 경우가 되면 재귀 탈출

    // 자신부터 시작하여 인근 배추를 모두 0으로 변경
    // 한 번의 호출로 0이된 배추들은 모두 같은 하나의 영역에 속한다.(지렁이가 이동할 수 있는 영역을 뜻함)
    public static void search(int x, int y, boolean[][] ary) {
        ary[y][x] = false;

        boolean left = false;
        boolean down = false;
        boolean right = false;
        boolean up = false;

        // 범위 밖의 인덱스 조회 방지
        if(x != 0) {
            left = ary[y][x - 1];
        }
        if(y != 0) {
            down = ary[y - 1][x];
        }
        if(x != (M-1)) {
            right = ary[y][x + 1];
        }
        if(y != (N-1)) {
            up = ary[y + 1][x];
        }

        if(left) {
            search(x - 1, y, ary);
        }
        if(right) {
            search(x + 1, y, ary);
        }
        if(down) {
            search(x, y - 1, ary);
        }
        if(up) {
            search(x, y + 1, ary);
        }
    }
}
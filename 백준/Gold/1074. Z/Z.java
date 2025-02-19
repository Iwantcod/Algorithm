import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0; // 해당 좌표까지 가는 데 이동한 칸의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n); // 직사각형 한 변의 길이

        find(size, r, c);
        bw.write(String.valueOf(cnt));
        bw.close();
    }

    public static void find(int size, int r, int c) {

        if(size == 1) {
            // 직사각형을 계속 쪼개는데, 이 직사각형의 한 변의 길이가 1이 되면 재귀 탈출
            return;
        }

        if(r < size/2 && c < size/2) { // 좌표가 1 사분면인 경우 -> 상대좌표 동일: 그대로 전달
            find(size/2, r, c);
        } else if (r < size/2 && c >= size/2) { // 좌표가 2 사분면인 경우 -> '열' 상대좌표 조정 후 전달
            cnt += ((size*size)/4);
            find(size/2, r, c-(size/2));
        } else if (r >= size/2 && c < size/2) { // 좌표가 3 사분면인 경우 -> '행' 상대좌표 조정 후 전달
            cnt += ((size*size)/4)*2;
            find(size/2, r-(size/2), c);
        } else if (r >= size/2 && c >= size/2) { // 좌표가 4 사분면인 경우 -> '행', '열' 상대좌표 조정 후 전달
            cnt += ((size*size)/4)*3;
            find(size/2, r-(size/2), c-(size/2));
        }
    }
}
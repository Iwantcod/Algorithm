import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static StringBuilder sb = new StringBuilder();
    public static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] splits = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = (splits[j].equals("1")) ? true : false;
            }
        }

        search(0, 0, n);
        String result = sb.toString();
        bw.write(result);
        bw.close();
    }
    public static void search(int startI, int startJ, int n) {
        // n: 현재 탐색할 정사각형 범위의 한 변의 길이
        
        if(n == 1) {
            // 해당 startI, startJ 인덱스의 값을 그대로 출력
            String result = (map[startI][startJ] == true) ? "1" : "0";
            sb.append(result);
            return;
        }

        int endI = startI + n;
        int endJ = startJ + n;
        boolean startStatus = map[startI][startJ]; // 동일 검사 기준 숫자(범위 내 첫번째 숫자)
        boolean isSame = true; // 현재 범위 내의 모든 숫자가 같은지 기록하는 플래그
        
        for(int i = startI; i < endI; i++) {
            for(int j = startJ; j < endJ; j++) {
                if(startStatus != map[i][j]) {
                    isSame = false;
                }
            }
        }

        if(isSame == true) {
            String result = (startStatus == true) ? "1" : "0";
            sb.append(result);
        } else {
            int nextN = n/2;
            sb.append("(");
            search(startI, startJ, nextN);
            search(startI, startJ + nextN, nextN);
            search(startI + nextN, startJ, nextN);
            search(startI + nextN, startJ + nextN, nextN);
            sb.append(")");
        }

    }
}
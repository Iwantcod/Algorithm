import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        br.close();
        int[] cont = {0, 0};        // 가상의 배열을 순회하는 포인터

        boolean isSwitch = true;    // 지그재그 순회방향이 전환될 타이밍을 알리는 변수
        int mode = 0;               // 지그재그 순회방향을 두가지(대각선 위, 대각선 아래)로 분류하고, 현재 방향을 알려주는 용도
        for (int i = 1; i < X; i++) {
            if (isSwitch) {
                if(cont[0] == 0){       // 지그재그 도중 위쪽 끝에 닿았을 경우
                    cont[1]++;
                    isSwitch = false;
                    mode = 0;
                }
                if(cont[1] == 0){       // 지그재그 도중 왼쪽 끝에 닿았을 경우
                    cont[0]++;
                    isSwitch = false;
                    mode = 1;
                }
            } else {
                switch (mode) {
                    case 0: {
                            cont[0]++;
                            cont[1]--;
                            if(cont[0] == 0 || cont[1] == 0)        // 순회도중 끝에 닿았을 경우 이를 알림
                                isSwitch = true;
                            break;
                    }
                    case 1: {
                        cont[0]--;
                        cont[1]++;
                        if(cont[0] == 0 || cont[1] == 0)            // 순회도중 끝에 닿았을 경우 이를 알림
                            isSwitch = true;
                        break;
                    }
                    default:
                        break;
                }
            }
        }
        bw.write(String.valueOf(cont[0]+1)+'/'+String.valueOf(cont[1]+1));
        bw.close();
    }
}
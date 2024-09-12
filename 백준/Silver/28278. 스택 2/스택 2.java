import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stackInt = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            switch (Integer.parseInt(strtk.nextToken())) {
                case 1:
                    stackInt.push(Integer.parseInt(strtk.nextToken()));
                    break;
                case 2:
                    try {
                        bw.write(String.valueOf(stackInt.pop())+"\n");
                    } catch (Exception e) {
                        bw.write("-1"+"\n");
                    }
                    break;
                case 3:
                    bw.write(String.valueOf(stackInt.size())+"\n");
                    break;
                case 4:
                    bw.write(String.valueOf(stackInt.isEmpty() ? 1 : 0)+"\n");
                    break;
                case 5:
                    try {
                        bw.write(String.valueOf(stackInt.peek())+"\n");
                    } catch (Exception e) {
                        bw.write("-1\n");
                    }
                    break;
            }
        }
        bw.close();
    }
}
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queueInt = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        int lastAddInt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            switch (strtk.nextToken()) {
                case "push":
                    int addInt = Integer.parseInt(strtk.nextToken());
                    lastAddInt = addInt;
                    queueInt.add(addInt);
                    break;
                case "pop":
                    if(queueInt.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(queueInt.poll())+"\n");
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(queueInt.size())+"\n");
                    break;
                case "empty":
                    if(queueInt.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if(queueInt.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(queueInt.peek())+"\n");
                    }
                    break;
                case "back":
                    if(queueInt.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(lastAddInt)+"\n");
                    }
                    break;
            }
        }
        bw.close();
    }
}
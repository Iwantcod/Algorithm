import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");

        int maxNumInStack = 0;
        int nextSeq = 1;
        int currentNum = 0;
        boolean isSafe = true;
        Stack<Integer> stackInt = new Stack<>();
        for (int i = 0; i < N; i++) {
            currentNum = Integer.parseInt(strtk.nextToken());
            //System.out.println("\n\n현재 입력받은 값: "+currentNum);

            if(currentNum == nextSeq) {
                nextSeq++;
                //System.out.println(currentNum+"을 바로 내보냄.");
            } else if(stackInt.isEmpty()) {
                //System.out.println("비어있던 스택에 들어간 값: "+currentNum);
                stackInt.push(currentNum);
                maxNumInStack = currentNum;
                //System.out.println("현재 스택 내의 가장 큰 값: "+maxNumInStack);
            } else if(stackInt.peek() == nextSeq) {
                while(!stackInt.isEmpty()) {
                    if(stackInt.peek() == nextSeq){
                        //System.out.println(stackInt.pop()+"이 스택에 있다가 내보내짐.");
                        stackInt.pop();
                        nextSeq++;
                    } else {
                        break;
                    }
                }
                if(stackInt.isEmpty()) {
                    maxNumInStack = currentNum;
                }
                if (currentNum > maxNumInStack) {
                    //System.out.println("Break!!!!!!");
                    //System.out.println("스택에 넣으려는 "+currentNum+"이 "+maxNumInStack+"보다 크다.");
                    isSafe = false;
                    break;
                } else {
                    //System.out.println("Stack에 값이 들어감: "+currentNum);
                    stackInt.push(currentNum);
                }
            } else if (currentNum > maxNumInStack) {
                //System.out.println("Break!!!!!!");
                //System.out.println("스택에 넣으려는 "+currentNum+"이 "+maxNumInStack+"보다 크다.");
                isSafe = false;
                break;
            } else {
                //System.out.println("Stack에 값이 들어감: "+currentNum);
                stackInt.push(currentNum);
            }
        }
        if(isSafe) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
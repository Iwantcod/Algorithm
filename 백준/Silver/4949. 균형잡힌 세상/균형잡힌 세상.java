import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";

        while(!str.equals(".")) {
            str = br.readLine();
            boolean isGood = true;
            if(!str.equals(".")) {
                // 반복문으로 문자열을 순회하며 열린 괄호들을 Stack에 저장한다.
                // 닫힐 괄호를 찾았을 때, Stack.pop()을 통해 가장 최근에 들어간 열린괄호와 서로 같은 종류인지 확인한다.
                // 이때, 서로 같은 종류가 아니거나 스택이 비어있는 상태라면 균형을 이루는 문자열이 될 수 없다.
                Stack<Character> stackChar = new Stack<>();

                for (int i = 0; i < str.length(); i++) {
                    switch (str.charAt(i)) {
                        case '(':
                            stackChar.push('(');
                            break;
                        case '[':
                            stackChar.push('[');
                            break;
                        case ')':
                            if(stackChar.isEmpty()) {
                                isGood = false;
                            } else if(stackChar.pop() != '(') {
                                isGood = false;
                            }
                            break;
                        case ']':
                            if(stackChar.isEmpty()) {
                                isGood = false;
                            } else if(stackChar.pop() != '[') {
                                isGood = false;
                            }
                            break;
                        case '.':
                            if(!stackChar.isEmpty()) {
                                isGood = false;
                            }
                            break;
                    }
                }
                if(isGood) {
                    bw.write("yes\n");
                } else {
                    bw.write("no\n");
                }
            }
        }
        bw.close();
    }
}
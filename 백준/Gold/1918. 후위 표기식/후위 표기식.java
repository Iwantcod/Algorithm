import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> s = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if(cur == '/' || cur == '*' || cur == '+' || cur == '-') {
                while(!s.isEmpty() && priority(s.peek()) >= priority(cur)) {
                    sb.append(s.pop());
                }
                s.add(cur);
            } else if(cur == '(') {
                s.add(cur);
            } else if(cur == ')') {
                while(!s.isEmpty() && s.peek() != '(') {
                    sb.append(s.pop());
                }
                s.pop();
            } else {
                sb.append(cur);
            }
        }
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        bw.write(sb.toString());
        bw.close();
        
        
    }
    public static int priority(char c) {
        if(c == '*' || c == '/') {
            return 2;
        } else if(c == '+' || c == '-') {
            return 1;
        } else if(c == '(' || c == ')') {
            return 0;
        } else {
            return -1;
        }
    }
}
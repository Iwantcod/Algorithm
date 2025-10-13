import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String boom = br.readLine();
        Stack<Character> s = new Stack<>();
        // 스택에 str를 한문자씩 삽입
        // 스택 크기가 boom의 길이 이상인 경우인 동시에 방금 추가된 문자가 boom의 마지막 문자와 동일한 경우 검사 로직 수행
        // 스택의 (스택 크기 - 폭발문자열 길이 + 인덱스) 에 위치한 문자와 인덱스 순서의 폭발물 문자가 모두 동일한 경우 스택에서 제거 로직 수행
        // 제거 로직: 폭발물 문자열 길이만큼 스택에서 pop

        for(int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            s.push(cur);
            if(s.size() >= boom.length() && cur == boom.charAt(boom.length() - 1)) {
                boolean isDelete = true;
                for(int j = 0; j < boom.length(); j++) {
                    if(s.get(s.size() - boom.length() + j) != boom.charAt(j)) {
                        isDelete = false;
                        break;
                    }
                }
                if(isDelete) {
                    for(int k = 0; k < boom.length(); k++) {
                        s.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : s) {
            sb.append(c);
        }
        String result = sb.toString();
        bw.write((result.length() == 0) ? "FRULA" : result);
        bw.close();
    }
}
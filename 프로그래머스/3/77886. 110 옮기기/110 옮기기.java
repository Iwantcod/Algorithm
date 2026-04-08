// 10:34

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++) {
            if(s[i].length() <= 3) {
                answer[i] = s[i];
                continue;
            }
            
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(s[i].substring(0, 2));
            for(int j = 2; j < s[i].length(); j++) {
                char c = s[i].charAt(j);
                if(c == '0'
                  && sb.length() >= 2
                  && sb.charAt(sb.length() - 1) == '1'
                  && sb.charAt(sb.length() - 2) == '1') {
                    sb.setLength(sb.length() - 2);
                    cnt++;
                    // System.out.println("문자열 추출 후: "+sb.toString());
                } else {
                    sb.append(c);
                    // System.out.println("문자 추가: "+sb.toString());
                }
            }
            
            int indx = -1;
            for(int k = sb.length() - 1; k >= 0; k--) {
                if(sb.charAt(k) == '0') {
                    indx = k;
                    break;
                }
            }
            String cur = sb.toString();
            sb.setLength(0);
            String result = cur.substring(0, indx+1) + sb.append("110".repeat(cnt)).toString() + cur.substring(indx+1);
            answer[i] = result;
        }
        
        return answer;
    }
}
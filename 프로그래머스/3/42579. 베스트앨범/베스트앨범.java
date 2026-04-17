// 09:57
import java.util.*;

class Solution {
    class Node {
        int num;
        int count;
        Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 재생 횟수 카운팅
        // 노래별 재생 횟수 top 2 갱신하며 저장
        // 장르별 재생 횟수 정렬 후 각 장르별 top 2 노래 선정
        
        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, PriorityQueue<Node>> genreCountMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String curGenre = genres[i];
            int curPlay = plays[i];
            if(!genreTotalMap.containsKey(curGenre)) {
                genreTotalMap.put(curGenre, curPlay);
                genreCountMap.put(curGenre, new PriorityQueue<>((n1, n2) -> {
                    if(n1.count == n2.count) {
                        return n1.num - n2.num;
                    }
                    return n2.count - n1.count;
                }));
                genreCountMap.get(curGenre).add(new Node(i, curPlay));
            } else {
                genreTotalMap.replace(curGenre, genreTotalMap.get(curGenre) + curPlay);
                genreCountMap.get(curGenre).add(new Node(i, curPlay));
            }
        }
        
        List<String> sortGenres = new ArrayList<>(genreTotalMap.keySet());
        Collections.sort(sortGenres, (g1, g2) -> genreTotalMap.get(g2) - genreTotalMap.get(g1));
        
        List<Integer> result = new ArrayList<>();
        for(String genre : sortGenres) {
            PriorityQueue<Node> pq = genreCountMap.get(genre);
            Node n1 = pq.poll();
            // System.out.println(n1.num+" "+n1.count);
            result.add(n1.num);
            if(!pq.isEmpty()) {
                Node n2 = pq.poll();
                // System.out.println(n2.num+" "+n2.count);
                result.add(n2.num);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
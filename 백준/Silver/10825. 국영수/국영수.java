import java.util.*;
import java.io.*;

class Node {
    String name;
    int ko, en, ma;
    public Node(String name, int ko, int en, int ma) {
        this.name = name;
        this.ko = ko;
        this.en = en;
        this.ma = ma;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>();
        ArrayList<Node> arr = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr.add(new Node(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3])));
        }
        Collections.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.ko == o2.ko) { // 국어 점수 비교
                    if(o1.en == o2.en) {
                        if(o1.ma == o2.ma) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.ma - o1.ma;
                    }
                    return o1.en - o2.en;
                }
                return o2.ko - o1.ko;
            }
        });

        for(Node cur : arr) {
            bw.write(cur.name + "\n");
        }
        bw.close();
    }
}
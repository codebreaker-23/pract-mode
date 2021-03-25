package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class MapSum {

    /** Initialize your data structure here. */
    Node r;
    public MapSum() {
        r = new Node();
    }

    public static void main(String[] args) {

        long t = System.currentTimeMillis();
        MapSum m = new MapSum();
        m.insert("apple" ,100);
        m.insert("app" ,10);
        m.insert("amdoc" ,1);
        m.insert("all" ,2);

        System.out.println(m.sum("ap"));
        System.out.println(m.sum("az"));
        System.out.println(m.sum("a"));

        System.out.println("time : " + (System.currentTimeMillis()-t));
    }

    public void insert(String key, int val) {
        int n = key.length();

        Node p = r;
        for(int i=0;i<n;i++){
            int x = (key.charAt(i) - 'a');
            if(p.children[x] == null) {
                p.children[x] = new Node();
            }
            p = p.children[x];

            if(i==n-1){
                p.isLast = true;
                p.val = val;
            }
        }
    }

    public int sum(String prefix) {
        int n = prefix.length();
        Node p = r;

        int s=0;
        for (int i = 0; i<n; i++) {
            int x = (prefix.charAt(i) - 'a');
            p = p.children[x];
            if(p==null)
                return s;
        }
//        s+=dfs(p);
//        return s;

        return bfs(p);
    }

    int bfs(Node r){
        Queue<Node> q = new LinkedList<>();
        q.add(r);

        int s=0;
        while(!q.isEmpty()){
            Node p = q.poll();
            if(p.isLast)
                s+=p.val;
            for(Node d : p.children){
                if(d!=null)
                    q.add(d);
            }
        }
        return s;
    }

    int dfs(Node r){
        if(r==null)
            return 0;
        int s=0;
        for(Node p: r.children){
            if(p!=null)
                s+=dfs(p);
        }
        s += r.isLast?r.val:0;
        return s;
    }

    class Node {
        public Node[] children;
        public boolean isLast;
        public int val;

        public Node() {
            children = new Node[26];
            isLast = false;
        }
    }

}
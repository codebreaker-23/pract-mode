package Ib;

import java.util.*;

public class Huffman {

    static Map<Integer, List<Node>> levelMap = new HashMap<>();

    static class Node {
        public char data;
        public Node left, right;
        public ArrayList<Character> lt;
        public ArrayList<Character> rt;

        public Node(){}

        public Node(Character data){
            this.data = data;
            this.left=null;
            this.right=null;
        }

    }

    public static void main(String[] args) {

        Node r = new Node('1');
        r.right = new Node('3');
        r.left = new Node('2');
        r.left.left = new Node('4');
        r.left.right = new Node('5');
        r.left.right.left = new Node('6');

        preProcess(r,1);
        Node org = r;

        int t=0;
        int [] q = {3};
        do {
            if(levelMap.containsKey(q[t]-1)){
                for(Node d : levelMap.get(q[t]-1)){
                    ArrayList<Character> tmp = d.lt;
                    d.lt = d.rt;
                    d.rt = tmp;
                }
            }
        }while(++t < q.length);

        for(char c : inOrderNew(r)){
            System.out.print(c);
        }
        System.out.println(" ");

    }

    static ArrayList<Character> preProcess(Node r, int h){
        if(r==null)
            return null;

        r.lt = preProcess(r.left, h+1);
        if(r.lt==null)
            r.lt=new ArrayList<>();
        r.rt = preProcess(r.right, h+1);
        if(r.rt==null)
            r.rt=new ArrayList<>();

        putInMap(h, r);

        ArrayList<Character> ans=new ArrayList<>();
        ans.addAll(r.lt);
        ans.add(r.data);
        ans.addAll(r.rt);
        return ans;
    }

    static void putInMap(int h, Node r){
        List<Node> t;
        if(levelMap.containsKey(h))
            t=levelMap.get(h);
        else
            t = new ArrayList<>();
        t.add(r);
        levelMap.put(h, t);
    }

    static ArrayList<Character> inOrderNew(Node r){
        if(r==null)
            return new ArrayList<>();

        r.lt = inOrderNew(r.left);
        r.lt.add(r.data);
        r.lt.addAll(inOrderNew(r.right));

        return r.lt;
    }

    static ArrayList<Character> inOrder(Node r){
        Stack<Node> t = new Stack<>();
        t.push(r);

        ArrayList<Character> ans = new ArrayList<>();
        boolean f=true;

        while(!t.isEmpty()){
            Node tmp = t.peek();
            while(tmp.left!=null && f){
                t.push(tmp.left);
                tmp=tmp.left;
            }

            ans.add(tmp.data);
            t.pop();
            if(tmp.right!=null) {
                t.push(tmp.right);
                f=true;
            }else
                f=false;
        }
        return ans;
    }

    static void decode(String s, Node r){
        ArrayList<Character> ans = new ArrayList<>();

        char [] arr = s.toCharArray();

        Node tmp = r;
        for(int i=0;i<arr.length;) {
            if(arr[i]=='1'){
                if(tmp.right!=null){
                    tmp = tmp.right;
                    i++;
                } else {
                    ans.add(tmp.data);
                    tmp=r;
                }
            }else if(arr[i]=='0') {
                if (tmp.left != null) {
                    tmp = tmp.left;
                    i++;
                } else {
                    ans.add(tmp.data);
                    tmp=r;
                }
            }
        }

        if(tmp!=null){
            ans.add(tmp.data);
        }

        for(char c : ans)
            System.out.println(c);
    }
}

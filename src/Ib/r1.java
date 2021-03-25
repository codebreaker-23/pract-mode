package Ib;

import java.util.*;

public class r1 {

    private static int solve(String a){
        int [] charArr = new int[26];

        int count1 = 0;
        boolean odd = a.length()%2 == 0? false:true;
        for(char c : a.toCharArray()){
            int i = c - 'a';
            charArr[i]+=1;
        }

        for(int i : charArr){
            if(i==1)    count1++;
            else if(i%2!=0)    return 0;
        }

        return odd ? count1==1 ? 1:0 : count1==0 ? 1: 0;
    }

    private static void solve2(){
        Map<String, String> map = new HashMap<>();
        for(Map.Entry<String, String> e : map.entrySet()){

        }
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i<A.size();++i){
            manageDQ(dq, i, A, B);
            if(i>=B-1) {
                while(!dq.isEmpty() && dq.peekFirst() < i-B+1)
                    dq.removeFirst();
                if(dq.isEmpty())
                    dq.add(i);

                res.add(A.get(dq.peek()));
            }
        }
        return res;
    }

    public ArrayList<Integer> solve3(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Map<Integer,Integer> mp = new TreeMap<>();

        for(int i: A){
            if(mp.containsKey(i))
                continue;
            mp.put(i,1);
        }

        for(int i: B){
            if(mp.containsKey(i) && mp.get(i)>=2)
                continue;
            mp.put(i,2);
        }

        for(int i: C){
            if(mp.containsKey(i) && mp.get(i)>=3)
                continue;
            mp.put(i,3);
        }

        ArrayList<Integer> l = new ArrayList<>();
        for(int e: mp.keySet()){
            if(mp.get(e)>=2)
                l.add(e);
        }
        return l;
    }


    private static void manageDQ(Deque<Integer> dq, Integer i, final List<Integer> A, int B){
        if (dq.isEmpty())
            dq.add(i);
        else {
            if (A.get(i) >= A.get(dq.peek())) {
                dq.addFirst(i);
            } else {
                while (dq.size() > 1 && (dq.peekLast() < i - B + 1 || A.get(dq.peekLast()) <= A.get(i)))
                    dq.removeLast();
                dq.addLast(i);
            }
        }
    }

    public static ArrayList<Integer> solve4(ArrayList<Integer> A) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<A.size();++i){
            if(!mp.containsKey(A.get(i))){
                mp.put(A.get(i), i);
                continue;
            }
            int prev = mp.get(A.get(i));
            mp.remove(A.get(i));
            int nEle = A.get(i)+1;
            A.set(prev,nEle);

            int x = mp.containsKey(nEle) ? Math.min(mp.get(nEle),prev) : i;
            mp.put(nEle, x);
            if(!mp.containsKey(A.get(i)))
                mp.put(A.get(i),i);
        }
        return A;
    }

//    public static void main(String[] args) {
//        int a[] = {94,20,19,53,73,1};
//        for(double i : runningMedian(a))
//            System.out.println(i);
//    }

    static int cookies(int k, int[] A) {
        long sum = 0L;
         for(int i : A){
             sum += i;
         }
         if(sum < k)
            return -1;

         PriorityQueue<Long> pq = new PriorityQueue<>();
         for(int i : A){
             pq.add((long) i);
         }

         int op = 0;
         while(pq.size() > 1 && pq.peek() < k){
             long a = pq.poll();
             long b = pq.poll();

             pq.add(a + 2*b);
             op++;
         }

         if(pq.peek() >= k)
             return op;
         return -1;
    }

    static double[] runningMedian(int[] a) {
        int l = a.length;
        double[] res = new double[l];

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < l; ++i) {
            double m;

            if (left.isEmpty() || (!left.isEmpty() && left.peek() > a[i])) {
                //insert left.
                left.add(a[i]);
                if(left.size() - right.size() > 1){
                    int top = left.poll();
                    right.add(top);
                }
            } else {
                //insert right.
                right.add(a[i]);
                if(Math.abs(left.size() - right.size()) > 1){
                    int top = right.poll();
                    left.add(top);
                }
            }
            //update m.
            if((i+1)%2 == 0)
                m = (double) (left.peek() + right.peek()) / 2;
            else
                m = left.size() > right.size() ? left.peek() : right.peek();

            res[i] = m;
        }

        return res;
    }

    class ListNode implements Comparable<ListNode> {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public int compareTo(ListNode o) {
            return this.val - o.val;
        }

        public ListNode mergeKLists(ArrayList<ListNode> a) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>();
            for (ListNode l : a) {
                pq.add(l);
            }

            ListNode res = null;
            while (!pq.isEmpty()) {
                ListNode t = pq.poll();
                if (t.next != null) {
                    pq.add(t.next);
                }

                if (res == null)
                    res = t;
                else {
                    res.next = t;
                    res = res.next;
                }
            }
            return res;
        }


        class comp implements Comparator<ListNode> {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val > o2.val ? -1 : 1;
            }
        }
    }

    public static void main(String[] args) {
        element [] ar = {
        new element(1,1,11),
        new element(1,2,12),
        new element(1,3,13),
        new element(1,4,14),
        new element(0,1,11),
        new element(0,3,11),
        new element(1,1,11),
        new element(0,2,11)
        };

        LRU(3, new ArrayList<>(Arrays.asList(ar)));
    }

    static class element{
        int op;
        int e;
        int v;

        public element(int a, int b, int c){
            this.op = a;
            this.e = b;
            this.v = c;
        }
    }

    static void LRU(int cap, ArrayList<element> f){
        LinkedList<Integer> ll = new LinkedList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        ArrayList<Integer> res = new ArrayList<>();
        for(element e : f){
            if(e.op == 0){//get
                if(!mp.containsKey(e.e)) {
                    res.add(-1);
                    continue;
                }
                ll.removeFirstOccurrence(e.e);
                res.add(mp.get(e.e));
            }else if(e.op == 1){//set
                if(ll.size() == cap){
                    int i = ll.pollLast();
                    mp.remove(i);
                }

                if(mp.containsKey(e.e))
                    ll.removeFirstOccurrence(e.e);
                mp.put(e.e, e.v);
            }
            ll.addFirst(e.e);
        }

        for(int i : res)
            System.out.println(i);
    }

}

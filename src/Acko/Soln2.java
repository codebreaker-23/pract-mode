package Acko;

import javax.management.MBeanRegistration;
import java.util.*;

public class Soln2 {

    public static void main(String[] args) {
/*
        int ar[] = {0,1,0,0,1,0,0,1};
        int b=2;

        List<Integer> li = new ArrayList<>();
        System.out.println(li.get(0));
*/
        System.out.println(new Soln2().seats("....x..xx...x.."));
    }

    public static int solve(int[] ar, int b) {
        Stack<Integer> st = new Stack<>();
        int n = ar.length;
        for(int i=0;i<n;i++){
            if(ar[i]==1)
                st.push(i);
        }

        int last=-1;
        while (!st.isEmpty() && Math.abs(st.peek() - n + 1) <= b - 1) {
            last = st.pop();
        }

        int c=1;
        for(int i=n-2;i>=0;i--){
            if(last!=-1 && Math.abs(last-i)<=b-1)
                continue;

            while(!st.isEmpty() && Math.abs(st.peek()-i)<=b-1){
                last=st.pop();
            }
            c++;
            if(st.isEmpty() && Math.abs(last-i) > b-1)
                return -1;
        }

        return c;
    }

    class Pair {
        public int a, b;

        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    class PairComp implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.a - o2.a;
        }
    }

    public int seats(String A) {
        int n = A.length();

        int c=0;
        for(int i=0;i<n;++i) {
            if (A.charAt(i) == 'x') {
                c++;
            }
        }

        if(c==1)
            return 0;

        Map<Integer, Pair> diffMap = new HashMap<>();

        int last=Integer.MAX_VALUE;
        for(int i=0;i<n;++i) {
            if (A.charAt(i) == 'x') {
                int v=Integer.MAX_VALUE;
                if (last != Integer.MAX_VALUE) {
                    v= i-last-1;
                }
                diffMap.put(i, new Pair(v, last));
                last = i;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(i!=last && A.charAt(i) == 'x') {
                int v = diffMap.get(i).a;
                if(last-i-1 < v)
                    v = last-i-1;
                diffMap.put(i, new Pair(v,last));
                last = i;
            }
        }

        Queue<Pair> queue = new PriorityQueue<>(new PairComp());
        for(int i=0;i<n;i++) {
            if(diffMap.containsKey(i))
                queue.add(diffMap.get(i));
        }

        int [] count = new int [n];
        int maxIndex = 0;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            count[p.b]++;

            if(count[p.b] > count[maxIndex])
                maxIndex = p.b;
        }

        int ans = 0;
        final int mod = 10000003;

        int i=0, j=maxIndex;
        while (i < j){
            if(A.charAt(i) != 'x') {
                i++;
                continue;
            }

            while(j>i && A.charAt(j) != '.')
                j--;

            if(j <= i)
                break;

            ans = (ans + (j-i))%mod;
            i++;
            j--;
        }

        i=n-1;
        j=maxIndex;
        while(i > j){
            if(A.charAt(i) != 'x') {
                i--;
                continue;
            }

            while(j<i && A.charAt(j) != '.')
                j++;

            if(j >= i)
                break;

            ans = (ans + (i-j))%mod;
            i--;
            j++;
        }

        return ans%mod;
    }
}


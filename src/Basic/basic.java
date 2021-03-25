package Basic;

import java.util.*;

public class basic {

    static class dt{
        public String a;
        public Integer b;

        public dt(String a, Integer b){
            this.a = a;
            this.b = b;
        }

//        @Override
//        public int hashCode(){
//            return Objects.hash(a);
//        }
//
//        @Override
//        public boolean equals(Object b){
//            dt thisB = (dt) b;
//            if(this.a == thisB.a)
//                return true;
//            return false;
//        }

        @Override
        public String toString(){
            return this.a;
        }
    }

    public static void main(String[] args) {
        int [] A = {0, 1, -1, 0};
//        for(int i : solve(A))
//            System.out.println(i);
        System.out.println(solve(4,A));
    }

    public static int solve(int A, int[] B) {
        int [] pf = new int[A];
        int [] sf = new int[A];

        for(int i=0;i<A;i++){
            if(i==0){
                pf[i]=B[i];
                sf[A-1-i]=B[A-1-i];
            }else{
                pf[i] = B[i]+pf[i-1];
                sf[A-1-i] = B[A-1-i]+sf[A-i];
            }
        }
        if(pf[A-1]%3 > 0)
            return 0;

        int k = pf[A-1]/3;
        int i=0;

        while(i<A-2 && pf[i]!=k)
            i++;

        int f=i;
        int c=0;
        for(i=i+1;i<A-1;i++){
            if(pf[i] - pf[f] == k && sf[i+1]==k)
                c++;
        }
        return c;
    }

    public static int repeatedNumber(final int[] A) {

        int n = (int)Math.sqrt(A.length);
        int [] buc = new int[n+1];

        int x=-1;
        for(int i : A){
            buc[i/n]++;
            if(buc[i/n] > n)
                x=i/n;
        }

        Set<Integer> hs = new HashSet<>();
        for(int i : A){
            if(i/n != x)
                continue;
            if(hs.contains(i))
                return i;
            hs.add(i);
        }

        return -1;
    }


    private static int [] betterSolve(int [] A){
        ArrayList<Integer> maxA = new ArrayList<>();
        ArrayList<Integer> curA = new ArrayList<>();

        long maxS=0;
        long curS=0;

        for(int i : A){
            if(i < 0){
                if(curS>=maxS){
                    if(curS > maxS || (curS == maxS && curA.size() <= maxA.size())){
                        maxS = curS;
                        maxA = curA;
                    }
                    curS=0;
                    curA=new ArrayList<>();
                }
                continue;
            }
            curS+=i;
            curA.add(i);
        }

        int [] ans = new int[maxA.size()];
        for(int i=0;i<maxA.size();i++){
            ans[i] = maxA.get(i);
        }

        return ans;
    }

    private static int [] solve(int [] A) {
        int n=A.length;
        long [] totalS = new long[n];
        Set<Integer> hs = new TreeSet<>();

        for(int i=0;i<n;++i){
            if(i==0)
                totalS[i] = A[i];
            else
                totalS[i] = A[i] + totalS[i - 1];

            if (A[i] < 0) {
                hs.add(i);
            }
        }

        if(n == 0 || hs.size()==n){
            return new int[0];
        }

        if(hs.size() == 0){
            return A;
        }

        int l=0, r=0;
        do{
            Iterator<Integer> i = hs.iterator();
            int x=i.next();
            long curS=0;
            long maxS=0;

            if(x-1 >= 0) {
                curS = totalS[x - 1];
                maxS = 0;
                if (curS >= maxS) {
                    maxS = curS;
                    l = -1;
                    r = x;
                }
            }

            int last = x;
            while(i.hasNext()){
                x=i.next();
                curS = totalS[x-1] - totalS[last];
                if(curS >= maxS){
                    if(curS == maxS && r-l-1 >= x-last-1) {
                        last=x;
                        continue;
                    }
                    maxS = curS;
                    l=last;
                    r=x;
                }
                last=x;
            }

            last=x;
            curS = totalS[n-1] - totalS[last];
            if(curS >= maxS){
                if(curS == maxS && r-l-1 >= x-last-1)
                    continue;
                maxS = curS;
                l=last;
                r=x;
            }
        }while(false);

        if(l==r && r==0)
            return new int[0];

        int [] ans = new int[r-l-1];
        for(int i=0;i<r-l-1;i++){
            ans[i] = A[l+1+i];
        }

        return ans;
    }

/*
        Map<String, Integer> s = new HashMap<>();
        dt arr[] = {new dt("a", 1), new dt("b", 2), new dt("c", 3), new dt("b", 2),
                new dt("b", 2), new dt("b", 2)};

        dt[] ans = {new dt("a", 1)};
        for (dt i : arr) {
            int c = 1;
            if (s.containsKey(i.a)) {
                c = s.get(i.a) + 1;
                if (c > ans[0].b) {
                    ans[0].b = c;
                    ans[0].a = i.a;
                }
            }
            s.put(i.a, c);
        }

        System.out.println(ans[0]);
*/
/*
        Map<String, Integer> m = new HashMap<>();
        Map<String, Integer> mt = new TreeMap<>();

        m.put("abc", 1);
        m.put("ab", 2);
        m.put("bc", 3);
*/

//        Iterator<dt> i = s.iterator();
//        while(i.hasNext()){
//            dt o = i.next();
//            System.out.println(o.a + " " + o.b);
//        }

//        for(Map.Entry<String, Integer> e : m.entrySet()){
//
//        }
}

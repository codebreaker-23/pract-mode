package G;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class chocoDstr {

//    public static void main(String[] args) {
//    }
//        run(new int []{3,45,30,21,19,4,50});
//        run(new int []{10, 40, 30});
//        run(new int[]{23, 14, 15, 14, 56, 29, 14});
//        Integer a [] = {2,3,11,1,4};
//        List<Integer> li = new ArrayList<>(Arrays.asList(a));
//
//        li.remove((Integer) 2);
//        li.remove((Integer) 3);
//
//        for(int i : li)
//            System.out.println(i);

//
//        Collections.sort(li.subList(2,5));
//        Arrays.sort(a, 2,5);
//
//        for(int i : a)
//            System.out.print(i);
//        System.out.println("\n");
//        for(int i : li)
//            System.out.print(i);
        /*
        *  A = [10, 5, 12, 6]
           B = [
                [1, 2]
                [1, 4]
                [4, 3]
               ]
        * */

//    {
//        int a [] = {11,12};
//        int b[][] = {{1, 2}};
//
//        System.out.println(new chocoDstr().deleteEdge(a,b));
//    }

    static int getSum(int[] a) throws Exception {
        int s=0;
        try {
            for (int i : a) {
                s += i;
            }
        }catch (Exception e){
            throw new Exception("exception found", e.getCause());
        }
        return s;
    }

    public void deleteEdge(int[] A, int[][] B) {
        int n = A.length;
        List<Integer>[] li = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; ++i) {
            li[i] = new ArrayList<>();
        }

    }

    public static void main(String[] args) {
        try {
            int sum = getSum(null);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    /*{
        for(int [] b : B){
            int u=b[0];
            int v=b[1];
            li[u].add(v);
            li[v].add(u);
        }

        boolean vis[] = new boolean[n+1];

        int maxS = Integer.MIN_VALUE;
        for(int [] b : B){
            int u=b[0];
            int v=b[1];

            li[u].remove(new Integer(v));
            li[v].remove(new Integer(u));

            Arrays.fill(vis,false);
            long s = dfs(u, vis, li, A);

            maxS = (int)Math.max((s * (sum-s))%mod, maxS);

            li[u].add(v);
            li[v].add(u);
        }

        return maxS;
    }*/

    int dfs(int u, boolean [] vis, List<Integer> [] li, int [] A){
        vis[u]=true;
        int s = A[u-1];

        for(int i : li[u]){
            if(!vis[i])
                s += dfs(i, vis, li, A);
        }
        return s;
    }



    static void run(int [] a){
        int c=0;
        int n = a.length;
        for(int i=0;i<n;){
            int j=i;
            while(j < n-1 && a[j]>a[j+1])
                j++;
            c += getSum(j-i+1) + ((j==i && i>0 && a[i] > a[i-1])?1:0);
            i=j+1;
        }
        System.out.println(c);
    }

    static int getSum(int l){
        return l*(l+1)/2;
    }

}

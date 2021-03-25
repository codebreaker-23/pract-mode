package Ib;

import java.util.*;

public class Solution implements Comparable<Solution>{
    int a, b;

    static Boolean [][] dp = new Boolean[1005][10005];

    public Solution(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Solution s) {
        return s.a - this.a;
    }



    public static void main(String[] args) {
        List<Solution> ar = Arrays.asList(new Solution(1,2), new Solution(2,3));

        Collections.sort(ar);

        for(Solution i : ar)
            System.out.println(i.a);

        int a [] = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
        int b[] = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
        int c =10;

//        for(int i : solve(a,b,c))
//            System.out.println(i);
    }

    public static boolean splitSum(int i, int sum, int n, int [] ar){
        if(dp[i][sum]!= null)
            return dp[i][sum];
        if(i==n)
            return false;
        if(sum == 0)
            return true;

        boolean ans = splitSum(i+1, sum, n, ar);
        if(ar[i] <= sum)
            ans |= splitSum(i+1, sum-ar[i],n, ar);

        return dp[i][sum] = ans;
    }

    private static int [] sorted(int [] x){
        return Arrays.stream(x).
        boxed().
        sorted((a, b) -> a-b>0?-1:1). // sort descending
        mapToInt(i -> i).
        toArray();
    }

    public static int[] solve(int[] A, int[] B, int C) {
       int n=A.length;

       int [] f = new int[C];
       if(n < C){
           return f;
       }

       A = sorted(A);
       B = sorted(B);

       Queue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());  //max-heap

       ArrayList<Integer> ans = new ArrayList<>();
       for(int i=0;i<n;++i){
           addtoQ(A[i] + B[i], a, C,i, ans);
           if(i+1 < n) {
               addtoQ(A[i] + B[i + 1], a, C, i, ans);
               addtoQ(A[i + 1] + B[i], a, C, i, ans);
           }
       }

//       for(int i=0;i<C;++i)
//           a.add(A[0]+B[i]);
//
//       for(int i=1;i<C;++i){
//           int xj=bSearch(a.peek()-A[i], B);
//           for(int j=0;j<=xj;++j){
//               int e=A[i]+B[j];
//               if(a.peek()<e){
//                   a.poll();
//                   a.add(e);
//               }
//           }
//
//       }
//
//       for(int i=C-1;i>=0;i--)
//            ans[i]=a.poll();
//
        for(int i=0;i<C;++i)
            f[i]=ans.get(i);
        return f;
    }

    private static void addtoQ(int e, Queue<Integer> a, int C, int i, ArrayList<Integer> ans){
        if(i==0)
            a.add(e);
        else{
            ans.add(a.poll());
            a.add(e);
        }
    }

    private static int bSearch(int key, int [] a){
        int low = 0;
        int high = a.length-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                high = mid - 1;
            else if (midVal > key)
                low = mid + 1;
            else
                return mid; // key found
        }
        return low;  // key not found.
    }


}


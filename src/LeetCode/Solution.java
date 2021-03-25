package LeetCode;

import java.util.*;

class Solution {

    static int dp[][];

    class dataType implements Comparable<dataType>{
        public String s;
        public Integer i;

        public dataType(String t, Integer i){
            this.s = t;
            this.i = i;
        }

        @Override
        public int compareTo(dataType o2) {
            dataType o1 = this;
            if (o1.i.equals(o2.i)) {
                return o2.s.compareTo(o1.s);
            }
            return o1.i - o2.i;
        }
    }

    public static void main(String[] args) {
//        for(String s : new Solution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},3))
//            System.out.println(s);
        dp = new int[105][105];
        lcs("geeksforgeek", "imageekforthegeeks");
    }

    static void lcs(String a, String b){
        int n=a.length();
        int m=b.length();

        int maxL = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxL = Math.max(maxL, dp[i][j]);
                }else
                    dp[i][j]=0;
            }
        }
        System.out.println(maxL);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hm = new HashMap<>();
        List<dataType> li = new ArrayList<>();

        int i;
        for(String s : words){
            if(hm.containsKey(s)){
                i=hm.get(s);
                dataType d = li.get(i);
                d.i+=1;
                continue;
            }
            li.add(new dataType(s, 1));
            hm.put(s, li.size()-1);
        }

        Queue<dataType> pq = new PriorityQueue<>();
        i=0;
        for(;i<k;++i){
            pq.add(li.get(i));
        }

        while(i < li.size()){
            pq.add(li.get(i));
            if(pq.size() > k)
                pq.poll();
            i++;
        }

        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().s);
        }

        Collections.reverse(ans);
        return ans;
    }


}
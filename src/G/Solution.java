package G;


import java.util.*;

public class Solution {
    static Stack<ArrayList<Integer>> st = new Stack<>();

    public static void main(String[] args) {
//        ArrayList<String> s = new ArrayList<>(Arrays.asList("a","b","c","c","c","d","e","e","f"));
        int ar [] = {1,1,2,3,21,22};
//        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,2,34,21,2));

        System.out.println(Arrays.binarySearch(ar, 20));
/*        ArrayList<String> s = new ArrayList<>(Arrays.asList("a","a"));
        for(String d : getShrunkArray(s, 2))
            System.out.println(d);*/
    }

    static List<String> rr(List<String> ar, int i, int j){
//        int k=i;
//        while(ar.get(k)!=ar.get(j))
//            ar.remove(k);
        ar.subList(i,j).clear();
        return ar;
    }

    public static List<String> getShrunkArray(List<String> ar, int l) {
        if(l==1)
            return new ArrayList<>();

        boolean f=false;
        while(!f){
            int i=0,j=0;
            f=true;
            while(j<ar.size()){
                while(j<ar.size() && ar.get(i).equals(ar.get(j)))
                    j++;

                if(j-i >= l){
                  ar = rr(ar, i, j);
                  f=false;
                }
                i=j;
            }
        }
        return ar;
    }



    public int[] solve(TreeNode a) {
        st.clear();
        Queue<TreeNode> q = new LinkedList<>();
        if(a!=null) {
            q.add(a);
            q.add(new TreeNode(-1));
        }

        ArrayList<Integer> d = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t.val == -1){
                st.push(new ArrayList<>(d));
                d.clear();

                if(q.size() > 0)
                    q.add(t);
                continue;
            }
            d.add(t.val);
            if(t.left!=null)
                q.add(t.left);
            if(t.right!=null)
                q.add(t.right);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.addAll(st.pop());
        }

        int [] ret = new int[ans.size()];
        int k=0;
        for(int i : ans)
            ret[k++]=i;
        return ret;
    }
}

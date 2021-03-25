package Basic;

import java.util.*;

public class Solve {

    public static void main(String[] args) {
        int a = 1;
        System.out.println(new Solve().multiple(a));
    }

    public String multiple(int A) {
        String base = "1";
        Set<String> hset = new HashSet<>();

        Queue<String> q = new PriorityQueue<>();
        q.add(base);

        while(!q.isEmpty()){
            String top = q.poll();
            if(getnum(top)%(long)A == 0)
                return top;
            addAllNexts(top, hset, q);
        }

        return "";
    }

    public long getnum(String base){
        return Long.valueOf(base);
    }

    public void addAllNexts(String base, Set<String> hset, Queue<String> q){
        List<Integer> zeroindex = new ArrayList<>();
        for(int i=0;i<base.length();i++) {
            if(base.charAt(i) == '0')
                zeroindex.add(i);
        }

        if(zeroindex.isEmpty()) {
            q.add(getHighNext(base));
        }
        else {
            for (int i : zeroindex) {
                String temp = base.substring(0, i) + "1" + base.substring(i + 1);
//                if (allOnes(temp))
//                    break;
                if (hset.contains(temp))
                    continue;

                hset.add(temp);
                q.add(temp);
            }
        }
    }

    private String getHighNext(String base){
        String highNum = "1";
        for (int i = 0; i < base.length(); i++)
            highNum += "0";
        return highNum;
    }

    public boolean allOnes(String newnum){
        String temp="";
        for(int i=0;i<newnum.length();i++)
            temp+="1";
        return newnum.equals(temp);
    }

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Logs{
    String s1;
    public static HashMap<String, Integer> logMap = new HashMap<>();

    Logs(String s){
        this.s1 = s;
        if(logMap.containsKey(s))
            logMap.put(s, logMap.get(s)+1);
        else
            logMap.put(s,1);
    }

}

public class abc {

    public static void main(String[] args) {

        Integer k = 3;
        ArrayList<Logs> list = new ArrayList<>();
        list.add(new Logs("f"));
        list.add(new Logs("b"));
        list.add(new Logs("c"));
        list.add(new Logs("a"));
        list.add(new Logs("a"));
        list.add(new Logs("c"));
        list.add(new Logs("r"));
        list.add(new Logs("f"));
        list.add(new Logs("f"));
        list.add(new Logs("s"));
        list.add(new Logs("a"));

        PriorityQueue<Tracker> pq = new PriorityQueue<>((a,b)-> a.hits>b.hits?-1:1);
        System.out.println(Logs.logMap);

        HashMap<String, Boolean> inQ = new HashMap<>();
        for(Logs i : list){
            if(!inQ.containsKey(i.s1)) {
                pq.add(new Tracker(i.s1, Logs.logMap.get(i.s1)));
                inQ.put(i.s1, true);
            }
        }

        for(int i=0;i<k;++i){
            Tracker s = pq.poll();
            System.out.println( s.s1 + " " + s.hits);
        }
    }
}

class Tracker{
    String s1;
    Integer hits;

    public Tracker(String s, Integer h){
        this.s1 = s;
        this.hits = h;
    }
}
package N;

import java.util.ArrayList;

public class FileMeta {
    String name;
    ArrayList<Integer> blockIds;
    int size;
    Object autInfo;

    public FileMeta(String n){
        this.name = n;
        this.blockIds = new ArrayList<>();
        this.size = 0;
        this.autInfo = new Object();
    }
}

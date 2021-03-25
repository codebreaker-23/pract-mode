package N;

public class Solution {

    public static void main(String[] args) {
        BlockDeviceImpl bHandler = new BlockDeviceImpl(10,10);
        FileHandler fHandler = new FileHandler(bHandler);


        fHandler.fWrite("fileA", "abcdefghijklmnopqrstuvwx");
        String a = "abc, xyz";

        System.out.println(a.split(",")[0]);

//        try {
//            f = fHandler.fOpen("fileA");
//        }catch (Exception ignore){}
//
//        try {
//            String d = fHandler.fRead(f);
//            System.out.println(d);
//        }catch (Exception ignore){}
//
//        f = fHandler.fClose(f);
//        try{
//            fHandler.fRead(f);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        Set<Integer> s = new TreeSet<>();
//        Iterator<Integer> it = s.iterator();
//        while(it.hasNext()){
//
//        }

    }
}

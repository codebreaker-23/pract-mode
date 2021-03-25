package N;

public class File {
//    char [] data;
    FileMeta metaData;

    public File(String s, String d){
//        this.data = new char[d.length()];
        this.metaData = new FileMeta(s);
    }

    public File removeRef(){
        return null;
    }
}

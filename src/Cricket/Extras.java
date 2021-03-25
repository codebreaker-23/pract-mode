package Cricket;

public class Extras {
    int noBalls;
    int wideBalls;


    public Extras(){

    }

    public void setNoBalls(int noBalls) {
        this.noBalls = noBalls;
    }

    public void setWideBalls(int wideBalls) {
        this.wideBalls = wideBalls;
    }

    public int getTotal(){
        return noBalls + wideBalls;
    }
}

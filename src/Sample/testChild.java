package Sample;

public class testChild extends testBase{

    public testChild(){
        super();
    }

    public void c(){
        System.out.println("in child c");
    }

    public static void main(String[] args) {
        testBase ob = new testChild();
        ob.d();

        ob.process();
    }
}

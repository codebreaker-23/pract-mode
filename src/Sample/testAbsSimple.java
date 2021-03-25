package Sample;

public class testAbsSimple extends testAbs implements testAbsI{

    @Override
    public void a() {
        System.out.println("in a");
    }

    @Override
    public void b() {
        System.out.println("in b");
    }

    @Override
    public void d() {
        System.out.println("in d");
    }



    public static void main(String[] args) {
        testAbsSimple a = new testAbsSimple();
        a.c();
        a.b();
        a.d();

//        testAbsI a1 = new tes();
//        a1.c();
    }

    @Override
    public void e() {

    }
}

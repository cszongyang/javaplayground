/**
 * Created by zongyangli on 12/19/17.
 *
 * the keyword static indicates that the particular member belongs to a type itself, rather than to an instance of that type.
 */
public class StaticClass {

    static String q = "123";

    static class StaticNested {

        static Object obj = new Object();

        private void run() {
            //can access to outer class variable.
            String i = StaticClass.q;
            System.out.println("from nonstatic method");
        }

        private static void staticRun() {
            System.out.println("from static method");
        }
    }

    class Inner {
        private void run() {
            System.out.println("from nonstatic method");
        }
    }

    public static void main(String[] args) {

        StaticNested sn = new StaticNested();
        //the method run() belongs to sn instance.
        sn.run();

        //the method staticRun() belongs to StaticNested class
        StaticNested.staticRun();

        //all instances share a same static member of that class.
        StaticNested sn1 = new StaticNested();
        System.out.println(sn.obj == sn1.obj);

        //the correct way to instantiate a inner class.
        StaticClass staticClass = new StaticClass();
        StaticClass.Inner innerClass = staticClass.new Inner();
        innerClass.run();

    }

}

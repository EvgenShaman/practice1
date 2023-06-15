public class Main {
    public static void main(String[] args) {
        //Singleton3 a = new Singleton3();
        System.out.println(Singleton3.val);
        Singleton3.val_inc();
        System.out.println(Singleton3.val);
        //Singleton a = new Singleton();
        Singleton a = Singleton.getInstance();
        System.out.println(a);
        a = Singleton.getInstance();
        System.out.println(a);
        //Singleton2 a = new Singleton2();
        System.out.println(Singleton2.INSTANCE.getVal());
    }
}

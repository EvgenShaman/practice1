import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception {
        MyClass<Integer, Integer> ahoy = new MyClass();
        MyClass2<Integer> ayaya = new MyClass2<>();
        Thread one = new  Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ahoy.put(i, i);
                ayaya.add(i);
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 51; i++) {
                ahoy.put(i+50, i+50);
                ayaya.add(i+50);
            }
        });
        one.start();
        two.start();
        Thread.sleep(3000);
        ahoy.values().forEach(System.out::println);
        ayaya.stream().forEach(System.out::println);
    }
    private static final Lock lock = new ReentrantLock();
}


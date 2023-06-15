import java.lang.annotation.Target;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String[] a = new String[6];
        a[0] = "Hermit";
        a[1] = "Magician";
        a[2] = "The Star";
        a[3] = "Chariot";
        a[4] = "Hierophant";
        a[5] = "The Moon";
        Task1 work = new Task1();
        a = work.apply(a);
        int i = 0;
        while (i != a.length){
            System.out.println(a[i]);
            i++;
        }
    }
}
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Human{
    static long summ = 1;
    long age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    Human(long age, String fn, String ln, LocalDate bd, int w){
        firstName = fn;
        lastName = ln;
        birthDate = bd;
        weight = w;
        this.age = Year.now().getValue() - bd.getYear();
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        if ((cal.get(Calendar.MONTH)+1 < bd.getMonth().getValue()) ||
                ((cal.get(Calendar.MONTH)+1 == bd.getMonth().getValue()) &&
                        (cal.get(Calendar.DAY_OF_MONTH) < bd.getDayOfMonth()))){
            this.age--;
        }
    }
    public long getAge() {return age;}
    public int getWeight() {
        return weight;
    }

    public void print(){
        System.out.println("age: " + age + ", FirstName: " + firstName + ", LastName: " + lastName + ", BirthDate: " + birthDate + ", Weight: " + weight);
    }
    public void summUp(){
        summ*=getAge();
    }
}

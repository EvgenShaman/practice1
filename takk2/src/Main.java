import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.logging.Handler;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(20, "Evgeniy", "Ivanov", LocalDate.of(2002,7,18), 77));
        humans.add(new Human(22, "Gleb", "Alexandrov", LocalDate.of(2000,2,29), 58));
        humans.add(new Human(20, "Vitaliy", "Volkov", LocalDate.of(2002,9,2), 64));
        humans.add(new Human(19, "Alexandr", "Ivanov", LocalDate.of(2003,8,22), 71));
        humans.add(new Human(19, "Margarita", "Bestujeva", LocalDate.of(2003,12,18), 55));
        humans.add(new Human(19, "Roman", "Osipov", LocalDate.of(2003,5,17), 99));
        humans.add(new Human(20, "Bogdan", "Baranov", LocalDate.of(2002,4,5), 65));
        humans.add(new Human(20, "Erik", "Ivanov", LocalDate.of(2002,7,13), 105));
        humans.add(new Human(21, "Ignat", "Petrov", LocalDate.of(2001,9,28), 78));
        humans.add(new Human(22, "Vasilisa", "Uspenskaya", LocalDate.of(2000,1,8), 80));
        Stream<Human> stream = humans.stream();
        stream.sorted(Comparator.comparingInt(Human::getWeight).reversed()).forEach(Human::print);
        System.out.print("==========================================\n");
        stream = humans.stream();
        stream.filter(human -> human.lastName != "Ivanov").forEach(Human::print);
        System.out.print("==========================================\n");
        stream = humans.stream();
        stream.sorted(Comparator.comparingLong(Human::getAge)).forEach(Human::print);
        System.out.print("==========================================\n");
        stream = humans.stream();
        stream.forEach(Human::summUp);
        System.out.println(Human.summ);
    }
}
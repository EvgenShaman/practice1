package task6.factoryMethod.IndTask;

import java.util.Scanner;

public class System1 {
    public static void main(String[] args) {
        Drinker client = new Drinker();
        LemonadeAutomate automate = new LemonadeAutomate();
        NewVersion automate2 = new NewVersion(automate);
        Scanner a = new Scanner(System.in);
        client.addAutomate(automate2);
        String str;
        while(true){
             str = a.next();
             client.buy(str);
             client.printInfo();
        }
    }
}

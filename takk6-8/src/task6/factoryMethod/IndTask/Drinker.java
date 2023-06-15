package task6.factoryMethod.IndTask;

import java.util.ArrayList;
import java.util.List;

public class Drinker {
    int money = 500;
    NewVersion automate;
    void addAutomate(NewVersion automate){
        this.automate = automate;
    }
    List<Cola> colaList = new ArrayList<>();
    List<CherrySoda> cherryList = new ArrayList<>();
    List<Lemonade> lemonadeList = new ArrayList<>();
    void buy(String item){
        if ("L".equals(item)) {
            automate.SellLemonade(this);
        }
        else if ("C".equals(item)){
            automate.SellCola(this);
        }
        else if ("CS".equals(item)){
            automate.SellCherrySoda(this);
        }
    }
    void printInfo(){
        System.out.println("This drinker has " + Integer.toString(colaList.size()) + " glasses of Cola " +
                Integer.toString(lemonadeList.size()) + " glasses of Lemonade " +
                Integer.toString(cherryList.size()) + " glasses of Cherry Soda and " +
                Integer.toString(money) + " money");
    }
}

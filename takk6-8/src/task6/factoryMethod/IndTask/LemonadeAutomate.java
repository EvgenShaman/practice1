package task6.factoryMethod.IndTask;

import task6.factoryMethod.IndTask.Drinker;

public class LemonadeAutomate {
    void SellSoda(Drinker client){
        client.lemonadeList.add(new Lemonade());
        client.money -= 30;
    }
}

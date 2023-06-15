package task6.factoryMethod.IndTask;

public class NewVersion {
    LemonadeAutomate previous;
    NewVersion(LemonadeAutomate prev){
        previous = prev;
    }
    void SellCherrySoda(Drinker client){
        client.cherryList.add(new CherrySoda());
        client.money -= 40;
    }
    void SellLemonade(Drinker client){
        previous.SellSoda(client);
    }
    void SellCola(Drinker client){
        client.colaList.add(new Cola());
        client.money -= 50;
    }
}

package task8.Mediator;

public class CColleague implements Colleague{
    CMediator dude;
    CColleague(){
        dude = new CMediator();
        dude.colleague = this;
    }
    int details = 5, products = 0;
    @Override
    public void thingToDo() {
        details -= 4;
        products++;
        dude.notified("dai detalei");
    }
}

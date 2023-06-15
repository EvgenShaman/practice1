package task8.Mediator;

public class CMediator implements Mediator{
    CColleague colleague;
    @Override
    public void notified(String signal) {
        if (signal == "dai detalei"){
            colleague.details += 4;
        }
    }
}

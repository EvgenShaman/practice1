package task7.Decorator;

public class CDecorator implements Decorator{
    private CComponent addedState;
    @Override
    public String operation() {
        return addedState.operation();
    }
    public String addedBehavior() {
        return addedState.operation() + "dabadee dabadae";
    }
}

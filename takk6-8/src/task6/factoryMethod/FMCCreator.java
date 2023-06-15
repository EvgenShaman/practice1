package task6.factoryMethod;

public class FMCCreator implements FMCreator{

    @Override
    public FMProduct FactoryMethod() {
        return new FMCProduct();
    }
}

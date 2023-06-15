package task6.AbstractFactory;

public class ACFactory implements AFactory{
    @Override
    public AFProduct1 create1() {
        return new AFProduct1();
    }

    @Override
    public AFProduct2 create2() {
        return new AFProduct2();
    }
}

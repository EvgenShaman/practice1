public class FactoryB extends Factory{

    @Override
    public Product FactoryMethod() {
        return new ProductB();
    }
}
public class FactoryA extends Factory{
    @Override
    public Product FactoryMethod() {
        return new ProductA();
    }
}

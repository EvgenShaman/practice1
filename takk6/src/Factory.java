abstract class Factory
{
    public abstract Product FactoryMethod();
    Product CreatorB(){
        return new ProductB();
    }
}
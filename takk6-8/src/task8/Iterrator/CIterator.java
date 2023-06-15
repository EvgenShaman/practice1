package task8.Iterrator;

public class CIterator implements Iterator{
    public CIterator right;
    @Override
    public Iterator next() {
        return right;
    }
}

package task8.Iterrator;

public class CAggregate implements Aggregate{
    CIterator current = null;
    @Override
    public void createIterator() {
        if (current == null){
            current = new CIterator();
        }
        else {
            current.right = new CIterator();
            current = current.right;
        }
    }
}

import java.util.*;
import java.util.stream.Stream;

public class MyClass2<J> implements Set {

    Set<J> mainSet;
    public MyClass2(){
        mainSet = new HashSet<J>();
    }
    @Override
    public int size() {
        return mainSet.size();
    }
    @Override
    synchronized public boolean isEmpty() {
        return mainSet.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return mainSet.contains(o);
    }

    @Override
    synchronized public Iterator iterator() {
        return mainSet.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return mainSet.toArray();
    }

    @Override
    synchronized public boolean add(Object o) {
        return mainSet.add((J) o);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return mainSet.remove(o);
    }

    @Override
    synchronized public boolean addAll(Collection c) {
        return mainSet.addAll(c);
    }

    @Override
    synchronized public void clear() {
        mainSet.clear();
    }

    @Override
    synchronized public boolean removeAll(Collection c) {
        return mainSet.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection c) {
        return mainSet.removeAll(c);
    }

    @Override
    synchronized public boolean containsAll(Collection c) {
        return mainSet.containsAll(c);
    }

    @Override
    synchronized public Object[] toArray(Object[] a) {
        return mainSet.toArray(a);
    }

    @Override
    public Stream stream() {
        return mainSet.stream();
    }
}

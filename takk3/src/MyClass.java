import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass<J, K> implements Map {
    Map<J, K> mainMap;
    private static final Lock lock = new ReentrantLock();
    public MyClass(){
        mainMap = new HashMap<J, K>();
    }

    @Override
    public int size() {
        lock.lock();
        int temp = mainMap.size();
        lock.unlock();
        return temp;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean temp = mainMap.isEmpty();
        lock.unlock();
        return temp;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        boolean temp = mainMap.containsKey(key);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        boolean temp = mainMap.containsValue(value);
        lock.unlock();
        return temp;
    }

    @Override
    public Object get(Object key) {
        lock.lock();
        Object temp = mainMap.containsKey(key);
        lock.unlock();
        return temp;
    }

    @Override
    public Object put(Object key, Object value) {
        lock.lock();
        Object temp = mainMap.put((J) key, (K) value);
        lock.unlock();
        return temp;
    }

    @Override
    public Object remove(Object key) {
        lock.lock();
        Object temp = mainMap.containsKey(key);
        lock.unlock();
        return temp;
    }

    @Override
    public void putAll(Map m) {
        lock.lock();
        mainMap.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        mainMap.clear();
        lock.unlock();
    }

    @Override
    public Set keySet() {
        lock.lock();
        Set temp = mainMap.keySet();
        lock.unlock();
        return temp;
    }

    @Override
    public Collection values() {
        lock.lock();
        Collection temp = mainMap.values();
        lock.unlock();
        return temp;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}

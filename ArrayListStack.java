import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListStack<V> implements Iterable<V> {
    private List<V> list = new ArrayList<>();

    public void push(V item) {
        list.add(0, item);
    }

    @Override
    public Iterator<V> iterator() {
        return list.iterator();
    }
}

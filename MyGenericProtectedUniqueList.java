import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyGenericProtectedUniqueList<T> implements Iterable<T>, Comparator<T> {
    private List<T> list = new ArrayList<>();
    private String password;

    public MyGenericProtectedUniqueList(String password) {
        this.password = password;
    }

    public void add(T o) {
        if (o == null)
            throw new RuntimeException("the object cannot be null!");
        if (list.contains(o))
            return;
        list.add(o);
    }

    public void remove(T o) {
        if (o == null)
            throw new RuntimeException("the object cannot be null!");
        list.remove(o);
    }

    public void removeAt(int index) {
        if (index < 0 || index > list.size() - 1)
            throw new IndexOutOfBoundsException();
        list.remove(index);
    }

    public void clear(String password) {
        if (!this.password.equals(password))
            throw new RuntimeException("Given password was incorrect!");
        list.clear();
    }

    public void sort(String password) {
        if (!this.password.equals(password))
            throw new RuntimeException("Given password was incorrect!");
        list.sort(this);
    }


    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            private int cur = 0;

            @Override
            public boolean hasNext() {
                return cur < list.size();
            }

            @Override
            public T next() {
                return list.get(cur++);
            }
        };
    }

    @Override
    public int compare(T o1, T o2) {
        if( o1 instanceof Comparable)
            return ((Comparable<T>) o1).compareTo(o2);
        else return 0; //cannot compare the two so they are equal
    }

    @Override
    public String toString() {
        return "MyGenericProtectedUniqueList{" +
                "list=" + list +
                ", password='" + password + '\'' +
                '}';
    }
}

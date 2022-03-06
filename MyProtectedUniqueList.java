import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyProtectedUniqueList implements Iterable, Comparator<String> {
    private List<String> words = new ArrayList<>();
    private String password;

    public MyProtectedUniqueList(String password) {
        this.password = password;
    }

    public void add(String word) {
        if (word.isEmpty() || word == null)
            throw new RuntimeException("the word cannot be empty or null!");
        if (words.contains(word))
            return;
        words.add(word);
    }

    public void remove(String word) {
        if (word.isEmpty() || word == null)
            throw new RuntimeException("the word cannot be empty or null!");
        words.remove(word);
    }

    public void removeAt(int index) {
        if (index < 0 || index > words.size() - 1)
            throw new IndexOutOfBoundsException();
        words.remove(index);
    }

    public void clear(String password) {
        if (!this.password.equals(password))
            throw new RuntimeException("Given password was incorrect!");
        words.clear();
    }

    public void sort(String password) {
        if (!this.password.equals(password))
            throw new RuntimeException("Given password was incorrect!");
        words.sort(this);
    }


    @Override
    public Iterator iterator() {
        return new Iterator<String>() {
            private int cur = 0;

            @Override
            public boolean hasNext() {
                return cur < words.size();
            }

            @Override
            public String next() {
                return words.get(cur++);
            }
        };
    }

    @Override
    public int compare(String w1, String w2) {
        return w1.compareTo(w2);
    }

    @Override
    public String toString() {
        return "MyProtectedUniqueList{" +
                "words=" + words +
                ", password='" + password + '\'' +
                '}';
    }
}

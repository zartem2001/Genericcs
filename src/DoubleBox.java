public class DoubleBox<T> {
    private RandomBox<T> first;
    private RandomBox<T> second;

    public boolean put(int key, T value) {
        if (first == null) {
            first = new RandomBox<>(key, value);
            return true;
        }
        if (second == null) {
            second = new RandomBox<>(key, value);
            return true;
        }
        return false;
    }

    public T get(int key) {
        if (first != null && first.tryUnlock(key) != null) {
            return first.tryUnlock(key);
        }
        if (second != null && second.tryUnlock(key) != null) {
            return second.tryUnlock(key);
        }
        return null;
    }

    public int size() {
        if (first == null) {
            return 0;
        }
        if (second == null) {
            return 1;
        }
        return 2;
    }
}


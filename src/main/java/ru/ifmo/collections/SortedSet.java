package ru.ifmo.collections;

import java.util.*;

public class SortedSet<T> extends AbstractSet<T> {
    private final TreeMap<T, Object> contents;

    public static <T> SortedSet<T> create() {
        return new SortedSet<>();
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    public SortedSet(Comparator<T> comparator) {
        contents = new TreeMap<>(comparator);
    }

    public SortedSet() {
        contents = new TreeMap<>();
    }

    @Override
    public boolean add(T t) {
        return contents.put(t, true) == null;
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Null");
        }
        return contents.remove(object) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean added = false;
        for (T value : collection) {
            added |= add(value);
        }
        return added;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean removed = false;
        for (var value : collection) {
            removed |= contents.remove(value) != null;
        }
        return removed;
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.keySet().size();
    }

    public List<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public List<T> getReversed() {
        return new ArrayList<>(contents.descendingKeySet());
    }
}
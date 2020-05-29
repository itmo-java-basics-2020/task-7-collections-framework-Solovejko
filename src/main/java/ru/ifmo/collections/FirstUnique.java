package ru.ifmo.collections;

import java.util.*;

public class FirstUnique {
    private final Deque<Integer> unique;
    private final List<Integer> nonUnique;

    public FirstUnique(int[] numbers) {
        unique = new LinkedList<>();
        nonUnique = new ArrayList<>();

        for (var number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        if (unique.isEmpty()) {
            return -1;
        } else {
            return unique.peek();
        }
    }

    public void add(int value) {
        if (!nonUnique.contains(value)) {
            if (unique.contains(value)) {
                unique.remove(value);
                nonUnique.add(value);
            }
            else {
                unique.add(value);
            }
        }
    }
}
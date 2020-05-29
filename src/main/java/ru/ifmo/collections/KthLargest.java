package ru.ifmo.collections;

import java.util.PriorityQueue;

public class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] numbers) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (var number : numbers) {
            queue.add(number);
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
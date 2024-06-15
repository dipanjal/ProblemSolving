package com.dipanjal.common;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxHeapWithPriorQueue {

    private static <E> PriorityQueue<E> addToHeap(List<E> items, Comparator<E> comparator){
        PriorityQueue<E> queue = new PriorityQueue<>(comparator);
        queue.addAll(items);
        return queue;
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = addToHeap(List.of(5,2,8,6,9,1), comparator);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}

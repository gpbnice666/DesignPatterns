package com.bo.thread.forkJoinPool;

import java.util.concurrent.*;


/**
 * @Author: gpb
 * @Date: 2023/4/27 10:56
 * @Description:
 */
public class ForkJoinDemo {
    private static final int THRESHOLD = 1000;

    public static void main(String[] args) {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new SumTask(array, 0, array.length));
        System.out.println("Sum: " + result);
    }

    static class SumTask extends RecursiveTask<Integer> {
        private int[] array;
        private int start;
        private int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= THRESHOLD) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join() + rightTask.join();
            }
        }
    }
}

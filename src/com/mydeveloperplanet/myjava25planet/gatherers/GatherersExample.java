package com.mydeveloperplanet.myjava25planet.gatherers;

import java.util.List;
import java.util.stream.Gatherer;

public class Gatherers {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        exampleFold(nums);
        exampleMapConcurrent(nums);
        exampleScan(nums);
        exampleWindowFixed(nums);
        exampleWindowSliding(nums);
    }

    static void exampleFold(List<Integer> nums) {
        int sum = nums.stream()
                .gather(Gatherer.fold(0, (acc, x) -> acc + x))
                .findFirst()              // fold produces a single result
                .orElse(0);

        System.out.println("fold sum = " + sum); // 15
    }

    static void exampleMapConcurrent(List<Integer> nums) {
        List<Integer> squares = nums.stream()
                .gather(Gatherer.mapConcurrent(4, x -> x * x)) // 4 = parallelism hint
                .toList();

        System.out.println("mapConcurrent squares = " + squares); // [1, 4, 9, 16, 25]
    }

    static void exampleScan(List<Integer> nums) {
        List<Integer> runningSums = nums.stream()
                .gather(Gatherers.scan(0, (acc, x) -> acc + x))
                .toList();

        System.out.println("scan running sums = " + runningSums); // [1, 3, 6, 10, 15]
    }

    static void exampleWindowFixed(List<Integer> nums) {
        int size = 2;

        List<List<Integer>> windows = nums.stream()
                .gather(Gatherers.windowFixed(size))
                .map(List::copyOf) // make windows immutable snapshots
                .toList();

        System.out.println("windowFixed(2) = " + windows); // [[1, 2], [3, 4], [5]]
    }

    static void exampleWindowSliding(List<Integer> nums) {
        int size = 3;

        List<List<Integer>> windows = nums.stream()
                .gather(Gatherers.windowSliding(size))
                .map(List::copyOf)
                .toList();

        System.out.println("windowSliding(3) = " + windows); // [[1, 2, 3], [2, 3, 4], [3, 4, 5]]
    }


}

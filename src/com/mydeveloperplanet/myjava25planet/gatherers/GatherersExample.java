package com.mydeveloperplanet.myjava25planet.gatherers;

import java.util.List;
import java.util.stream.Gatherers;

public class GatherersExample {

    static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        exampleFold(numbers);
        exampleMapConcurrent(numbers);
        exampleScan(numbers);
        exampleWindowFixed(numbers);
        exampleWindowSliding(numbers);
    }

    static void exampleFold(List<Integer> numbers) {
        int sum = numbers.stream()
                .gather(Gatherers.fold(() -> 0, (acc, x) -> acc + x))
                .findFirst()              // fold produces a single result
                .orElse(0);

        System.out.println("fold sum = " + sum); // 45
    }

    static void exampleMapConcurrent(List<Integer> numbers) {
        List<Integer> squares = numbers.stream()
                .gather(Gatherers.mapConcurrent(4, x -> x * x)) // 4 = parallelism hint
                .toList();

        System.out.println("mapConcurrent squares = " + squares); // [1, 4, 9, 16, 25, 36, 49, 64, 81]
    }

    static void exampleScan(List<Integer> numbers) {
        List<Integer> runningSums = numbers.stream()
                .gather(Gatherers.scan(() -> 0, (acc, x) -> acc + x))
                .toList();

        System.out.println("scan running sums = " + runningSums); // [1, 3, 6, 10, 15, 21, 28, 36, 45]
    }

    static void exampleWindowFixed(List<Integer> numbers) {
        int size = 2;

        List<List<Integer>> windows = numbers.stream()
                .gather(Gatherers.windowFixed(size))
                .toList();

        System.out.println("windowFixed(2) = " + windows); // [[1, 2], [3, 4], [5, 6], [7, 8], [9]]
    }

    static void exampleWindowSliding(List<Integer> numbers) {
        int size = 3;

        List<List<Integer>> windows = numbers.stream()
                .gather(Gatherers.windowSliding(size))
                .toList();

        System.out.println("windowSliding(3) = " + windows); // [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9]]
    }

}

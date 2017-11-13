package com.toby.cs504;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("WeightedRandomSampling <num of trials> <probability of picking 1> <probability of picking 2> ... <probability of picking n>");
        }

        int n = args.length;
        int trials = Integer.valueOf(args[0]);
        Double sum = 0.0;
        for (int i = 1; i < n; i++) {
            sum += Double.valueOf(args[i]);
        }
        if (sum != 1.0) {
            System.out.println("Sum of arguments must be 1.0");
            return;
        }

        System.out.println("===== Input =====");
        for (int i = 1; i < n; i++) {
            System.out.println("Sample " + i + " weight: " + args[i]);
        }
        System.out.println("Total number of samples: " + trials);
        System.out.println();

        System.out.println("===== Output =====");
        Random rand = new Random();

        // input: 0.3, 0.2, 0.5
        // cumSum: 0.0, 0.3, 0.5, 1.0
        double[] cumSum = new double[n+1];
        for (int i = 1; i <= n-1; i++) {
            cumSum[i] = cumSum[i-1] + Double.valueOf(args[i]);
        }

        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < trials; i++) {
            // generate a random double [0.0, 1.0)
            double randomDoubleNumber = rand.nextDouble();

            // check which range it falls into
            int index = Arrays.binarySearch(cumSum, randomDoubleNumber);
            numList.add(-(index + 1));
        }

        int[] counts = new int[n];
        for (int num : numList) {
            counts[num]++;
        }

        for (int i = 1; i < counts.length; i++) {
            System.out.println(i + " is sampled " + counts[i] +" times. " + "Probability: " + (double)counts[i]/trials);
        }
    }
}

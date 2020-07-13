package Sort_Algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    /*  Time Complexity: O(n) - if only one item per bucket
        Not In-place Algorithm
        Stable Sort in ideal situation
     */
    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
//            buckets[i] = new ArrayList<>();
            buckets[i] = new LinkedList<>();
        }

        // Scattering phase
        for (int value : input) {
            buckets[hash(value)].add(value);
        }

        // Sort each bucket
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        // Gathering phase
        // Traverse each bucket list in buckets and each value in the bucket
        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                input[i++] = value;
            }
        }
    }

    private static int hash(int value) {
        return value / 10;
    }
}

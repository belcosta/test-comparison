package com.example.testcomparison.Utils;

public final class TestUtils {
    public static void calculateTestDuration(long start){
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("###########################Test duration: "+duration +" nanoseconds");
    }
}

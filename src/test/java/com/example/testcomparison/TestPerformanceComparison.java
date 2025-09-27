package com.example.testcomparison;

import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestPerformanceComparison {

    public static void main(String[] args) {
        int repetitions = 1000;

        // Measure time for JUnit tests
        List<Long> junitTimes = measureTestExecutionTime("com.example.testcomparison.infrastructure.api.BedSheetControllerJUnitTest", repetitions);

        // Measure time for Spring tests
        List<Long> springTimes = measureTestExecutionTime("com.example.testcomparison.infrastructure.api.BedSheetControllerSpringTest", repetitions);

        // Calculate and print statistics
        System.out.println("JUnit Test Times:");
        printStatistics(junitTimes);

        System.out.println("Spring Test Times:");
        printStatistics(springTimes);
    }

    private static List<Long> measureTestExecutionTime(String testClassName, int repetitions) {
        List<Long> times = new ArrayList<>();
        for (int i = 0; i < repetitions; i++) {
            long start = System.nanoTime();

            LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(selectClass(testClassName))
                    .build();
            LauncherFactory.create().execute(request);

            long end = System.nanoTime();
            times.add(end - start);
        }
        return times;
    }

    private static void printStatistics(List<Long> times) {
        double mean = times.stream().mapToLong(Long::longValue).average().orElse(0.0);
        double variance = times.stream().mapToDouble(time -> Math.pow(time - mean, 2)).sum() / times.size();
        double stdDev = Math.sqrt(variance);

        System.out.printf("Mean: %.2f ns, Std Dev: %.2f ns%n", mean, stdDev);
    }
}

package io.graphite.benchmark;

/**
 * Computes statistical metrics for benchmark executions.
 *
 * <p>This class aggregates timing measurements and calculates summary
 * statistics including average, minimum, maximum, and standard deviation.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see io.graphite.result.BenchmarkResult
 * @see BenchmarkRunner
 * @since 2.0
 */
public final class BenchmarkStatistics {

    private BenchmarkStatistics() {
    }

    public static double average(double[] values) {

        double sum = 0;

        for (double value : values) {
            sum += value;
        }

        return sum / values.length;
    }

    public static double minimum(double[] values) {

        double minimum = Double.MAX_VALUE;

        for (double value : values) {
            if (value < minimum) {
                minimum = value;
            }
        }

        return minimum;
    }

    public static double maximum(double[] values) {

        double maximum = Double.MIN_VALUE;

        for (double value : values) {
            if (value > maximum) {
                maximum = value;
            }
        }

        return maximum;
    }

    public static double standardDeviation(double[] values) {

        double average = average(values);

        double sum = 0;

        for (double value : values) {

            double difference = value - average;

            sum += difference * difference;
        }

        return Math.sqrt(sum / values.length);
    }
}

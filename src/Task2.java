import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Task2 {

    public static void main(String[] args) {
        System.out.println("Task 2:");
        long task2StartTime = System.currentTimeMillis();

        CompletableFuture<double[]> sequenceFuture = CompletableFuture.supplyAsync(() -> {
            long start = System.currentTimeMillis();
            double[] sequence = new Random().doubles(20, 1, 100).toArray();
            System.out.println("Generated sequence: " + Arrays.toString(sequence));
            System.out.println("Generated in: " + (System.currentTimeMillis() - start) + " ms");
            return sequence;
        });

        CompletableFuture<Double> resultFuture = sequenceFuture.thenApplyAsync(sequence -> {
            long start = System.currentTimeMillis();
            double result = 1.0;
            for (int i = 1; i < sequence.length; i++) {
                result *= (sequence[i] - sequence[i - 1]);
            }
            System.out.println("Calculated result: " + result);
            System.out.println("Calculated in: " + (System.currentTimeMillis() - start) + " ms");
            return result;
        });

        resultFuture.thenAcceptAsync(result -> {
            long start = System.currentTimeMillis();
            System.out.println("Final result: " + result);
            System.out.println("Result output in: " + (System.currentTimeMillis() - start) + " ms");
        }).thenRunAsync(() -> {
            long task2EndTime = System.currentTimeMillis();
            System.out.println("Total time for Task 2: " + (task2EndTime - task2StartTime) + " ms");
        });

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Task 1:");
        long task1StartTime = System.currentTimeMillis();

        CompletableFuture<int[]> initialArrayFuture = CompletableFuture.supplyAsync(() -> {
            long start = System.currentTimeMillis();
            int[] array = new Random().ints(10, 1, 100).toArray();
            System.out.println("Initial array: " + Arrays.toString(array));
            System.out.println("Generated in: " + (System.currentTimeMillis() - start) + " ms");
            return array;
        });

        CompletableFuture<double[]> modifiedArrayFuture = initialArrayFuture.thenApplyAsync(array -> {
            long start = System.currentTimeMillis();
            int[] addedArray = Arrays.stream(array).map(x -> x + 10).toArray();
            double[] dividedArray = Arrays.stream(addedArray).mapToDouble(x -> x / 2.0).toArray();
            System.out.println("Modified array (added 10 and divided by 2): " + Arrays.toString(dividedArray));
            System.out.println("Modified in: " + (System.currentTimeMillis() - start) + " ms");
            return dividedArray;
        });

        modifiedArrayFuture.thenAcceptAsync(array -> {
            long start = System.currentTimeMillis();
            System.out.println("Result array: " + Arrays.toString(array));
            System.out.println("Result output in: " + (System.currentTimeMillis() - start) + " ms");
        }).thenRunAsync(() -> {
            long task1EndTime = System.currentTimeMillis();
            System.out.println("Total time for Task 1: " + (task1EndTime - task1StartTime) + " ms\n");
        });

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
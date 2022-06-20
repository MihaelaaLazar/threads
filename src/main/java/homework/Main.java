package homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);
        Integer result = 0;
        for (int i = 1; i <= 10; i++) {
            try {
                Divisor divisor = new Divisor(i);
                Future<Integer> futureResult =  es.submit(divisor);
                    result = futureResult.get();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
    }
}

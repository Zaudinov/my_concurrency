package basic;

import java.util.concurrent.*;

public class ExecutorAndFuture2 {
//  Changing the number of threads greatly affect the computation time
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        long before = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            executor.submit(new Task());
        }

        System.out.println("we can make unrelated task in main");
        System.out.println("while executor is working");
        for (int i = 0; i < 1000; i++) {
            System.out.println(Math.random()+Math.random()*Math.random() + "from main");
        }

        executor.shutdown();
        executor.awaitTermination(100,TimeUnit.SECONDS);
        long after = System.currentTimeMillis();
        long time = after-before;
        System.out.println("why " + time);
    }


}
class Task implements Callable<Long>{

//    This is just some dumb CPU-intensive calculation.
    @Override
    public Long call() throws Exception {
        System.out.println("calculation has stared" +"Thread name: " + Thread.currentThread().getName());
        long res = 0;
        for (int i = 0; i < 1000000000; i++) {
            res += i/1000;
        }
        System.out.println(res);
        return res;
    }
}

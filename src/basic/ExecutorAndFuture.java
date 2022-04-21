package basic;

import java.util.concurrent.*;

public class ExecutorAndFuture {

//    get() blocks the execution until the task is complete.
//    We can check first if the task is complete by calling isDone().
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> f = executor.submit(()->{
            return 2+2;
        });
        while(!f.isDone()){
            System.out.println("It's not done yet");
        }
        try {
            System.out.println(f.get(1, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

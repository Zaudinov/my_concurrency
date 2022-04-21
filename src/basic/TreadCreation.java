package basic;

import java.util.concurrent.Callable;

public class TreadCreation {

    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable(), "RunnableTread");
        MyCallable t3 = new MyCallable("World");

        t1.start();
        t2.start();
        System.out.println(t3.call());
//        Повторный запуск выбросит IllegalThreadStateException
//        t1.start();
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("This is MyThread class.");
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("This is MyRunnable class.");
    }
}

class MyCallable implements Callable<String>{
    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return "Hello from MyCallable class, " + name + "!";
    }
}

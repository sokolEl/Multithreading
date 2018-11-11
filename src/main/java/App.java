import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(9);

        BlockingQueue<Integer> storeService = new PriorityBlockingQueue<>();

        executorService.submit(new Producer(storeService));
        executorService.submit(new Producer(storeService));
        executorService.submit(new Producer(storeService));
        executorService.submit(new Producer(storeService));
        executorService.submit(new Producer(storeService));
        executorService.submit(new Producer(storeService));
        executorService.submit(new Producer(storeService));

        Future <Boolean> counter1= executorService.submit(new Consumer(storeService));
        Future<Boolean> counter2 = executorService.submit(new Consumer(storeService));

        while (true) {
            if (counter1.isDone()) {
                executorService.shutdownNow();
                System.out.println("Consumer 1 - Win");

                break;
            }
            if (counter2.isDone()){
                executorService.shutdownNow();
                System.out.println("Consumer 2 - Win");

                break;
            }

        }

    }
}

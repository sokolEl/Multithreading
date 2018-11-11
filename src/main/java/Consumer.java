import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer implements Callable<Boolean> {

    private int count;
    private final BlockingQueue<Integer> storeService;

    public Consumer(BlockingQueue<Integer> storeService) {
        this.count = 0;
        this.storeService = storeService;
    }


    @Override
    public Boolean call() throws Exception {
        while (count < 100) {
            count += storeService.take();
            System.out.println(Thread.currentThread().getName() + ": " + count);

        }
        return true;
    }
}

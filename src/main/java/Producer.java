import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable  {

    private final BlockingQueue<Integer> storeService;


    public Producer(BlockingQueue<Integer> storeService) {
        this.storeService = storeService;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                int value = new Random().nextInt(5) + 1;
                storeService.add(value);

                Thread.sleep(100L);
            }

            catch (InterruptedException e) {
                break;
            }
        }
    }
}

package MultithreadBankModel;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 25.10.13
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(100, 10000);
        TransferRunnable randTransfer = new TransferRunnable(bank);
        CounterThread counter = new CounterThread(bank);
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(randTransfer);
        }
        Thread balanceThread = new Thread(counter);

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        balanceThread.setDaemon(true);
        balanceThread.start();

    }
}

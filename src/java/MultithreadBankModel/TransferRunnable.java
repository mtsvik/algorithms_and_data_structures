package MultithreadBankModel;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 25.10.13
 */
public class TransferRunnable implements Runnable {
    private int latency;
    private Bank bank;

    public TransferRunnable(Bank bank) {
        this.bank = bank;
        this.latency = 10;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bank.randomTransfer();
                Thread.sleep(latency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

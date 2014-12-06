package MultithreadBankModel;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 25.10.13
 */
public class CounterThread implements Runnable {
    private int latency;
    private Bank bank;

    public CounterThread(Bank bank) {
        this.latency = 1000;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(bank.getTotalAmount());
                Thread.sleep(latency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package MultithreadBankModel;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 25.10.13
 */
public class Bank {
    private final Object lock = new Object();
    private Account[] accounts;

    public Bank(int numbersOfAcc, int startBalance) {
        this.accounts = new Account[numbersOfAcc];
        for (int i = 0; i < accounts.length; i++) accounts[i] = new Account(startBalance);
    }

    public void randomTransfer() {
        synchronized (lock) {
            int randSumm = 1 + (int) (Math.random() * 4001);
            int summ2 = 0 - randSumm;
            int randAcc = (int) (Math.random() * (accounts.length));
            int randAcc2 = (int) (Math.random() * (accounts.length));
            accounts[randAcc].changeBalance(summ2);
            accounts[randAcc2].changeBalance(randSumm);
        }
    }

    public int getTotalAmount() {
        synchronized (lock) {
            int balanceOfBank = 0;
            for (int i = 0; i < accounts.length; i++) {
                balanceOfBank += accounts[i].getBalance();
            }
            return balanceOfBank;
        }
    }


}

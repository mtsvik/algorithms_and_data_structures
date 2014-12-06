package MultithreadBankModel;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 25.10.13
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void changeBalance(int value) {
        balance += value;
    }

    public int getBalance() {
        return balance;
    }


}

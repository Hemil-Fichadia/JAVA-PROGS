package AdapterDesignPattern.AdapterImplementation;

public interface BankAPI {
    void sendMoney(String from, String to, int amount);
    void registerAccount(String firstName, String lastName, String accountType);
    void getBalance();
}

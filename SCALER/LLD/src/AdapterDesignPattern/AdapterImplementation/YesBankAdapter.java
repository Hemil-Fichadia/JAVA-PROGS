package AdapterDesignPattern.AdapterImplementation;

public class YesBankAdapter implements BankAPI{
    YesBank yesBank = new YesBank();
    @Override
    public void sendMoney(String from, String to, int amount) {
        yesBank.transferMoney(from, to, amount);
    }

    @Override
    public void registerAccount(String firstName, String lastName, String accountType) {
        yesBank.createAccount(firstName, lastName, accountType);
    }

    @Override
    public void getBalance() {
        yesBank.getBalance();
    }
}

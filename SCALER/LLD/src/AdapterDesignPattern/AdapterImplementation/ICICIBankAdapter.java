package AdapterDesignPattern.AdapterImplementation;

public class ICICIBankAdapter implements BankAPI{
    ICICIBank iciciBank = new ICICIBank();
    @Override
    public void sendMoney(String from, String to, int amount) {
        iciciBank.makePayment(from, to, amount);
    }

    @Override
    public void registerAccount(String firstName, String lastName, String accountType) {
        iciciBank.generateAccount(firstName, lastName, accountType);
    }

    @Override
    public void getBalance() {
        iciciBank.fetchBalance();
    }
}

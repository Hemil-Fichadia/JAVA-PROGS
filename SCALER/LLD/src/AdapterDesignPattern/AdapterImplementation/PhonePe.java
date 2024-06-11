package AdapterDesignPattern.AdapterImplementation;

public class PhonePe {
    private static BankAPI bankingPartner = new ICICIBankAdapter();

    public static void main(String[] args){
        bankingPartner.sendMoney("Hemil", "Deepak", 10000);
        bankingPartner.getBalance();
    }
}

package AdapterDesignPattern.AdapterImplementation;

public class ICICIBank {
    public void makePayment(String from, String to, int amount){
        System.out.println("Transferring money via ICICI Bank");
    }
    public void generateAccount(String firstName, String lastName, String accountType){
        System.out.println("Account created for "+ firstName + " " + lastName + "of type " + accountType);
    }

    public void fetchBalance(){
        System.out.println("Account balance is : 10,00,00,000");
    }
}

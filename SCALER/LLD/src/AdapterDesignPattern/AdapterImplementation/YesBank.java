package AdapterDesignPattern.AdapterImplementation;

public class YesBank {
    public void transferMoney(String to, String from, int amount){
        System.out.println("Transferring money via YES Bank");
    }

    public void createAccount(String firstName, String lastName, String accountType){
        System.out.println("Account created for "+ firstName + " " + lastName + "of type " + accountType);
    }

    public void getBalance(){
        System.out.println("Account balance is : 10,00,00,000");
    }
}

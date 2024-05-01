package Inheritance;

public class User {

    User(){
        System.out.println("User constructor");
    }
    String email;
    void login(String userRole){
        System.out.println(userRole+" logged in");
    }
}

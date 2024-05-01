package com.Hemil;

public class StringExample {
    public static void main(String[] args) {

        /*String messsage = greetings();
        System.out.println(messsage);*/

        String personalised = myGreet("Hemil");
        System.out.println(personalised);
    }

    private static String myGreet(String name) {
        String message = "Hello "+ name;
        return message;
    }

    static String greetings()
    {
        String greet = "How are you?";
        return greet;
    }
}

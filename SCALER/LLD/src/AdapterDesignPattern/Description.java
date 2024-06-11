package AdapterDesignPattern;

public class Description {
    public static void main(String[] args){
        /* Case study of PhonePe
        PhonePe used to have YesBank as their payment partner and one fine day YesBank went bankrupt
        and all of their banking systems were shutdown and now PhonePe needed to work with some
        other bank partner, so they switched to ICICI bank but this switch was made in just one
        day due to their fast pace and reliable decision of using adapter design pattern  while
        talking to 3rd party systems.

        Adapter design pattern is a structural design pattern

        Structural design pattern :-
        How to structure our codebase, what all classes should be there ?
        What all the attributes should be there inside a class ?
        How different classes should interact with each other ?

        Adapter design pattern :-
        Adapter is an intermediary layer that is responsible for connecting ports with different
        configurations or transforms one form to another.
        So adapter makes third party components compatible with our system.

        Problem statement :-
        1) We might have a use-case of migrating from one third party integration to another
        third party integration.

        2) Third party systems that we are using in our code may go under maintenance, and we
        need to switch to some other option.

        So adapter design pattern ensures that our codebase remains maintainable when we are using
        some 3rd party systems as our system is not directly dealing with 3rd party system and this
        ensures loose coupling.

        Whenever our system is talking to a 3rd party system then we should use an interface in
        between in order ensure loose coupling which will make our code base maintainable.

        If we consider the case of PhonePe, while communicating with YesBank PhonePe should use an
        interface with name <<BankAPI>>.

        How to use adapter ?
        1) Whenever we are connecting with any 3rd party API create an interface with the methods
        that we need from 3rd party.

        So PhonePe created an interface <<BankAPI>> with some methods like
        <<BankAPI>> {
            double checkBalance(String account);
            void sendMoney(Account from, Account to);
        }
        so this interface is created by PhonePe, and it is the owner of it, but who will implement it
        now ? the probable candidate is YesBank itself, but will YesBank implement all these ? like
        they will have their own system to process all kind of operations but for PhonePe, it becomes next
        to impossible to implement all these operations for PhonePe in this way they need to do the
        similar process again for GooglePay or Paytm and this will completely disrupt their working
        system.

        Now every bank would have same functionalities but there would be some variations in the name
        of methods like transferMoney(Account to, Account from) so the sequence of parameters are varying
        like wise and most of the functionalities is same across the banking services.

        PhonePe cannot perform any of the banking operations independently, so they need support
        of some bank, and so the best thing they can implement is add a bank specific class in
        between like YesBankAdapter class and this class will be tightly coupled with YesBank and
        if there is a switch required to be made to other bank then implement new adapter class like
        ICICIAdapter class, so just switch to adapter class of that bank.

        So 3rd party system will not implement this <<BankAPI>> interface the system that is using
        the 3rd party API will implement this using a wrapper class in between. 

        */
    }
}

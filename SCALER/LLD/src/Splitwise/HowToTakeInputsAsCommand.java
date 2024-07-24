package Splitwise;

public class HowToTakeInputsAsCommand {
    public static void main(String[] args){
        /* How to take inputs via command line ?
        Here in this application, we are expecting commands via command line like this,
        1) Register name phone number password
        2) username "update" profile
        3) username "AddGroup" Roommates
        4) username "AddMember" GroupName userToBeAdded
        5) username "History"
        6) username "SettleUp" GroupName
        and a lot more.
        The words wrapped in " " are commands.
        So actually there is no limit in this kind of commands, so we have to make it optimise it
        using some good design principle.
        
        Now we are going to accept any number of commands that user wants to input and
        that too with any number of parameters, so for that we will use Scanner and
        an infinite while loop and that code will be present in the client side which is
        responsible to accept commands, but it will create more chaos in the client side
        itself due to, too many if else conditions inside client side it will break Single
        responsibility and Open Closed principle, so we need to figure out some way to make it
        more smooth to be handled.

        Try to observe some minute behaviours of commands, all commands will similar functionality
        to be first matched with the given input and execute accordingly, this shows their common
        behaviour of being a command, so it is clear they exhibit a common property of being
        matched and get executed, and we have a way to bind them by making them implement
        <<Command>> interface with two methods, match and execute.

        The match method in each command is to match itself with given input, if it matches,
        then it is executed. As all the commands are now under a same interface, their object
        can be stored in List<Command> and when an input is given, we can simply iterate and
        match it with the given input, if it matches then execute it.

        Everything seems fine, but now the client class is taking more responsibility, so we
        should create a separate class called CommandExecutor and add that for loop of iterating
        over the list of command into it.
        */
    }
}

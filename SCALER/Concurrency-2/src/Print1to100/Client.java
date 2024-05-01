package Print1to100;

public class Client {
    public static void main(String[] args){
        /*Here we are printing 1 to 100 each number with a separate thread,
        so have created a Print1to100.NumberPrinter class whose task is to print the given
        number, so simply we are iterating from 1 to 100 using a for loop and
        passing i to Print1to100.NumberPrinter constructor and executing each with new thread
        so after running this task we can clearly observe that there is no order
        in execution of numbers any thread can execute any of the given number.
        Here the task of client is to create a task, create a thread, assign task to thread,
        run the thread, so let's say we are building an Amazon server that is expected to be
        receiving 1 million requests so if we are creating a separate thread for each of the
        client's request then there will be no waiting time for any of the user to get response
        but at the end of the day a thread is an object of a class, so apparently it will impact
        the performance of the server.
        From this task, we can get the idea that even if we are making our program fast as
        possible, but eventually it will end up using the space of whole server and might
        crash it, so a better idea is to reuse an idle thread that and assign the task to
        it.
        For this problem, Executors comes as a helping hand.
        * */
        for(int i = 1; i <= 100; i++){
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread thread = new Thread(numberPrinter);
            thread.start();
        }
    }
}

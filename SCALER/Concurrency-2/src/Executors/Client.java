package Executors;

public class Client {
    public static void main(String[] args){
        /* Here we will divide the responsibilities into two parts
        Client :-
        client knows about the task and task should be executed on a separate
        thread
        Executor :-
        executor knows how to run a task on a separate thread this collectively makes
        an Executor framework.

        The executor internally uses a thread pool understand it like this
        Let's say we have a car factory with 10 production lines that means we can
        produce 10 cars in parallel, and they have a high priority order of 1000 cars to
        be delivered as soon as possible so if they just keep on setting up new factories
        each with 10 production lines then they can meet the target quickly but this is not
        an efficient way to achieve it, but instead, they can reuse an existing car
        production line, so we need to monitor which thread is free to assign task, so this
        is the executor
        * */
    }
}

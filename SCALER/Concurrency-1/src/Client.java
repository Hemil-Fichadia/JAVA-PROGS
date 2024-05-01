public class Client {

    public static void main(String[] args){
        /* This gives us the name of thread that is executing the task
        of printing Hello world.
        * */
        System.out.println("Hello world printed by "+Thread.currentThread().getName());
    }
}

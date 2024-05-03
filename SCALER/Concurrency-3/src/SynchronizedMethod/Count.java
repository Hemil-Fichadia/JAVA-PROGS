package SynchronizedMethod;

public class Count {
    private int value;

    public Count(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    /* As count is providing some methods that are to be used in multithreading environment
    then that method needs to be synchronized.
    * */
    public synchronized void modifyValue(int x){
        this.value += x;
    }
}

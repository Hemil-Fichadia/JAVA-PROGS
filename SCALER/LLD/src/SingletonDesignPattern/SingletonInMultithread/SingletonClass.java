package SingletonDesignPattern.SingletonInMultithread;

public class SingletonClass {
    public static SingletonClass instance;

    private SingletonClass(){

    }
    /* This is thread safe means it is safe in multithreaded environment.
    * */
    public static SingletonClass getInstance(){
        if(instance == null){
            synchronized(SingletonClass.class){
                if(instance == null){
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}

package SingletonDesignPattern;

public class SingletonClass {
    public static SingletonClass instance;

    private SingletonClass(){

    }
    public static SingletonClass getInstance(){
        if(instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }

    public void printInfo(){
        System.out.println("Singleton class");
    }

    public static void main(String[] args){
        /* Here still we are able to create the new instance manually as we have called the object
        from public static void main from inside the class, so we are able to access the private
        method, to test it, create object of this class in SingletonImplementation.
        * */
        SingletonClass singletonClass = new SingletonClass();
        singletonClass.printInfo();
    }
}

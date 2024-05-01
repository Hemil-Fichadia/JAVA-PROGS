package StaticAndFinal;

public class Demo {
    static void fun(){
        System.out.println("Accessing static class methods");
    }

    public static void main(String[] args){
        /* We can access this fun method without creating any
        object just directly.
        */
        Demo.fun();
    }
}

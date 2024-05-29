package SingletonDesignPattern;

public class EagerLoading {
    /* Here we are creating the object right at the time of compilation, as the variables
    of the static types are initialized at compile time and so the object will also get
    initialized, so even if getInstance method is not called, the object is created that's
    why it's called EagerLoading.

    Similarly Lazy Loading is the exact opposite thing where object is created when the getInstance
    method is called.

    If we have significant amount of such static variables, then application startup time increases.
    * */
    public static EagerLoading eagerLoading = new EagerLoading();
    private EagerLoading(){

    }

    public static EagerLoading getInstance(){
        return eagerLoading;
    }
}

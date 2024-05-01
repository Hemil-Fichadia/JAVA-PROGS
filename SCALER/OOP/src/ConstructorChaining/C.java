package ConstructorChaining;

public class C extends B{
    C(){
        System.out.println("C's constructor");
    }
    C(String value){
        System.out.println(value);
    }
}

package CompareToUseCase;

public class Car implements Comparable<Car>{
    /* This Comparable interface is just as Custom comparator, but the simple difference is
    that in Comparator interface we have need to create a separate class and then make it implement
    Comparator interface and Override compare method which have a return type as integer, so
    we need to compare two objects based on a parameter and on basis of it, compare method will
    return either 1, 0 or -1, similarly, here we just need to make the class implement Comparable
    and then Override compareTo method which will also return +1, 0 or -1 and if we want to make
    it sort the data in descending then just reverse the operands positions, the reason for its
    simplicity is, if the result is negative that means the object in the first should come first
    if 0 then no need, if positive means this object should come second compared to current object.
    * */
    String name;
    int price;
    int speed;

    public Car(String name, int price, int speed){
        this.name = name;
        this.price = price;
        this.speed = speed;
    }


    @Override
    public int compareTo(Car other) {
        //This is in ascending order
        return this.speed - other.speed;
        //Just toggle the above expression to make it descending
        //return other.speed - this.speed;
    }
    /* We learnt in the DSA class that a class contains two built-in methods
    HashCode and toString so here we have override that toString method to
    make it print the attributes of object in a readable pattern.
    * */
    @Override
    public String toString() {
        return "[Name = " + this.name + ", Speed = " + this.speed + ", Price = " + this.price + " ]";
    }
}

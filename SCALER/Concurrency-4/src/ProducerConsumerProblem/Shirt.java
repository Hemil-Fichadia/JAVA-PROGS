package ProducerConsumerProblem;

public class Shirt {
    private int id;
     Shirt(){
         this.id = (int)((Math.random() * Integer.MAX_VALUE ) + 1);
     }

     public int getId(){
         return id;
     }
}

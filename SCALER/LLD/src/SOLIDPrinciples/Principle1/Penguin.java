package SOLIDPrinciples.Principle1;

public class Penguin extends Bird{

    public void fly(){
        throw new IllegalStateException("Penguin cannot fly");
    }

    public static void main(String[] args){
        Bird bird = new Penguin();
        bird.fly();
    }
}

package SOLIDPrinciples.Principle1;

public class Pigeon extends Bird {

    @Override
    public void fly() {
        System.out.println("Pigeon flew");
    }

    public static void main(String[] args){
        Bird bird = new Pigeon();
        bird.fly();
    }
}

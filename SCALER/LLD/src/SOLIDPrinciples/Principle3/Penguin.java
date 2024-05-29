package SOLIDPrinciples.Principle3;

public class Penguin extends Bird implements dances{

    @Override
    public void dance() {
        System.out.println("Penguin is dancing");
    }
}

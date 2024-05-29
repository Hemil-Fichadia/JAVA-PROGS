package SOLIDPrinciples.Principle3;

import java.util.ArrayList;
import java.util.List;

public class Pigeon extends Bird implements flyable, dances{

    @Override
    public void dance() {
        System.out.println("Pigeon is dancing");
    }

    @Override
    public void fly() {
        System.out.println("Pigeon flew");
    }

    public static void main(String[] args){
        Pigeon pigeon = new Pigeon();
        /* Now we can store objects of child in List of parent reference Bird.
        And we can also store birds with specific behaviour in a list of birds with
        specific behaviour.
        * */
        List<Bird> birdsList = new ArrayList<>();
        birdsList.add(pigeon);

        List<flyable> birdsThatCanFly = new ArrayList<>();
        birdsThatCanFly.add(pigeon);
    }
}

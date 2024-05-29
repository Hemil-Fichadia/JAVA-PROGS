package SOLIDPrinciples.Principle1;

public class Bird {
    String name;
    int age;
    int weight;
    String color;
    double wingsDiameter;

    Breed breed;
    public void fly(){
        if(breed.name.equals("pigeon")){
            //do something
        }
        else if(breed.name.equals("peacock")){
            //do something
        }
        /*
        .
        .
        .
        .
        .
        .
        .
        */
        else{
            //do nothing
        }
    }
}

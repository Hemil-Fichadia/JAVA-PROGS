package StrategyDesignPattern;

public class Description {
    public static void main(String[] args){
        /* Strategy is a behavioural design pattern.
        Behavioural means action/method centric or how to implement methods in our codebase.

        Let's consider a use-case for it, in Google Maps when we select current location and destination
        to reach then we go for directions and just after that we have some options in front of us
        with estimated time to reach destination and that varies with the mode of transport we choose
        like by walk, by cycle, by bike and by train, so this is effective as there can be some narrow
        roads that can only be crossed by taking a walk or by a cycle, in this case if someone is
        travelling by car so maps can search for some alternate route for destination.

        Let's say we have main google maps class that calculate distance
        GoogleMaps{
            Distance findDistance(source, destination, modeOfTransport){
                if(modeOfTransport.equals("walk")){
                    // Walk and cover distance
                }
                else if(modeOfTransport.equals("cycle")){
                    // Find the shortest distance even if the road is narrow
                }
                else if(modeOfTransport.equals("bike")){
                    // ride bike with medium to broad roads
                }
                else {
                    // drive car and search for alternate way if the road is narrow
                }
            }
            this violates OCP and SRP as findPath is handling for all kind of mode of transport
            and all those ways are independent of each other, so they are supposed to be present
            inside their separate class.
            ------------------------------------------------------------------------------------
            Strategy Design pattern :-
            The tagline for using strategy design pattern is when we have multiple ways of doing
            something this is the use-case of strategy design pattern.

            When we have multiple ways of doing something, then instead of implementing all of
            them in a single method, each implementation should go to a separate class.

            Okay in that way, make separate classes for all methods like
            CarPathCalculator,
            BikePathCalculator
            WalkPathCalculator
            and implement the find path method in all of them accordingly, but in this
            way all those classes have become quite independent, so we need to access them with separate
            objects and if GoogleMaps class need to use these methods then it will directly depend on
            one of these classes which will again violate SRP and OCP, so all of them should be accessed via
            an interface named PathCalculator in between which will make sure that none of the class
            are dependent on each other directly.

            Now when those classes will implement pathCalculator method from interface, then it will only
            require two parameters namely source and destination as modeOfTransport itself is handled
            with separate class. So GoogleMaps class will receive some parameter of modeOfTransport,
            and then we need to check with if conditions like which mode it is and then return the object
            but that will also break OCP and SRP principles, so we need something that can return object
            according to the parameter, and that's factory, so we have to create factory design pattern
            for this PathCalculator interface and set the object for that class according a parameter,
            and will move all the if conditions inside factory class of PathCalculatorFactoryFactory.

            Inside GoogleMaps class

            GoogleMaps{

                findPath(source, destination, mode){
                    PathCalculator pathCalculator = PathCalculatorFactory.getPathCalculator(mode);
                }
            }

        }
        * */
    }
}

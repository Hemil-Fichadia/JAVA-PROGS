package DecoratorDesignPattern;

public class Description {
    public static void main(String[] args){
        /*
        Decorator design pattern :-
        Can we consider only a single or multiple cones stacked as an IceCream ? yes it is for kids who just
        like crunching on different flavours of cones, now observe it from a different perspective, we had
        an IceCream right from start when we selected a cone and on top of it we further added some more
        ingredients and this is able possible after an IceCream object is created and at runtime we
        are allowing customer to decorate the IceCream accordingly. So whenever we add an ingredient,
        the cost and description will change.
        Assumption :- IceCream cannot exist without cone, cone is mandatory for building an IceCream.

        Unlike other design patterns until now, this not that intuitive, so follow these steps to
        visualise it.
        1) Define an interface/ Abstract class that represents the entity that we are building.
        So that will be <<IceCream>> interface with two methods getCost() and getDescription()
        interface{
            int getCost();
            void getDescription();
        }

        2) There are two types of ingredients that we have here
            1) Base addon :-
            All kind of cones are base addon
            2) Topping addon :-
            Rest of the ingredients are topping addon
        For each of these ingredients create classes and make them implement IceCream interface.
        From here we will observe the real meaning of decorator design pattern

        Every class like OrangeCone, ChocolateCone, StrawberryCone, ChocolateSyrup, OrangeScoop,
        ChocolateCone, etc. Now, can we start building an IceCream from chocolate scoop itself ?
        No, and that's what we are going to address here.

        If we have a base addon like an OrangeCone, then the getCost() and getDescription() will return
        its cost and description. Now when we add the Topping addon we will be having some Base addon
        to add a scoop on top of it. So this time when we will fetch the cost or description of an
        IceCream after an addon, the cost will be cost of existing IceCream  + cost of current addon
        and similarly with description will be description of existing IceCream + description of current
        addon.

        Now we have restriction on building an IceCream without a base addon, so first we will select a
        base addon and then will move to further addons, how will we achieve this, is explained in
        further process.

        All the ingredients will implement IceCream interface, the base addon will implement it in this
        way
        class OrangeCone{
            int getCost(){
                return 10;
            }
            String getDescription(){
                return "Orange cone";
            }
        }
        We want to make the further addons or dependent addons restricted to be added only if some IceCream
        exists, so we will make the Chocolate scoop class's constructor parameterized that accepts
        IceCream object so now this class will something look like

        class ChocolateCone{
            IceCream iceCream;
            ChocolateCone(IceCream iceCream){
                this.iceCream = iceCream;
            }
            int getCost(){
                return iceCream.getCost() + 30;
            }

            String getDescription(){
                return iceCream.getDescription() + "ChocolateCone";
            }
        }
        So the base addon will be having default constructor and topping addons will have parameterized
        constructor, now let's build a demo IceCream
        IceCream iceCream = new OrangeCone();
        iceCream = new ChocolateCone(iceCream);
        iceCream = new StrawberryScoop(iceCream);
        iceCream = new BlueberryScoop(iceCream);
        iceCream = new Cheery(iceCream);

        Let's have a fancy way of writing above object declaration
        IceCream iceCream = new Cherry(
                new BlueberryScoop(
                        new StrawberryScoop(
                            new ChocolateCone(
                                new OrangeCone()
                            )
                        )
                    )
                );
        Now let's observe the benefit of this approach, if we do iceCream.getCost() then cherry's getCost() will
        be triggered and then cherry will call BlueberryScoop's getCost() method then it will trigger its inner
        object's getCost() method and finally when it reaches the base addon from there it will start
        returning the actual cost and will be added at each step of function call.

        Decorator design pattern :-
        If we have an entity to which we want to add behaviours/entities at runtime, then consider
        using decorator design pattern.

        After all such arrangements there is a small design flaw here, if we add a cone on top of one
        existing one then here cone is acting like a base as well as a topping addon so for supporting
        this functionality, we should include default as well as parameterized constructors, so the cones
        classes will have one parameterized constructor that accepts an IceCream object so on basis of
        that if cone object is called with some existing IceCream then it will count cost accordingly
        and if called as a normal object then it will act like a base.

        class OrangeCone{
            IceCream iceCream;
            OrangeCone(){

            }
            OrangeCone(IceCream iceCream){
                this.iceCream = iceCream;
            }

            int getCost(){
                if(iceCream != null){
                    return iceCream.getCost() + 10;
                }
                return 10;
            }
            String getDescription(){
                if(iceCream != null){
                    return iceCream.getDescription() + "Orange cone";
                }
                return "Orange cone"
            }
        }
        So when an entity can act as both base as well normal, then it should support both of the
        constructors default and parameterized.

        Related Problem statements :-
        Design Pizza vending machine

        SpringBoot application also uses this kind of decorator design pattern for its annotation
        as, until we don't assign @SpringBootApplication, none of the annotations like @RestController
        and @Configuration, are supported by SpringBoot application, until the base annotation
        @SpringBootApplication is added to the project's main file.
        So this shows that the decorator design pattern have a variety of use-cases.

        * */
    }
}

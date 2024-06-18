package DecoratorDesignPattern;

public class ProblemStatement {
    public static void main(String[] args){
        /* Decorator design pattern
        Let's say we are building an IceCream ordering system, not the one which have only some options
        on ChocoBar or a cone, it's about a custom IceCream provider where you can select a type of
        cone and add some flavour of syrup and over it add as many number of scoops of IceCream one
        wishes to, So we want to build an application that takes an order of an IceCream and also able
        to deliver no matter how customized it is.

        This application must be able to do these things :-
        1) Build an IceCream
        2) Cost of the IceCream
        3) Description of the IceCream

        The cost is going to be the addition of cost of all the ingredients in it, and description is
        for the person who will receive this order and build this IceCream like this IceCream contains
        an Orange cone, a Chocolate cone, a strawberry syrup, a chocolate scoop, a strawberry scoop
        and then a butter scotch scoop.

        In order to build such a system that support this kind of operations, what would be the first
        set of action ? Here mainly we have two kind of ingredients, one is cone itself and other is
        IceCream scoop, so simply we can have two interfaces,
        <<Cone>> and <<Topping>>,
        so all the types of cones like Chocolate cone, Orange cone will implement this <<Cone>> interface
        and will be supporting two actions
        getCost() which will return the cost of that cone and
        getDescription() will return the description of that cone like Chocolate cone or Orange cone,
        and similar will be the case with <<Topping>> like each kind of scoops like Chocolate scoop,
        Orange scoop, ButterScotch scoop, CottonCandy scoop etc. and they will also have same set of
        actions like getCost() it will return the cost of that topping and getDescription() will return
        the description of it like Orange scoop, Chocolate scoop, Cherry, Choco syrup etc.
        So these all kind of toppings will implement <<Topping>> interface.

        There will be an IceCream class which will store all these ingredients in List<Cone> and
        List<Topping> and getCost() method will iterate over the list of both and will return the
        cost.
        IceCream{
            List<Cone> cones;
            List<Topping> toppings;
            int getCost(){
                iterate over the list of both and calculate the cost.
            }

            void getDescription{
                iterate over the list and print all the description
            }
        }

        This is some basic idea of how will be build this ice-cream, but if we have some customization
        of first Plane cone, then chocolate syrup, then strawberry cone, with toppings blueberry scoop
        following chocolate scoop following strawberry scoop and on top of it, a cherry, now when we
        print the description of this full ice-cream, then it will be like

        Plane cone + Strawberry cone + chocolate syrup + BlueBerry scoop + Chocolate scoop + Strawberry scoop
        The point of observation here is that the sequence of the ingredients is compromised in this
        approach and the matter is not even about the sequence, the flow of object creation of ice-cream
        should be in such a way that each ingredient aligns in its respective precedence.
        Now the person will prepare ice-cream according to the description and the final ice-cream
        will not according to the customer's requirement and this can create problems for the company.

        Here we also have another approach, like we can combine all the ingredients under one common
        interface named as <<Ingredients>> and let all the ingredients implement this interface and this
        interface will have only two methods getCost() and getDescription() and all those classes will
        implement that method on their own way.

        Now in the IceCream class will only have one List and two methods, and here we can also think of
        maintaining sequence of the ingredients as they will be stored in sequence.
        class IceCream{
            List<Ingredients> ingredients;
            int getCost(){
                // Iterate on list and calculate
            }
            void getDescription(){
                //Iterate on list and print all the ingredients
            }
        }
        The sequence is not the only concern here, like there is no authentication like stuff for keeping
        an ingredient at its allotted position like in this case even a scoop can occur before cone itself
        and there is no way to change it and even if its changed then there is nothing that restricts this
        kind of action, so we need something that ensures the precedence of ingredients like cones can
        exist independently in our custom IceCreams but a scoop cannot as we are not selling cups.
        */
    }
}

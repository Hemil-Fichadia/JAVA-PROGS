package SOLIDPrinciples.Principle1;

public class S {
    /* S -> Single Responsibility principle
    Let's say we want to implement the logic of that fly method in bird class, we know that there
    are many types of birds like sparrow, peacock, owl, emu, ostrich etc, and some birds are
    not able to fly, so we take on the implementation with the conventional way of using if else if
    and else conditions like this

    public void fly(){
        if(breed.name.equals("pigeon")){
            //do something
        }
        else if(breed.name.equals("peacock")){
            //do something
        }
        else if(breed.name.equals("owl")){
            //do something
        }
        .
        .
        .
        .
        else{
            do nothing
        }
    }

    so every bird fly in different way, and they have different flying behaviour like speed,
    altitude etc.

    This fly method is holing a lot more if else conditions on its own, so the problems associated with
    having too many if-else conditions is
    1) Readability is hindered
    2) Testing is tedious
    3) High chance of code duplicacy
    4) The Least code re-usability

    These all points contribute towards violation of "Single responsibility principle"

    S -> Single responsibility principle

    It states that every unit code(class/ method/ interface) should have single responsibility.
    Single responsibility means there should be only single reason to change, how it goes with our
    fly method is, if there are any related changes to any of the birds like sparrow, eagle, owl,
    peacock then in that case every time the fly method is having some behavioural changes and so
    the fly method is the least stable as it is having multiple reasons to change.

    Without applying any design principle knowledge, we can get the idea that if fly method is
    having multiple reasons to change then it is not having single responsibility, and it can be
    observed by simple parameter as it is responsible for every bird to fly.
    So every bird should have its own fly method.

    How to identify violation of Single Responsibility Principle (SRP) :-
    1) Too many if-else condition, like even if the entities are independent, still they are bind
    together, but if that if-else is the part of logic, then it is cannot be termed as violation.
    So the motto is to minimize if-else condition to an extent where entities are independent as
    well as not the part of logic, but not to completely remove the if-else.

    2) Monster method
    A method which does more than its name suggests.
    void saveToDataBase(User user){
        String query = .............
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.setUrl(----);
        dbc.setUsername(---);
        dbc.establish(---);
        dbc.execute(q);
    }
    Now wherever we want to save kind of data to database we have to rewrite these lines of code which
    creates query and establishes connection with database and this method's task is just to save to
    database.
    So this is how the save method is supposed to be like
    void saveToDatabase(User user){
        String q = createQuery();
        //so these line of code which establishes connection should be present at some
        //common place.
        //So we should not have very big methods, try to split them in order to
        encourage re-usability and reduce code duplicacy.
        DatabaseConnection dbc = getDatabaseConnection();
        dbc.executeQuery();
    }

    3)Commons / utils
    There are some methods that are not specific to any controller or a package but have a
    general use-case, so they are grouped in a package called utils, but if there are some
    other methods also that have similar general use-case and down the line 1 year or 2 year
    as the project excels, these files in util folder will just act like a cluster.
    Instead of storing them in a single package, categorize them and store them so that
    later on when we intend to use them they are arranged in a readable manner, like this
    util/StringUtil.java or util/DateUtil.java or util/DataBaseUtils.java
    */
}

package FactoryDesignPattern.FactoryMethodDesignPattern;

public class Description {

    public static void main(String[] args){
        /* FactoryMethod design pattern :-
        As the name suggests, this design pattern is related to some method related
        optimization or some extended way of access.

        In any of the service or say UserService, if we want to add, delete, update or get user from
        database we need an object of database to interact with database and query table, and we don't
        have any repository, so we have a database class inside which have a method createUser which
        is having
        UserService{
        DataBase db = _____________;
            createUser(){
                Query q = createQuery("INSERT INTO USER TABLE .........");
                db.execute(q);
            }
        }
        we have many such user methods like deleteUser, updateUser etc. So what is this DataBase, a class
        an interface or an abstract class ? if this DataBase is class then it violates the "Dependency
        Inversion" principle means no two concrete class should depend on each other and if we are currently
        using MySQL database and later on if we want to switch to any other database we cannot do that
        so this DataBase should be an interface or an abstract class so that if there is requirement of
        switch to some different database in the future.

        There is a <<DataBase>> interface is implemented by databases like MySQL, PostgresSQL and MongoDB
        and each of them can createQuery, and they all have some minor changes that means the query they
        create are not same so a createQuery() method is present inside this <<DataBase>> interface
        so this createQuery method is also present inside all the DataBases and all have their own
        logic of creating query, so they implement it in their own way, so createQuery of MySQL will
        return MySQL query, createQuery of PostgresSQL will return postgres query and so on, so this
        Query is one thing every database will return so that means this query will be of multiple types
        like MySQL' Query, MongoDB's Query, so this return type query can be an interface or an Abstract
        class so again these all databases implements this Query interface, and we have already defined
        the return type as Query in the DataBase interface so each of the implementation of createQuery()
        method in each of the database classes returns Query data type, but those databases can return
        their respective query and that can be stored in Query reference as they all implement Query interface
        as well.

        In our interface <<DataBase>>, there are also many other methods like ConnectToDatabase() and
        refreshDatabase() and so on, but this createQuery() method is showing some special characteristics
        of returning a Query object corresponding to the DataBase class, so it's is capable of having
        returning respective class's objects. So what actually we have achieved here is

        DataBase db = new MySQLDB();
        Query q = db.createQuery(); <-- now this is capable enough of returning object of respective class.

        If this was not the case then we had to manage it with if else condition to check each of them
        with their respective instances and that would violate SRP and OCP.

        So this createQuery method is a factory method, as it is returning the object of corresponding
        class even being general and common among all but returns corresponding to a class.

        Factory Method :- A method of an interface, which have return type of some other interface
        and that return type interface is implemented by other classes as well so this kind of method
        is called as Factory Method.

        continued in description1
        * */
    }
}

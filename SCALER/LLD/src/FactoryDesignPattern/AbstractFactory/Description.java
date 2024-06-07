package FactoryDesignPattern.AbstractFactory;

public class Description {

    public static void main(String[] args){
        /* Can there be a use-case where there are multiple factory methods ?
        let's take the same example of DataBase interface
        DataBase {
            Query createQuery();
            void Connect();
            void refreshDB();
            Transaction createTransaction();
            Session createSession();
        }
        yes it can be, so here this database interface is containing both types of methods factory and
        non-factory so this is kind of violating Single Responsibility Principle.
        So when there are too many methods inside a single interface then we should split it into
        two halves accordingly and this is the case of Abstract Factory.

        Abstract Factory :-
        Divide interface in two parts, one with non-factory methods and one with factory methods.
        1) <<DataBase>> <-- this is non-factory methods interface.
        2) <<DataBaseFactory>> <-- this is interface with factory methods.

        DataBase{
            void connectToDatabase();
            void refreshDataBase();
        }

        DataBaseFactory{
            Query createQuery();
            Transaction createTransaction();
        }

        Now we have object of database, DataBase db = new MySQLDataBase();
        and we want to use methods of factory as well so how can we link them as these two are
        separate interfaces ? and MySQL database will not implement the DataBaseFactory interface
        so how can we call the DataBaseFactory methods from DataBase object ?

        One thing is clear that corresponding database factory classes should also be there
        so that we can get the query from corresponding classes and also need to get the
        corresponding database factory from DataBase interface.

        We can just add another method DataBaseFactory createDataBaseFactory(); in DataBase interface
        now every database will implement this method and will return its factory object and from
        it, we can access its factory methods of query and transaction like this

        DataBase db = new MySQLDB();
        This db.createDataBaseFactory is returning corresponding database factory on the basis
        of RunTime polymorphism principle.
        DataBaseFactory dbf = db.createDataBaseFactory();
        Query q = dbf.createQuery(); <-- this will return MySQL query

        In the future if we decide to use MongoDB instead of MySQLDB, so we just need to replace
        it with MongoDB so only one word change will do the task.

        Continued in RealLifeUseCase
        * */
    }
}

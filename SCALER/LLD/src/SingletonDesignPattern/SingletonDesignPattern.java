package SingletonDesignPattern;

public class SingletonDesignPattern {
    /* Singleton design pattern allows only one object of a class on which it is applied.
     Why singleton ?
     A class which have shared resource as well as which is creation heavy, needs to be having
     only one object per application like Database connection class as mostly a database is
     present in different machine on which java application is running and for maintaining
     connection, a database connection have to store Http connection and TCP connection it
     takes time and its computationally challenging process, so across the classes of the
     application we will maintain a single object of database connection, so it will take care
     of all the database transactions, so for all the service like userservice, orderservice
     we will use that single object.

     Just like database there is a logger object that is resources heavy and is used to log the
     errors and messages to the console, so logger is also having singleton approach to save resources

     So we use singleton design pattern when class contains computationally heavy methods and even
     the parameters are going to remain constant throughout the application, then we need to use
     singleton design pattern.
    * */
}

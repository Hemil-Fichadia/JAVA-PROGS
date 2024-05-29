package SOLIDPrinciples.Principle4;

public class I {
    /* I -> Interface segregation principle
    This principle states that, Ideally every interface should have single method.

    Let's say we got a requirement from manager that, birds which can fly can dance as well so
    both these behaviours exist together, so we created an interface <<flyDance>> with these two
    methods fly() and dance(). After few days, client approached manager with different requirement
    that it's not mandatory for a bird to fly and dance both so a bird which can fly may or may not
    dance and the bird which dance may or may not fly, so now we need to separate both of these
    methods.

    The takeaway from this principle is that keep your interfaces as light as possible, that means
    an interface should contain methods of specific behaviour, like a reader class would have
    FileReader method, but if it also handles method related to print and sound then, in the future,
    we have to be ready for uncertainties of client's requirement of making print and sound
    process independent in terms of changing the way they act and at that time it will definitely
    violate single responsibility and open closed principle.

    The above scenario is possible that doesn't mean that we need to have separate methods for each
    and every behaviour, but instead focus on grouping methods with some specific signature togethers,
    so even if they are supposed to act in different scenarios, they are still under the range of
    separation.

    Ultimately these design principles helps us to achieve code maintainability as well as
    makes it reusable.
    * */








}

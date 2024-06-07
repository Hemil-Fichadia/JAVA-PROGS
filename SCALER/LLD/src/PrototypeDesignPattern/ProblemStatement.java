package PrototypeDesignPattern;

public class ProblemStatement {

    public static void main(String[] args){
        /* Given an object of a class, we need to create a copy of this
        object.

        Student st = new Student();
        Student stCopy = st;

        This is not a copy of an object a copy of an object means each and every attribute is
        matching with the values of the main object's attribute.

        Even if we do copy all the attributes from the main object, then still there will be some
        attributes that would be simply impossible to copy like if we do stCopy.name = st.name
        so stCopy.name will point to String object that is at address of st.name and this was
        just String if it is a list of objects then it becomes next to impossible to create copy of
        each object as we need to make copy of each and every object inside the list.

        So first way to copy an object is map respective attributes and assign them the same value,
        like this :-
        stCopy.name = st.name;
        stCopy.age = st.age;
        stCopy.batch = st.batch;

        The most concerning disadvantage here is we need to expose all the attributes to client and
        if there is some private attribute then client will not be able to copy it.

        Student class might have some private attributes that client won't be able to access and if
        there are any child class of Student class then we can store it in the reference of Student
        class like IntelligentStudent with IQ parameter higher than normal students.

        if(st.instanceOf(Student)){
            return new Student();
        }
        else if(st.instanceOf(IntelligentStudent)){
            return new IntelligentStudent();
        }

        We need to check like is the current instance is of what type of Student's child classes
        with if conditions and that will violate SRP and OCP .

        Other way of creating copy of an object is copy constructor, so we will pass the object
        in while creating new copy of Student class but still we need to check using if conditions
        like which instance it is and that will also include using of if-else condition inside
        constructor so that will also break OCP, and we are handing over this responsibility to
        client to manage and create copy and that is prone to errors, and we would never leave anything
        that would lead to misbehave on the client side, even the if conditions are checking correct
        but the object that is being returned can be altered and there won't be any errors.

        Other way is that developers provide a method that have all this logic and returns the copy
        of the object, and the main benefit of it is we don't need to expose all the details to
        client without OCP violation and this can be simply achieved by making a method return
        new copy object which will be the copy of the current object like this,

        Student getCopy(){
            Student st = new Student();
            st.name = this.name;
            st.age = this.age;
            st.batch = this.batch;
            st.psp = this.psp;
            return st;
        }

        with this approach, the copy method will be triggered of the respective class for which object is
        passed, and it is possible due to one OOP fundamental property of method overriding like each of
        the child class will override this getCopy() method and that will help to create the exact copy
        of the current Student or Student's child class as the return type is Student so any of the
        object type can be returned.

        The second advantage of this approach is, that the method id able to handle the type of object
        dynamically and as the copy method is called on whichever class will return the respective class's
        object only so every child class should override the getCopy method in order to get consistent and
        expected results.
        */
    }
}

package PrototypeDesignPattern;

public class Solution {
    public static void main(String[] args){
        /* When a scheme is under construction, the builder constructs sample flats to demonstrate
        clients about how a flat would look like after construction and this sample is the prototype
        that we are referring to.

        Second use-case Classmate notebooks
        Let's say you are a software developer at Classmate notebooks
        There is a class Notebook
        Notebook {
            int pages;
            int pageSize;
            String type;
            int width;
            int mrp;
            FrontPage frontPageDesign;
            LastPage lastPageDesign;
        }

        So Classmate wants to manufacture 1,00,000 single line notebooks of page size A4 and 200 pages
        and which is supposed to have some attractive frontPageDesign and lastPageDesign no need to be
        unique at all but there are some set of designs that will be present in each pack, so how many
        objects we need to create for 1,00,000 notebooks 1,00,000 yes, but there is a catch attached to
        it like all the attributes except for frontPageDesign and lastPageDesign are exact same so actually
        one object is there for all the other attributes except for designs so actually there is no
        need to create this many objects just the objects with unique set of frontPage and lastPage
        designs.

        Here we can create a prototype object with frontPageDesign and lastDesign as null
        Notebook {
            int pages = 200;
            String size = A4;
            String type = Ruled;
            int width = 180;
            int mrp = 86;
            FrontPageDesign frontPageDesign = null;
            LastPageDesign lastPageDesign = null;
        }
        For every notebook of above type, create a copy of prototype object and give the values for
        frontPageDesign and lastPageDesign.

        Often there are scenarios where we don't want to create from scratch, instead we prefer to create
        prototype object from an already existing object and set few attributes.

        A better approach is also there like we can store that prototype object of that specific
        type book in a HashMap like this "A4-200-180-2021" this whole String is key and this key
        makes sure that any combination made in year 2021 with 200 pages and 180 width page are
        having copy objects registered, and those can be very helpful for even company to track
        down which year and batch this notebook is so for each batch of notebooks the same object
        can be used and over and over again.

        Rules to declare copy class :-
        1) In the class that we want to create prototypes, we need to define a copy method, and also
        make sure that every child class overrides the copy method.

        2) Store the prototype objects in registry.

        3) Call the registry and get the prototype object, get the copy of this object from
        copy method and then assign or change the required set of attributes.
        * */
    }
}

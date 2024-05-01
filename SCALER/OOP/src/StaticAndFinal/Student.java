package StaticAndFinal;

public class Student {
    String name;
    int age;
    /* static keyword makes an attribute or a method object independent
    and this used occasionally when there is a specific need to make it
    constant or object independent like here, in a college based system
    each and every student have common college name so no need to make it
    for each and every Student, so we can make it static and if we want to
    make it common among the whole system and if we want to make if we
    want to make it immutable we also need to make it final.
    * */
    static final String college = "Neovarsity";
}

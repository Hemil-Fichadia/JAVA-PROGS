package PrototypeDesignPattern.StudentPrototype;

public class Client {
    private static void fillRegistry(StudentRegistry studentRegistry){
        Student apr23BeginnerBatch = new Student();
        apr23BeginnerBatch.setBatch("Apr 23 Beginner batch");
        apr23BeginnerBatch.setAveragePsp(70.0);
        studentRegistry.register("apr23Beginner", apr23BeginnerBatch);

        IntelligentStudent apr23IntelligentStudent = new IntelligentStudent();
        apr23IntelligentStudent.setBatch("Apr 23 Beginner batch");
        apr23IntelligentStudent.setAveragePsp(70.0);
        apr23IntelligentStudent.setIq(167);
        studentRegistry.register("apr23Intelligent", apr23IntelligentStudent);
    }
    public static void main(String[] args){
        //This is the registry object
        StudentRegistry studentRegistry = new StudentRegistry();
        //Here we called this method to initialize registry
        fillRegistry(studentRegistry);

        //This is a Student type object
        Student deepak = studentRegistry.get("apr23Beginner").clone();
        deepak.setName("Deepak");
        deepak.setPsp(89);
        deepak.setAge(28);
        //This is IntelligentStudent type object which is child class of Student
        Student hemil = studentRegistry.get("apr23Intelligent").clone();
        hemil.setName("Hemil");
        hemil.setAge(24);
        hemil.setPsp(97.0);
        hemil.setCity("Ahemdabad");
    }
}

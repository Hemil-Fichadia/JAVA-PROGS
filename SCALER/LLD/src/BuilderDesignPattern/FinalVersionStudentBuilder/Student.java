package BuilderDesignPattern.FinalVersionStudentBuilder;

import BuilderDesignPattern.CustomExceptions.InvalidBatchInputException;
import BuilderDesignPattern.CustomExceptions.InvalidNameInputException;
import BuilderDesignPattern.CustomExceptions.InvalidPhoneNumberInputException;
import BuilderDesignPattern.CustomExceptions.UnderAgeCandidateException;


public class Student {
    String name;
    int age;
    String batch;
    double psp;
    int gradYear;
    String university;
    String phoneNumber;

    private Student(){

    }
    private Student(StudentBuilder studentBuilder) {
        /* We can only reach here once everything is analyzed and checked inside
        builder class's build method, so here we just need to assign values to current
        class's attributes.
        * */
        this.name = studentBuilder.getName();
        this.age = studentBuilder.getAge();
        this.batch = studentBuilder.getBatch();
        this.psp = studentBuilder.getPsp();
        this.gradYear = studentBuilder.getGradYear();
        this.university = studentBuilder.getUniversity();
        this.phoneNumber = studentBuilder.getPhoneNumber();
    }
    public static StudentBuilder getBuilder(){
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        String name;
        int age;
        String batch;
        double psp;
        int gradYear;
        String university;
        String phoneNumber;

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public StudentBuilder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public StudentBuilder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public StudentBuilder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public String getUniversity() {
            return university;
        }

        public StudentBuilder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public StudentBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Student build() throws UnderAgeCandidateException, InvalidNameInputException, InvalidPhoneNumberInputException, InvalidBatchInputException {
            /* All the validations are shifted to this build method, and it is working as we are just checking
            before we send "this" builder object to be built as the attributes are set while calling the
            Student getBuilder object.
            * */
            if(this.getName().contains("!") || this.getName().contains("@") || this.getName().contains("#") || this.getName().contains("%") || this.getName().contains("^") || this.getName().contains("&") || this.getName().contains("*")){
                throw new InvalidNameInputException("Please enter characters apart from special ");
            }
            if(this.getAge() < 18){
                throw new UnderAgeCandidateException("Age should be 18 or above");
            }
            if(this.getBatch().contains("!")){
                throw new InvalidBatchInputException("Invalid batch input");
            }
            if(this.getPhoneNumber().length() != 14){
                throw new InvalidPhoneNumberInputException("Enter 10 digit phone number with country code with '-'");
            }
            //Here we are calling Student class's constructor by passing builder object.
            return new Student(this);
        }
    }

}

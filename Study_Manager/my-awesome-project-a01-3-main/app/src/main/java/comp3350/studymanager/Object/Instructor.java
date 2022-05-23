package comp3350.studymanager.Object;

public class Instructor{
    private final String firstName;
    private final String lastName;

    //constructor
    public Instructor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //getters and setters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}


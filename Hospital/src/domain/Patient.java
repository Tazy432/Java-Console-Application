package domain;

public class Patient implements UniqueIdentifier<Integer> {
    private Integer idPatient;
    private String firstName;
    private String lastName;
    private int age;

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Patient(int idPatient, String firstName, String lastName, int age) {
        this.idPatient=idPatient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        String text = "";
        text = text + "The first name of the patient is: " + this.firstName + "\n";
        text = text + "The last name of the patient is: " + this.lastName + "\n";
        text = text + "The age of the patient is : " + this.age + "\n";
        return text;
    }

    @Override
    public Integer getID() {
        return idPatient;
    }

    @Override
    public void setID(Integer integer) {
        idPatient=integer;

    }
}

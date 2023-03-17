package domain;

public class Doctor implements UniqueIdentifier<Integer> {
    private Integer idDoctor;
    private String firstName;
    private String lastName;
    private String speciality;
    private double rating;


    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Doctor(int idDoctor, String firstName, String lastName, String speciality, double rating) {

        this.idDoctor=idDoctor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.speciality = speciality;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public String toString()
    {
        String text="";
        text=text+"The first name of the doctor is: "+this.firstName+"\n";
        text=text+"The last name of the doctor is: "+this.lastName+"\n";
        text=text+"The doctor's speciality is: "+this.speciality+"\n";
        text=text+"The doctor's rating is : "+this.rating+"\n";
        return text;

    }

    @Override
    public Integer getID() {
        return idDoctor;
    }

    @Override
    public void setID(Integer integer) {
        idDoctor=integer;
    }
}

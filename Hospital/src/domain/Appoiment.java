package domain;


import java.time.LocalDate;
import java.time.LocalTime;


public class Appoiment implements UniqueIdentifier<Integer>{


    private Integer idAppoiment;
    private Integer idDoctor;

    public Integer getIdAppoiment() {
        return idAppoiment;
    }

    public void setIdAppoiment(Integer idAppoiment) {
        this.idAppoiment = idAppoiment;
    }

    private Integer idPatient;
    private LocalDate date;
    private LocalTime time;
    public Integer getIdDoctor()
    {
        return idDoctor;
    }
    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {

        this.time = time;
    }
    public Appoiment(Integer idAppoiment,Integer idDoctor, Integer idPatient, LocalDate date, LocalTime time) {

        this.idAppoiment=idAppoiment;
        this.idDoctor = idDoctor;
        this.idPatient = idPatient;
        this.date = date;
        this.time = time;
    }

    @Override
    public Integer getID() {
        return idAppoiment;
    }

    @Override
    public void setID(Integer integer) {
        idAppoiment=integer;
    }

    @Override
    public String toString() {
        return "Appoiment{" +
                "idAppoiment=" + idAppoiment +
                ", idDoctor=" + idDoctor +
                ", idPatient=" + idPatient +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}

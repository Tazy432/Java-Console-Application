import Service.*;
import UserInterface.ui;
import domain.Appoiment;
import domain.Doctor;
import domain.Patient;
import repository.AppoimentRepository;
import repository.DoctorRepository;
import repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Doctor d1=new Doctor(0,"George","Spataru","Pediatru",8.9);
        Doctor d2=new Doctor(1,"Mihai","Spanu","Cardiolog",9.3);
        Doctor d3=new Doctor(2,"Claudiu","Muntean","Oftalmolog",8.8);

        Patient p1=new Patient(0,"Mihai","Corvine",87);
        Patient p2=new Patient(1,"Andrei","Maciuca",22);
        Patient p3=new Patient(2,"Danila","Prepeleac",38);

        Appoiment a1=new Appoiment(0,1,0, LocalDate.of(2000,6,21), LocalTime.of(16,20));

        PatientRepository pacients=new PatientRepository();
        DoctorRepository doctorRepository=new DoctorRepository();
        AppoimentRepository appoimentRepository=new AppoimentRepository();

        pacients.addElementValue(p1);
        pacients.addElementValue(p2);
        pacients.addElementValue(p3);

        doctorRepository.addElementValue(d1);
        doctorRepository.addElementValue(d2);
        doctorRepository.addElementValue(d3);

        UserInput userInput=new UserInput();
        ui ui1=new ui();
        Controller manipulator=new Controller(pacients,doctorRepository,appoimentRepository,ui1,userInput);

    }
}
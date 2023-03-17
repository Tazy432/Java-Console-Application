package Service;

import UserInterface.ui;
import domain.Appoiment;
import domain.Doctor;
import domain.Patient;
import domain.UniqueIdentifier;
import repository.AbstractRepository;

import javax.print.Doc;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    ui UI =new ui();
    Scanner keyboard=new Scanner(System.in);
    public Patient readPatient()
    {
        Patient dummy=new Patient(0,"","",0);
        System.out.println("Please enter the id of the patient ");
        dummy.setID(UserInput.needNumber());
        System.out.println("Please enter the first name of the pacient ");
        dummy.setFirstName(keyboard.next());
        System.out.println("Please enter the last name of the pacient ");
        dummy.setLastName(keyboard.next());
        System.out.println("Please enter the age of the pacient ");
        dummy.setAge(UserInput.needNumber());
        return dummy;
    }
    public Doctor readDoctor()
    {
        Doctor dummy =new Doctor(0,"","","",0);
        System.out.println("Please enter the id of the doctor ");
        dummy.setID(UserInput.needNumber());
        System.out.println("Please enter the first name of the doctor ");
        dummy.setFirstName(keyboard.next());
        System.out.println("Please enter the last name of the doctor ");
        dummy.setLastName(keyboard.next());
        System.out.println("Please enter the speciality of the doctor");
        dummy.setSpeciality(keyboard.next());
        System.out.println("Please enter the rating of the doctor");
        dummy.setRating(keyboard.nextDouble());
        return dummy;
    }
    public Appoiment readAppoiment()
    {
        Appoiment dummy=new Appoiment(0,0,0, LocalDate.of(2000,10,10), LocalTime.of(16,20));
        System.out.println("Please enter the id of the appoiment");
        dummy.setIdAppoiment(UserInput.needNumber());
        System.out.println("Please enter the id of the doctor ");
        dummy.setIdDoctor(UserInput.needNumber());
        System.out.println("Please enter the id of the patient ");
        dummy.setIdPatient(UserInput.needNumber());

        LocalDate dateDummy = null;
        try {
            System.out.println("Please enter the year of the appoiment ");
            dateDummy=dummy.getDate().withYear(UserInput.needNumber());
            System.out.println("Please enter the mouth of the appoiment ");
            dateDummy=dateDummy.withMonth(UserInput.needNumber());
            System.out.println("Please enter the day of the appoiment ");
            dateDummy=dateDummy.withDayOfMonth(UserInput.needNumber());
        }catch (DateTimeException e){System.out.println("The Mouth must be betweeen 1 and 12 ");}


        LocalTime timeDummy = null;
        try
        {
            System.out.println("Please enetr the hour of the apooiment ");
            timeDummy=dummy.getTime().withHour(UserInput.needNumber());
            System.out.println("Please eneetr the minute of the appoiment ");
            timeDummy=timeDummy.withMinute(UserInput.needNumber());
        }catch(DateTimeException e){System.out.println("The hour must be between 0 and 23 and the minute between 0 and 59");}

        dummy.setDate(dateDummy);
        dummy.setTime(timeDummy);
        return dummy;
    }
    public static Integer needNumber()
    {
        Scanner keyboard=new Scanner(System.in);
        Integer chosenId=-1;
        try
        {
            chosenId= keyboard.nextInt();
            return chosenId;
        }catch (InputMismatchException e){System.out.println("Please enter a NUMBER !!!");return chosenId=needNumber();}

    }
    public static Integer readID()
    {

        System.out.println("Please enter the id: ");
        Scanner keyboard=new Scanner(System.in);
        Integer chosenId=-1;
        try
        {
            chosenId= keyboard.nextInt();
            return chosenId;
        }catch (InputMismatchException e){System.out.println("Please enter a NUMBER !!!");return chosenId=readID();}

    }
    public static Integer nextOperation()
    {
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Please insert the number of the next operation ...");
        int chosenValue=-1;
        try
        {
            chosenValue= keyboard.nextInt();
            return chosenValue;
        }catch (InputMismatchException e){System.out.println("Please enter a NUMBER !!!");return chosenValue=nextOperation();}

    }
    public static boolean checkIdExistance(int searchedId , AbstractRepository<UniqueIdentifier<Integer>,Integer> repo)
    {
        return repo.existCheck(searchedId);
    }
}

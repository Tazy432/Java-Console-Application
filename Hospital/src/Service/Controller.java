package Service;

import UserInterface.ui;
import domain.Appoiment;
import domain.Doctor;
import domain.Patient;
import repository.AppoimentRepository;
import repository.DoctorRepository;
import repository.PatientRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static Service.UserInput.checkIdExistance;

public class Controller {
    PatientRepository patientRepo=new PatientRepository();
    DoctorRepository doctorRepo=new DoctorRepository();
    AppoimentRepository appoimentRepo=new AppoimentRepository();
    ui userInterface=new ui();
    UserInput functions=new UserInput();

    public PatientRepository getPatientRepo() {
        return patientRepo;
    }

    public void setPatientRepo(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public DoctorRepository getDoctorRepo() {
        return doctorRepo;
    }

    public void setDoctorRepo(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public AppoimentRepository getAppoimentRepo() {
        return appoimentRepo;
    }

    public void setAppoimentRepo(AppoimentRepository appoimentRepo) {
        this.appoimentRepo = appoimentRepo;
    }

    public ui getUserInterface() {
        return userInterface;
    }

    public void setUserInterface(ui userInterface) {
        this.userInterface = userInterface;
    }

    public UserInput getFunctions() {
        return functions;
    }

    public void setFunctions(UserInput functions) {
        this.functions = functions;
    }



    public void addPatient()
    {
        patientRepo.addElementValue(functions.readPatient());
    }
    public void addDoctor()
    {
        doctorRepo.addElementValue(functions.readDoctor());
    }
    public void addAppoiment()
    {
        Appoiment dummy=functions.readAppoiment();
        boolean patientExist=patientRepo.existCheck(dummy.getIdPatient());
        boolean doctorExist=doctorRepo.existCheck(dummy.getIdDoctor());
        if(!patientExist)
            System.out.println("No patient with this id");
        if(!doctorExist)
            System.out.println("No doctor with this id ");
        if(patientExist && doctorExist)
            appoimentRepo.addElementValue(dummy);
    }
    public void deletePatient()
    {
        Integer deletedId= UserInput.readID();
        if(!patientRepo.deleteElementValueId(deletedId))
            System.out.println("No patient with this id exists");
        else
        {
            patientRepo.deleteElementValueId(deletedId);
            for( Appoiment i:appoimentRepo.seeObjects().values())
            {
                if(i.getIdPatient()==deletedId)
                    appoimentRepo.deleteElementValue(i);
            }
        }
    }
    public void deleteDoctor()
    {
        Integer deletedId= UserInput.readID();
        if(!doctorRepo.deleteElementValueId(deletedId))
            System.out.println("No doctor with this id exists");
        else
        {
            for( Appoiment i:appoimentRepo.seeObjects().values())
            {
                if(i.getIdDoctor()==deletedId)
                    appoimentRepo.deleteElementValue(i);
            }
        }
    }
    public void deleteAppoiment()
    {
        Integer deletedId= UserInput.readID();
        if(!appoimentRepo.deleteElementValueId(deletedId))
            System.out.println("No appoiment with this id exist");

    }
    public Controller(PatientRepository patientRepo, DoctorRepository doctorRepo, AppoimentRepository appoimentRepo, ui userInterface, UserInput functions) {
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
        this.appoimentRepo = appoimentRepo;
        this.userInterface = userInterface;
        this.functions = functions;
        Integer option = 1;
        userInterface.masterMenu();
        while (option != 0) {
            option = UserInput.nextOperation();
            switch (option) {
                case 1:
                    userInterface.addinMenu();
                    int addOption = -1;
                    addOption = UserInput.nextOperation();
                        switch (addOption) {
                            case 0:
                                option=0;
                                break;
                            case 1:
                                this.addPatient();
                                break;
                            case 2:
                                this.addDoctor();
                                break;
                            case 3:
                                this.addAppoiment();
                                break;
                            case 4:
                                for(Patient p:this.patientRepo.seeObjects().values())
                                    System.out.println(p);
                                for(Doctor d:this.doctorRepo.seeObjects().values())
                                    System.out.println(d);
                                for(Appoiment a:this.appoimentRepo.seeObjects().values())
                                    System.out.println(a);
                                break;
                            default:
                                System.out.println("Please select a number between 0 and 3");
                                break;
                        }
                    break;
                case 2:
                    userInterface.deletingMenu();
                    int nextOption = -1;
                        nextOption = UserInput.nextOperation();
                        switch (nextOption) {
                            case 0:
                                option=0;
                            case 1:
                                this.deletePatient();
                                break;
                            case 2:
                                this.deleteDoctor();
                                break;
                            case 3:
                                this.deleteAppoiment();
                                break;
                            default:
                                System.out.println("Please select a number between 0 and 3");
                                break;
                        }
                    break;
                case 3:
                    userInterface.updateMenu();
                    int updateOption=UserInput.nextOperation();
                    switch (updateOption)
                    {
                        case 0:
                            option=0;
                            break;
                        case 1:
                            int patientChosenId=UserInput.readID();
                            if(!patientRepo.existCheck(patientChosenId))
                            {
                                while(!patientRepo.existCheck(patientChosenId))
                                {
                                    System.out.println("No patient with this id");
                                    System.out.println("Please choose another id");
                                    patientChosenId=UserInput.readID();
                                }
                            }
                            Patient dummy=functions.readPatient();
                            patientRepo.deleteElementValueId(patientChosenId);
                            patientRepo.addElementValue(dummy);
                            for(Appoiment i:appoimentRepo.seeObjects().values())
                            {
                                if(i.getIdPatient()==patientChosenId)
                                {
                                       i.setIdPatient(dummy.getIdPatient());
                                }
                            }
                            break;
                        case 2:
                            int doctorChosenId=UserInput.readID();
                            if(!doctorRepo.existCheck(doctorChosenId))
                            {
                                while(!doctorRepo.existCheck(doctorChosenId))
                                {
                                    System.out.println("No doctor with this id");
                                    System.out.println("Please choose another id");
                                    doctorChosenId=UserInput.readID();
                                }
                            }
                            Doctor dummy2=functions.readDoctor();
                            doctorRepo.deleteElementValueId(doctorChosenId);
                            doctorRepo.addElementValue(dummy2);
                            for(Appoiment i :appoimentRepo.seeObjects().values())
                            {
                                if(i.getIdDoctor()==doctorChosenId)
                                {
                                    i.setIdDoctor(dummy2.getIdDoctor());
                                }
                            }
                            break;
                        case 3:
                            int appoimentChosenId=UserInput.readID();
                            if(!appoimentRepo.existCheck(appoimentChosenId))
                            {
                                while(!appoimentRepo.existCheck(appoimentChosenId))
                                {
                                    System.out.println("No appoiment with this id");
                                    System.out.println("Please choose another id");
                                    appoimentChosenId=UserInput.readID();
                                }
                            }
                            Appoiment dummy3=functions.readAppoiment();
                            appoimentRepo.deleteElementValueId(appoimentChosenId);
                            appoimentRepo.addElementValue(dummy3);
                            break;
                        default:
                            System.out.println("Please choose a number between 0 and 3");
                            break;
                    }
                    break;
                case 4:
                    userInterface.sortingMenu();
                    int sortingOption=UserInput.nextOperation();
                    switch (sortingOption) {
                        case 0:
                            option = 0;
                            break;
                        case 1:
                            List<Patient> sortedPatients = new ArrayList<Patient>();
                            sortedPatients = patientRepo.seeObjects().values().stream().sorted(Comparator.comparing(Patient::getAge)).collect(Collectors.toList());
                            System.out.println("The list of the patients sorted by age is :");
                            for (int i = 0; i < sortedPatients.size(); i++) {
                                System.out.println(sortedPatients.get(i));
                            }
                            break;
                        case 2:
                            List<Patient> sortedPatients2 = new ArrayList<Patient>();
                            sortedPatients2 = patientRepo.seeObjects().values().stream().sorted(Comparator.comparing(Patient::getLastName)).collect(Collectors.toList());
                            System.out.println("The list of the patients sorted by their last name is :");
                            for (int i = 0; i < sortedPatients2.size(); i++) {
                                System.out.println(sortedPatients2.get(i));
                            }
                            break;
                        case 3:
                            List<Doctor> sortedDoctors = new ArrayList<Doctor>();
                            sortedDoctors = doctorRepo.seeObjects().values().stream().sorted(Comparator.comparing(Doctor::getRating)).collect(Collectors.toList());
                            System.out.println("The doctors , ordered by rating are as follows: ");
                            for (int i = 0; i < sortedDoctors.size(); i++) {
                                System.out.println(sortedDoctors.get(i));
                            }
                            break;
                        case 4:
                            List<Doctor> sortedDoctors2 = new ArrayList<Doctor>();
                            sortedDoctors2 = doctorRepo.seeObjects().values().stream().sorted(Comparator.comparing(Doctor::getRating)).collect(Collectors.toList());
                            System.out.println("The doctors , ordered by theyre last name are as follows: ");
                            for (int i = 0; i < sortedDoctors2.size(); i++) {
                                System.out.println(sortedDoctors2.get(i));
                            }
                            break;
                        case 5:
                            List<Appoiment> sortedAppoiments = new ArrayList<Appoiment>();
                            sortedAppoiments = appoimentRepo.seeObjects().values().stream().sorted(Comparator.comparing(Appoiment::getDate)).collect(Collectors.toList());
                            System.out.println("The appoiments ordered by theyre date are as follows :");
                            for (int i = 0; i < sortedAppoiments.size(); i++) {
                                System.out.println(sortedAppoiments.get(i));
                            }
                            break;
                        case 6:
                            List<Appoiment> sortedAppoiments2 = new ArrayList<Appoiment>();
                            sortedAppoiments2 = appoimentRepo.seeObjects().values().stream().sorted(Comparator.comparing(Appoiment::getTime)).collect(Collectors.toList());
                            System.out.println("The appoiments ordered by theyre date are as follows :");
                            for (int i = 0; i < sortedAppoiments2.size(); i++) {
                                System.out.println(sortedAppoiments2.get(i));
                            }
                            break;
                        default:
                            System.out.println("Please select a number between 0 and 6");
                            break;
                    }
                case 5:
                    userInterface.filteringMenu();
                    int filteringOption=UserInput.nextOperation();
                    switch (filteringOption)
                    {
                        case 0:
                            option=0;
                            break;
                        case 1:
                            for(Patient i:patientRepo.seeObjects().values())
                                System.out.println(i);
                            break;
                        case 2:
                            for(Doctor i:doctorRepo.seeObjects().values())
                                System.out.println(i);
                            break;
                        case 3:
                            for(Appoiment i:appoimentRepo.seeObjects().values())
                                System.out.println(i);
                            break;
                        case 4:
                            System.out.println("Please enter the minimum age :");
                            int greaterThan=UserInput.needNumber();
                            int numbers2=0;
                            for(Patient i:patientRepo.seeObjects().values())
                                if(i.getAge()>greaterThan)
                                {
                                    System.out.println(i);
                                    numbers2++;
                                }
                            if(numbers2==0)
                            {
                                System.out.println("None");
                            }

                            break;
                        case 5:
                            System.out.println("Please enter the minimum rating");
                            int greaterThan2=UserInput.needNumber();
                            int numbers=0;
                            for(Doctor i:doctorRepo.seeObjects().values())
                                if(i.getRating()>greaterThan2)
                                {
                                    System.out.println(i);
                                    numbers++;
                                }
                            if(numbers==0)
                            {
                                System.out.println("None");
                            }
                            break;
                        default:
                            System.out.println("Please eneter a number between 0 and 5");
                            break;

                    }
                    break;
                case 0:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Please select a number between 0 and 5");
                    break;
            }
        }


    }


}

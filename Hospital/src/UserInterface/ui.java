package UserInterface;

public class ui {
    public void masterMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Press 1 to see the adding operations");
        System.out.println("Press 2 to see the deleting operations");
        System.out.println("Press 3 to see the update operations");
        System.out.println("Press 4 to see the sorting operations");
        System.out.println("Press 5 to see the filtering operations");
        System.out.println("Press 0 to exit");
        System.out.println("--------------------------------------");
    }

    public void addinMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Press 1 to add a patient");
        System.out.println("Press 2 to add a doctor");
        System.out.println("Press 3 to add an appoiment");
        System.out.println("--------------------------------------");
    }

    public void deletingMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Press 1 to delete a patient");
        System.out.println("Press 2 to delete a doctor");
        System.out.println("Press 3 to delete an appoiment");
        System.out.println("--------------------------------------");
    }

    public void updateMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Press 1 to update a patient");
        System.out.println("Press 2 to update a doctor");
        System.out.println("Press 3 to update an appoiment");
        System.out.println("--------------------------------------");
    }

    public void sortingMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Press 1 to sort patients by age");
        System.out.println("Press 2 to sort patients by last name");
        System.out.println("Press 3 to sort doctors by rating");
        System.out.println("Press 4 to sort doctors by last name");
        System.out.println("Press 5 to sort appoiments by date");
        System.out.println("Press 6 to sort appoiments by hour");
        System.out.println("--------------------------------------");
    }

    public void filteringMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Press 1 to see all patients ");
        System.out.println("Press 2 to see all doctors ");
        System.out.println("Press 3 to see all appoiments");
        System.out.println("Press 4 to see all patients with age greater than a number");
        System.out.println("Press 5 to see all doctors with a rating greater than a number");
        System.out.println("--------------------------------------");
    }
    public ui()
    {
        //masterMenu();
    }

}

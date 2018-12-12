import ecam_side.Bloc;
import ecam_side.Ecam;
import ecam_side.Orientation;
import ecam_side.Program;
import people_side.Student;
import ue_classes.ObservableClass;
import ue_classes.ObservableUe;
import ue_classes.ObserverUe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    /**
     * Main function which is run
     *
     * @param args String[]
     */
    public static void main( final String[] args) {
        System.out.print("Launching...\n");

        //START INITIALIZE ECAM
        ObservableClass class1 = new ObservableClass("DD4L", "1");
        ObservableClass class2 = new ObservableClass("DD4X", "2");
        ObservableClass class3 = new ObservableClass("DD4Y", "3");
        ObservableClass class4 = new ObservableClass("DD4Z", "4");

        ObservableUe ue1 = new ObservableUe("DD", "SA");
        ue1.setCredits(99);
        ue1.setHours(90);
        ObservableUe ue2 = new ObservableUe("DX", "SX");
        ue2.setCredits(2);
        ue2.setHours(9);

        ue1.addClass(class1);
        ue2.addClass(class2);
        ue2.addClass(class3);
        ue2.addClass(class4);

        HashMap<String, ObservableUe> ues = new HashMap<String, ObservableUe>();
        ues.put(ue1.getCode(), ue1);
        ues.put(ue2.getCode(), ue2);
        Bloc bloc1 = new Bloc(ues);
        Bloc bloc2 = new Bloc(ues);
        Bloc bloc3 = new Bloc(ues);
        Bloc bloc4 = new Bloc(ues);
        Bloc bloc5 = new Bloc(ues);
        Program bachelier = new Program(Arrays.asList(bloc1, bloc2, bloc3));
        Program master = new Program(Arrays.asList(bloc4, bloc5));
        Orientation min = new Orientation("MIN", bachelier, master);

        Ecam ecam = Ecam.getInstance();
        ecam.addOrientation(min.getName(), min);
        //END INITIALIZE ECAM

        boolean testing;
        if (args[0].equals("testing")){
            testing = true;
        } else {
            testing = false;
        }
        if (testing) {
            String fname = "Benjamin";
            String lname = "Vandenbussche";
            String mat = "13152";
            Student std = new Student(fname, lname, Integer.parseInt(mat));
            std.newProgram("4", "4MIN");
            std.getProgram().addContent("4MIN", "SA");
            std.getProgram().addContent("4MIN", "SX");
            int test = std.getProgram().calcCredits();
            System.out.println(String.format("Credits: %d", test));
            int test2 = std.getProgram().calcHours();
            System.out.println(String.format("Hours: %d", test2));
            int test3 = std.getProgram().calcValidCredits();
            System.out.println(String.format("Validated Credits: %d", test3));
            ObserverUe obs = std.getProgram().getSpecificUe("SA");
            obs.validate();
            int test4 = std.getProgram().calcValidCredits();
            System.out.println(String.format("Validated Credits: %d", test4));
        }

        Scanner sc = new Scanner(System.in);
        while (!testing){
            System.out.println("Enter command: ");
            String command = sc.nextLine();

            if ("student".equals(command)){
                System.out.println("Create Student ->");
                System.out.print("First name: ");
                String fname = sc.nextLine();
                System.out.print("Last name: ");
                String lname = sc.nextLine();
                System.out.print("Matricule: ");
                String mat = sc.nextLine();
                Student std = new Student(fname, lname, Integer.parseInt(mat));
                ecam.addStudent(std);
                System.out.println("Student created!");
                System.out.println("->Creating program");
                System.out.print("-->year (1-5): ");
                String year = sc.nextLine();
                System.out.print("-->academic year (1MIN - 5GEO): ");
                String acyear = sc.nextLine();
                std.newProgram(year, acyear);
                System.out.println("Created program!");

                while (true){
                    System.out.println("Commands: add, cred, hours");
                    command = sc.nextLine();
                    if ("add".equals(command)){
                        System.out.println("Adding UE to Program");
                        System.out.print("UE year name (4MIN): ");
                        String ue_year = sc.nextLine();
                        System.out.print("UE code (SA4T): ");
                        String ue_code = sc.nextLine();
                        std.getProgram().addContent(ue_year, ue_code);
                        System.out.println("Added UE to Program!");
                    } else if ("cred".equals(command)){
                        int creds = std.getProgram().calcCredits();
                        String res1 = String.format("You have %d credits this year", creds);
                        System.out.println(res1);
                    } else if ("hours".equals(command)) {
                        int hours = std.getProgram().calcHours();
                        String res2 = String.format("You have %d hours this year", hours);
                        System.out.println(res2);
                    } else if ("valid".equals(command)) {
                        int v_creds = std.getProgram().calcValidCredits();
                        String res3 = String.format("You have %d valid credits this year", v_creds);
                        System.out.println(res3);
                    }
                }
            } else{
                System.out.println("Unknown");
            }
        }
    }
}

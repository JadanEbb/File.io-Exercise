import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scenario: user will provide input from the keyboard and the data will be stored
        // in the objects and finally data will be stored in the file   {files are needed to store info}

        //Using scanner and BufferedWriter objects

        Scanner scn = new Scanner(System.in);

//        String name = scn.next();
//        System.out.println("Name is: " + name);
//
//        double gpa = scn.nextDouble();
//        System.out.println("GPA is: " + gpa);

        //5 students name and gpa
        Student[] info = new Student[5];

        int i;
        String name;
        double gpa;
        Student S;

        for (i = 0; i < 5; i++) {
            name = scn.next();
            gpa = scn.nextDouble();

            S = new Student(name, gpa);
            info[i] = S;
        }
//            //Check the array
//            for ( i = 0; i<5; i++) {
//                System.out.println(info[i].getName());
//                System.out.println(info[i].getGpa());
//          }


        File f = new File("students.txt");

        try {
            if (f.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }

            // Filewriter or bufferedWriter?
           FileWriter fw = new FileWriter(f);
            for (i = 0; i < 5; i++) {
                fw.write(info[i].getName());
                fw.write("\n");
                fw.write(String.valueOf(info[i].getGpa()));
                fw.write("\n");
            }
            fw.close();


        } catch (IOException e) {
            System.out.println("Exception message: " + e.getMessage());
        }
    }
}

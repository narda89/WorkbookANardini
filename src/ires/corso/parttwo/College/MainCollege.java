package ires.corso.parttwo.College;

import java.util.*;

/**
 *  Esercizio per testare il funzionamento delle Mappe e dei Set in Java
 */

public class MainCollege
{
    public static void main(String[] args) {

        Student s1 = new Student("45018", "Caio", "Mario");
        Student s2 = new Student("45027", "Cicero", "Sempronio");
        Student s3 = new Student("45666","Attila", "L'Unno");
        Student s4 = new Student("b4c0n","Peppa", "Pig");

        Professor p1 = new Professor( "m34nPr0f","Oreste", "Adulfi");
        Professor p2 = new Professor("g00db0y","Flavio", "Gentili");

        ArrayList<IPrintable> gente = new ArrayList<>();
        gente.add(s1);
        gente.add(s2);
        gente.add(s3);
        gente.add(s4);

        gente.add(p1);
        gente.add(p2);

        for(IPrintable i : gente)
            i.prettyPrint();


        Course c1 = new Course("00001", "[c1]Informatica di Base", "ComputerScience");
        Course c2 = new Course("00002", "[c2]Algoritmi", "ComputerScience");
        Course c3 = new Course("00003", "[c3]Programmazione ad Oggetti", "ComputerScience");
        Course c4 = new Course("00004", "[c4]Analisi I", "Engineering");
        Course c5 = new Course("00005", "[c5]Idraulica I", "Engineering");
        Course c6 = new Course("00006", "[c6]Meccanica", "Engineering");

        // Prof p1 -> c1, c3, c5
        // Prof p2 -> c2, c4, c6

        HashMap<Course, Professor> corsiProfessori = new HashMap<>();
        corsiProfessori.put(c1,p1);
        corsiProfessori.put(c2,p2);
        corsiProfessori.put(c3,p1);
        corsiProfessori.put(c4,p2);
        corsiProfessori.put(c5,p1);
        corsiProfessori.put(c6,p2);

        //chiamo il metodo prettyPrint su il professore che insegna il corso c3 (ovvero p1, "m34nPr0f")
        corsiProfessori.get(c3).prettyPrint();

        //chiamo il metodo prettyPrint su il professore che insegna il corso c2 (ovvero p2, "g00db0y")
        corsiProfessori.get(c2).prettyPrint();

        // mi stampa tutti i corsi che sono stati mappati
        for(Course c:corsiProfessori.keySet())
            c.prettyPrint();

        // mi stampa per ogni corso il rispettivo professore associato tramite hashmap
        for (Professor p: corsiProfessori.values())
            p.prettyPrint();

        System.out.println("\n/////////////////////////////\n");

        // scansiona tutta la hashmap e stampa le key corrispondenti ad un dato value
        // (in questo caso, chiama il metodo di stampa sui corsi tenuti dal prof p1:

        System.out.println("Courses held by Professor Oreste Adulfi, aka \"m34nPr0f\"");

        for(Map.Entry<Course, Professor> entry : corsiProfessori.entrySet()) {
            if(entry.getValue().equals(p1))
                entry.getKey().prettyPrint();
        }

        // iscriviamo gli studenti ai corsi
        // s1 -> c1, c2, c3, c4
        // s2 -> c4, c5, c6
        // s3 -> c2, c3, c4
        // s4 -> c2, c5, c6

        // partiamo con lo studente 1:

        ArrayList<Course> s1Courses = new ArrayList<>();
        s1Courses.add(c1);
        s1Courses.add(c2);
        s1Courses.add(c3);
        s1Courses.add(c4);

        s1.setEnrolledCourses(s1Courses);

        // stampa di prova: controlliamo a cosa risulta iscritto lo studente 1:
        System.out.println("Lo studente s1 risulta iscritto a:");
        s1.printEnrolledCourses();

        // stessa cosa per tutti gli altri:
        ArrayList<Course> s2Courses = new ArrayList<>();
        s2Courses.add(c4);
        s2Courses.add(c5);
        s2Courses.add(c6);

        s2.setEnrolledCourses(s2Courses);

        // stampa di prova: controlliamo a cosa risulta iscritto lo studente 2:
        System.out.println("Lo studente s2 risulta iscritto a:");
        s2.printEnrolledCourses();

        ArrayList<Course> s3Courses = new ArrayList<>();
        s3Courses.add(c2);
        s3Courses.add(c3);
        s3Courses.add(c4);

        s3.setEnrolledCourses(s3Courses);

        // stampa di prova: controlliamo a cosa risulta iscritto lo studente 2:
        System.out.println("Lo studente s3 risulta iscritto a:");
        s3.printEnrolledCourses();


        ArrayList<Course> s4Courses = new ArrayList<>();
        s4Courses.add(c2);
        s4Courses.add(c5);
        s4Courses.add(c6);

        s4.setEnrolledCourses(s4Courses);

        // stampa di prova: controlliamo a cosa risulta iscritto lo studente 2:
        System.out.println("Lo studente s4 risulta iscritto a:");
        s4.printEnrolledCourses();

        // e se volessi sapere quali sono gli studenti iscritti ad un dato corso?

        ArrayList<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(s1);
        listaStudenti.add(s2);
        listaStudenti.add(s3);
        listaStudenti.add(s4);

        System.out.println("Studenti iscritti al corso c2 - Algoritmi: (s1, s3, s4)");

        for(Student s : listaStudenti) {
            for(Course c : s.getEnrolledCourses()){
                if(c.equals(c2))
                    s.prettyPrint();
            }
        }

        System.out.println("Studenti iscritti al corso c4 - Analisi I: (s1, s2, s3)");

        for(Student s : listaStudenti) {
            for(Course c : s.getEnrolledCourses()){
                if(c.equals(c4))
                    s.prettyPrint();
            }
        }

        // creiamo qualche assignment

        Assignment a1 = new Assignment("[a1] Assignment 1");
        Assignment a2 = new Assignment("[a2] Assignment 2");
        Assignment a3 = new Assignment("[a3] Assignment 1");
        Assignment a4 = new Assignment("[a4] Assignment 2");
        Assignment a5 = new Assignment("[a5] Assignment 1");
        Assignment a6 = new Assignment("[a6] Assignment 2");
        Assignment a7 = new Assignment("[a7] Assignment 1");
        Assignment a8 = new Assignment("[a8] Assignment 2");
        Assignment a9 = new Assignment("[a9] Assignment 1");
        Assignment a10 = new Assignment("[a10] Assignment 2");
        Assignment a11 = new Assignment("[a11] Assignment 1");
        Assignment a12 = new Assignment("[a12] Assignment 2");

        ArrayList<Assignment> listaAssignment = new ArrayList<Assignment>(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12));

        // assegnamo 2 assignment per ogni corso
        HashMap<Course,ArrayList<Assignment>> mappaAssignment = new HashMap<>();
        ArrayList<Assignment> assC1 = new ArrayList<Assignment>(Arrays.asList(a1,a2));
        ArrayList<Assignment> assC2 = new ArrayList<Assignment>(Arrays.asList(a3,a4));
        ArrayList<Assignment> assC3 = new ArrayList<Assignment>(Arrays.asList(a5,a6));
        ArrayList<Assignment> assC4 = new ArrayList<Assignment>(Arrays.asList(a7,a8));
        ArrayList<Assignment> assC5 = new ArrayList<Assignment>(Arrays.asList(a9,a10));
        ArrayList<Assignment> assC6 = new ArrayList<Assignment>(Arrays.asList(a11,a12));
        mappaAssignment.put(c1,assC1);
        mappaAssignment.put(c2,assC2);
        mappaAssignment.put(c3,assC3);
        mappaAssignment.put(c4,assC4);
        mappaAssignment.put(c5,assC5);
        mappaAssignment.put(c6,assC6);

        HashMap<Student, HashMap<Assignment, Integer>> mappaVoti = new HashMap<>();
        for(Student s : listaStudenti){
            HashMap mappy = new HashMap<Assignment,Integer>();
            for (Course c : s.getEnrolledCourses()) {
                for(Assignment a : mappaAssignment.get(c)){
                    Integer inter = randInt(0,10);
                    mappy.put(a,inter);
                }
                mappaVoti.put(s,mappy);
            }
        }

        System.out.println("///////////////////////////////////////////////");

        for (Student s: listaStudenti) {
            s.prettyPrint();
            for(Course c : s.getEnrolledCourses()) {
                c.prettyPrint();
                for(Assignment a : mappaAssignment.get(c)) {
                    System.out.printf(a.getAssignmentContent() + ": " + mappaVoti.get(s).get(a) + "\n");
                }
            }
        }

        // media dei voti di ogni studente per singolo corso
        System.out.println("--------- MEDIA VOTI STUDENTE PER SINGOLO CORSO ---------");
        for (Student s: listaStudenti) {
            System.out.println("Media voti di " + s.getStudentName() + " " + s.getStudentSurname());
            for (Course c : s.getEnrolledCourses()) {
                System.out.print("Corso " + c.getCourseName() + ": " );
                int media = 0;
                for(Assignment a : mappaAssignment.get(c)) {
                    media += mappaVoti.get(s).get(a);
                }
                media = media/2;
                System.out.println(media);
            }

        }

        // media dei voti per ciascun assignment
        System.out.println("--------- MEDIA VOTI PER SINGOLO ASSIGNMENT ---------");
        for(Assignment a : listaAssignment){
            int media = 0;
            int counter = 0;
            System.out.print("Media voti per l'assignment " + a.getAssignmentContent() + ": ");
            for(Student s : listaStudenti) {
                if (mappaVoti.get(s).containsKey(a)){
                    media += mappaVoti.get(s).get(a);
                    counter++;
                }
            }
            System.out.println(media/counter);
        }

    }


    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
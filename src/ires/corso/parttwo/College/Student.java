package ires.corso.parttwo.College;

import java.util.ArrayList;

public class Student
        implements IPrintable
{
    private final String idStudent;
    private final String studentName;
    private final String studentSurname;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();

    public Student(String idStudent, String studentName, String studentSurname) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses.addAll(enrolledCourses);
    }

    public void printEnrolledCourses() {
        for(Course c : enrolledCourses)
            c.prettyPrint();
    }

    public ArrayList<Course> getEnrolledCourses() {
        ArrayList<Course> enrolledCoursesCopy = new ArrayList<>();
        enrolledCoursesCopy.addAll(enrolledCourses);
        return enrolledCoursesCopy;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    @Override
    public void prettyPrint() {
        System.out.printf(  "----------------------------------\n" +
                        "|Nome:\t\t%s\n" +
                        "|Cognome:\t\t%s\n" +
                        "|Matricola:\t\t%s\n" +
                        "----------------------------------\n",
                studentName, studentSurname, idStudent);
    }
}


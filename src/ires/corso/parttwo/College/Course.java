package ires.corso.parttwo.College;

public class Course
        implements IPrintable
{
    private final String courseID;
    private final String courseName;
    private final String courseDepartment;

    public Course(String courseID, String courseName, String courseDepartment) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDepartment = courseDepartment;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public void prettyPrint() {
        System.out.printf(  "----------------------------------\n" +
                        "|ID corso:\t\t%s\n" +
                        "|Nome Corso:\t\t%s\n" +
                        "|Dipartimento:\t\t%s\n" +
                        "----------------------------------\n",
                courseID, courseName, courseDepartment);
    }
}
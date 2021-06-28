package ires.corso.parttwo.College;

public class Professor
        implements IPrintable
{
    private final String idProfessor;
    private final String professorName;
    private final String professorSurname;

    public Professor(String idProfessor, String professorName, String professorSurname) {
        this.idProfessor = idProfessor;
        this.professorName = professorName;
        this.professorSurname = professorSurname;
    }

    @Override
    public void prettyPrint() {
        System.out.printf(  "----------------------------------\n" +
                        "|Nome:\t\t%s\n" +
                        "|Cognome:\t\t%s\n" +
                        "|id:\t\t%s\n" +
                        "----------------------------------\n",
                professorName, professorSurname, idProfessor);
    }
}
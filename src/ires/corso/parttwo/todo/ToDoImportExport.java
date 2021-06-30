package ires.corso.parttwo.todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;


public class ToDoImportExport
{
    public static void ToDoImportExportMenu() throws IOException, ParseException {

        String choice = null;
        do {
            System.out.println( "---------------------------------------------------\n" +
                                "|                Import/Export menu               |\n" +
                                "---------------------------------------------------\n");

            Scanner scan = new Scanner(System.in);

            System.out.printf(  "[1] Import from file\n"    +
                                "[2] Export to file\n"      +
                                "[3] Back\n"                );

            choice = scan.nextLine();

            if (choice.equals("3"))
                return;
            else if (choice.equals("1")) {
                System.out.println("Loading...");
                ToDoRepository.loadFromFile();
            } else if (choice.equals("2")) {
                System.out.println("Exporting...");
                ToDoImportExport.writeFile(ToDoRepository.writeToFile());
            } else
                System.out.println("Invalid input. Please insert valid input.");

        } while(!(choice.equals("3")));

        return;
    }

    public static ArrayList<String[]> readNIOFile() throws IOException, ParseException {
        BufferedReader reader = null;
        String[] provaSplit = new String[7];
        ArrayList<String[]> raccolta = new ArrayList<>();
        try {
            Path inputFile = Paths.get("prova.txt");
            reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
            String lineFromFile = "";
            while ((lineFromFile = reader.readLine()) != null) {
                provaSplit = lineFromFile.split("\\|");
                raccolta.add(provaSplit);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (reader != null)
                reader.close();
        }
        System.out.println("Caricamento da file avvenuto.");
        return raccolta;
    }

    public static void writeFile(String[] outputString) throws IOException {
        BufferedWriter writer = null;
        try {
            Path outputFile = Paths.get("output.txt");
            writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset());
            for (String s : outputString){
                StringBuilder message = new StringBuilder(s + "\n");
                writer.append(message);
            }
        } catch (IOException e){
            System.out.println(e);
        } finally {
            if(writer != null)
                writer.close();
            System.out.println("Dati correttamente salvati su file.");
        }
    }
}

package ires.corso.parttwo.todo;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// GRUPPO 4:
public class ToDoRepository implements Serializable // sono un pirla e non ho usato il serializable
{
    /* GESTORE DELL'ARCHIVIO DEI TO-DO == DATABASE */

    // Contiene una HashMap di tutti i TO-DO a sistema:
    // - conversione della HashMap in formato adatto al salvataggio su file
    // - conversione in HashMap dei dati letti dal file di input dal metodo di lettura da file
    // - metodi per individuare, aggiungere, eliminare un TO-DO

    // Serializzabile con la funzione writeObject()

    static Map<Integer, ToDo> _data = new HashMap<>();

    /*              CLASS CONSTRUCTOR              */
    public ToDoRepository(Map<Integer, ToDo> _data) {
        this._data = _data;
    }

    // metodo che utilizza funzioni fornite dalla classe ToDoImportExport per generare una nuova istanza ToDoRepository
    public static ToDoRepository loadFromFile() throws IOException, ParseException {

        Map<Integer, ToDo> idMap= new HashMap<Integer, ToDo>();

        ArrayList<String[]> raccolta = ToDoImportExport.readNIOFile();

        for(String[] s: raccolta) {
            Date dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(s[5]);
            Date dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(s[6]);

            ToDo td = new ToDo(Integer.parseInt(s[0]),s[1],s[2], ToDo.Priority.valueOf(s[3]), ToDo.Status.valueOf(s[4]), dateStart, dateEnd);
            idMap.put(Integer.parseInt(s[0]),td);
        }

        System.out.printf("Repository istanziata correttamente. ToDo presenti in lista: %d\n", idMap.size());
        ToDoRepository repo = new ToDoRepository(idMap);

        return repo;
    }

    // farà l'opposto di loadFromFile: converte la repo in formato ArrayList<String[]> che può essere poi passato al metodo
    // di scrittura su file di ToDoImportExport
    public static String[] writeToFile() {
        String[] daSalvare = new String[_data.size()];
        int i = 0;
        String datePattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        for(Map.Entry<Integer, ToDo> m : _data.entrySet()){
            daSalvare[i] = String.valueOf(m.getKey()) + "|";
            daSalvare[i] += m.getValue().getToDoTitle() + "|";
            daSalvare[i] += m.getValue().getToDoDescription() + "|";
            daSalvare[i] += m.getValue().getToDoPriority() + "|";
            daSalvare[i] += m.getValue().getToDoStatus() + "|";
            daSalvare[i] += simpleDateFormat.format(m.getValue().getStartDate() )+ "|";
            daSalvare[i] += simpleDateFormat.format(m.getValue().getEndDate() );

            i++;
        }
        return daSalvare;
    }

    // getter del database per reference
    public static Map<Integer, ToDo> get_data() {
        return _data;
    }

    // getter della reference del To-Do avente dato ID
    public static ToDo getToDoFromID(Integer ID_given) {
        return _data.get(ID_given);
    }

    // utility [debug] - restituisce le dimensioni della hashmap, ovvero quanti To-Do ci ho caricato
    public static int repoSize() {
        return _data.size();
    }

    // questi due non li ho capitii
    private static ToDoRepository _repository = null;
    public static ToDoRepository getToDoRepository() {
        return _repository;
    }

    // rimuove il To-Do avente il corrispondete ID inserito
    public static void delete(Integer ID) {
        _data.remove(ID);
        System.out.printf("ToDo avente ID %d rimosso.\n", ID);
    };

    public static void add(ToDo t) {
        _data.put(t.getToDoID(),t);
        System.out.println("ToDo added to list.");
        // si deve entrare nell'oggetto t e leggere il suo ID
        // per poi salvarlo nella mappa correttamente (con put(ID, t))
    }

    // in realtà basta fare add di un To-Do modificato (fornisco la copia, la modifico, la sovrascrivo nel
    // database originale col metodo add (che usa put)
    public void update(ToDo t) {
        // si prende l'ID dall'oggetto t
        // si recupera dalla mappa il TO-DO corrispondente con get(t), per controllo
        // si sostituisce con put(ID, t)
    }
}
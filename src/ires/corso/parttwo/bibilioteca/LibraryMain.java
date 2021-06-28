package ires.corso.parttwo.bibilioteca;

import java.util.*;

public class LibraryMain
{
    public static void main(String[] args) {

        User u1 = new User("0001","Alda","Bianchi");
        User u2 = new User("0002","Gianni","Signori");
        User u3 = new User("0003","Lorenzo","Freddi");

        // distopia, fantasy, romanzo storico, giallo, thriller
        Category c1 = new Category("[c1]distopia", "Rappresentazione di una realtà alternativa rispetto a quella attuale, dalla quale però prende spunto per portare all’estremo alcune tendenze politiche o sociali considerate negativamente");
        Category c2 = new Category("[c2]fantasy", "Genere letterario dove prevalgono gli elementi fantastici");
        Category c3 = new Category("[c3]romanzo storico", "Racconto in cui le vicende sono inserite in un contesto storico ben preciso e dettagliato");
        Category c4 = new Category("[c4]giallo","Libri la cui trama ruota intorno a un crimine e alle indagini che portano alla soluzione del caso");
        Category c5 = new Category("[c5]thriller", "Storie in grado di tenere il lettore costantemente con il fiato in sospeso");

        Book b1 = new Book("rsgasfgagr", "[b1]Distopia fantastica", "Pluto","1950","650");
        Book b2 = new Book("rugikargvpob", "[b2]Distopia gialla","Eta Beta", "1961", "350");
        Book b3 = new Book("3r509fsdkln", "[b3]Giallo nella Firenze storica", "Pluto","1947", "130");
        Book b4 = new Book("237hnkfsd", "[b4]Thriller Storico", "Paperone","1975", "230");
        Book b5 = new Book("2348jho","[b5]Romanzo Storico Fantasy", "Paperoga", "1870","410");
        Book b6 = new Book("fas9f9sd", "[b6]Thriller Distopico","Topolino","1919","190");
        Book b7 = new Book("23490823", "[b7]Distopia e basta","Paperino","1986","250");
        Book b8 = new Book("32fj9f", "[b8]Un semplice giallo", "Banda Bassotti", "1987", "560");

        ArrayList<Category> b1cat = new ArrayList<Category>(Arrays.asList(c1,c2));
        ArrayList<Category> b2cat = new ArrayList<Category>(Arrays.asList(c1,c4));
        ArrayList<Category> b3cat = new ArrayList<Category>(Arrays.asList(c3,c4));
        ArrayList<Category> b4cat = new ArrayList<Category>(Arrays.asList(c3,c5));
        ArrayList<Category> b5cat = new ArrayList<Category>(Arrays.asList(c2,c3));
        ArrayList<Category> b6cat = new ArrayList<Category>(Arrays.asList(c1,c5));
        ArrayList<Category> b7cat = new ArrayList<Category>(Arrays.asList(c1));
        ArrayList<Category> b8cat = new ArrayList<Category>(Arrays.asList(c4));


        // assegno ad ogni categoria uno o più libri
        HashMap<Book, ArrayList<Category>> mappaCategorie = new HashMap<>();
        mappaCategorie.put(b1, b1cat);
        mappaCategorie.put(b2, b2cat);
        mappaCategorie.put(b3, b3cat);
        mappaCategorie.put(b4, b4cat);
        mappaCategorie.put(b5, b5cat);
        mappaCategorie.put(b6, b6cat);
        mappaCategorie.put(b7, b7cat);
        mappaCategorie.put(b8, b8cat);

        //voglio sapere quali libri appartengono a certe categorie?
        // ad esempio categoria Distopia (c1) [sol: b1, b2, b6, b7]

        System.out.println("Libri appartenenti alla categoria \"Distopia\": ");

        for(Map.Entry<Book, ArrayList<Category>> entry: mappaCategorie.entrySet()) {
            if(entry.getValue().contains(c1))
                System.out.println(entry.getKey().getBookTitle());
        }

        // se invece voglio sapere a quali categorie appartiene un certo libro?
        // ad esempio, b2 [sol:c1, c4]
        System.out.println("");
        System.out.printf("Categorie di appartenenza del libro %s:\n", b2.getBookTitle());

        for(Map.Entry<Book, ArrayList<Category>> entry: mappaCategorie.entrySet()) {
            if(entry.getKey().equals(b2)){
                for(Category cat : entry.getValue())
                    System.out.println(cat.getTitle());
            }
        }

        // adessi invece diamo alcuni libri in prestito
        // u1 -> b1, b7, b8
        // u2 -> b2, b3
        // u3 -> b4, b5

        ArrayList<Book> u1Loans = new ArrayList<Book>(Arrays.asList(b1,b7,b8));
        ArrayList<Book> u2Loans = new ArrayList<Book>(Arrays.asList(b2,b3));
        ArrayList<Book> u3Loans = new ArrayList<Book>(Arrays.asList(b4,b5));

        HashMap<User, ArrayList<Book>> mappaPrestiti = new HashMap<>();
        mappaPrestiti.put(u1,u1Loans);
        mappaPrestiti.put(u2,u2Loans);
        mappaPrestiti.put(u3,u3Loans);

        // facciamo una bella stampata a video di chi ha in prestito cosa
        // (per avere i prestiti di un utente specifico basta inserire un if seguendo il modello del for sopra)
        for(Map.Entry<User, ArrayList<Book>> entry : mappaPrestiti.entrySet()) {
            System.out.printf("Prestiti all'utente %s:\n",entry.getKey().getUserID());
            for(Book b: entry.getValue())
                System.out.println(b.getBookTitle());
            System.out.println("----------------------------------");
        }
        Integer counter1 = 0;
        Integer counter2 = 0;
        Integer counter3 = 0;
        Integer counter4 = 0;
        Integer counter5 = 0;

        HashMap<Category, Integer> categorie = new HashMap<>();
        categorie.put(c1, counter1);
        categorie.put(c2, counter2);
        categorie.put(c3, counter3);
        categorie.put(c4, counter4);
        categorie.put(c5, counter5);


        // come cavare dati statistici relativi alle categorie dei libri dati in prestito?
        // incrocio dei dati di mappaCategorie e mappaPrestiti

        // per ogni utente che ha prestiti, per ogni libro in prestito che ha, uso ogni singolo libro in prestito
        // come chiave di ricerca nella mappaCategorie

        // mapception
        for(Map.Entry<User, ArrayList<Book>> entry : mappaPrestiti.entrySet()) {
            for(Book b : entry.getValue()){ // per ogni libro in prestito da un certo utente
                for(Category cat : mappaCategorie.get(b)) {
                    Integer provvisorio = categorie.get(cat);
                    provvisorio++;
                    categorie.replace(cat, provvisorio);
                }
            }
        }

        // stampo i valori dei contatori

        for(Map.Entry<Category, Integer> entry : categorie.entrySet()){
            System.out.printf("Categoria %s: %d\n", entry.getKey().getTitle(), entry.getValue());
        }
    }
}
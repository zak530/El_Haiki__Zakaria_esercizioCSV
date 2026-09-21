import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GestioneStudenti {
    public void aggiungistudente(String nome, String cognome, String azienda, String vacanza) {

        System.out.println(nome);
        System.out.println(cognome);
        System.out.println(azienda);
        System.out.println(vacanza);
    }


    public int getId(String nomeFile, String valore) {

        int ultimoId = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/" + nomeFile));

            reader.readLine(); //salta l'intestazione

            String riga;

            while ((riga = reader.readLine()) != null) {

                String[] dati = riga.split(","); //divide in posizione dell'array i vari parametri divisi dalla virgola

                int id = Integer.parseInt(dati[0]); //all'interno della variabile 'id' inserisce l'id scritto nel file csv a posizione [0]

                ultimoId = id;

                if (dati[1].equals(valore)) {
                    reader.close(); // smette di leggere il file e lo chiude
                    return id;
                }
            }

            reader.close();

            //in caso il valore non esiste lo aggiunge
            int nuovoId = ultimoId + 1;

            FileWriter writer = new FileWriter("src/" + nomeFile, true); //filewriter è un oggetto che ci permette di scrivere ddentro un file, ed il true serve a far capire di aggiungere alla fine del file senza cancellare nulla.

            writer.write("\n" + nuovoId + "," + valore); //scrive nel file csv

            writer.close(); //chiude il file csv

            return nuovoId;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }


}
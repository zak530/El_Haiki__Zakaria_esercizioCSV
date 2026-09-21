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

    public void aggiungiNome(String nome) {

        try {
            FileWriter writer = new FileWriter("nomi.csv", true); //filewriter è un oggetto che ci permette di scrivere ddentro un file, ed il true serve a far capire di aggiungere alla fine del file senza cancellare nulla.

            writer.write(nome + "\n"); //scrive il contenuto nella variabile nome e va a capo

            writer.close(); //chiude il file

        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file"); //eccezzione che esce in output in caso di errore
        }
    }


    public void leggiNomi() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/nomi.csv"));  //il buffer reader ci permettere di leggere riga per riga il file nomi.csv che si trova in all'interno del project(in src)
            reader.readLine(); //permette di saltare la prima riga del csv (che contiene solol'intestazione)
            String riga;

            while ((riga = reader.readLine()) != null) {  //affinche ci sono delle righe il programma va avanti a scorrere fino alla fine

                String[] dati = riga.split(","); //divido il testo ogni colta che trova una virgola

                System.out.println("ID: " + dati[0]);
                System.out.println("Nome: " + dati[1]);
            }

            reader.close(); //una volta finito di leggere nomi.csv il programma chiude il file

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}

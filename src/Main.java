public class Main {

    public static void main(String[] args) {

        GestioneStudenti gestione = new GestioneStudenti();


        gestione.aggiungistudente("mazzoleni", "federico", "scuola", "toscana");
        gestione.cercaStudentepernome("mazzoleni");



    }
}
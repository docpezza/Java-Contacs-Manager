import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import service.RubricaService;
import model.Contatto;
import model.ContattoAzienda;
import model.ContattoPrivato;

public class FileRepository {

    private RubricaService service;

    public void carica(){
        try{
	BufferedReader br = new BufferedReader(new FileReader("file.txt"));
	String riga;
	while ((riga = br.readLine()) !=null){
	String[] pezzi = riga.split(",");
	if(pezzi[3].length() == 16){
	service.aggiungiContatto(new ContattoPrivato(pezzi[0], pezzi[1], pezzi[2],pezzi[3]));
	} else { service.aggiungiContatto(new ContattoAzienda(pezzi[0], pezzi[1], pezzi[2], pezzi[3]));
}
}br.close();
    } catch (Exception e) {
        System.out.println("Errore nel caricamento dei contatti!");
    }
    }

    public void salva() {
    // Il try-with-resources gestisce l'apertura e la CHIUSURA automatica
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"))) {
        for (Contatto c : service.getTutti()) {
            bw.write(c.toCsv());
            bw.newLine();
        }
        System.out.println("Salvataggio completato con successo.");
    } catch (IOException e) {
        // Qui gestiamo l'errore che il Main ti stava segnalando in rosso
        System.err.println("Errore durante il salvataggio: " + e.getMessage());
    }
}
}

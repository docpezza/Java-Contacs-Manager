import service.RubricaService;
import model.*;
import exception.ContactNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;

public class Main{
	static Scanner sc = new Scanner(System.in);
    static BufferedWriter bw;
	static boolean esci = false;
	static boolean emailValida = false;
	static RubricaService service = new RubricaService();
    static FileRepository repository = new FileRepository();


	public static void main(String[] args) {
        repository.carica(); // Carica i contatti all'avvio del programma
	while(!esci){
	System.out.println("1. Aggiungi Contatto \n 2. Mostra tutti \n 3. Cerca contatto \n 4. Elimina contatto \n 5. Modifica Contatto \n 6. Esci");
	System.out.println("Inserire il numero della scelta desiderata: ");
	int scelta = sc.nextInt();
	sc.nextLine();	
	if (scelta == 1) {
	aggiungiContatto();
}
	else if (scelta == 2) {
	ArrayList<Contatto> tutte = service.getTutti();
	for (Contatto c : tutte){
	c.stampaScheda();
	System.out.println(".........");
   }
}
	else if (scelta == 3) {
	cercaContatto();
  }
	else if (scelta == 4) {
	System.out.println("Inserire nome da eliminare: ");
	String n = sc.nextLine();
	if(service.elimina(n)){
	System.out.println("Eliminato con successo!");
	}else{
	System.out.println("Nessun contatto trovato!");}
   }
	else if (scelta == 5) {
        System.out.println("Inserire il nome contatto da modificare: ");
        String n = sc.nextLine();

        for (Contatto c : service.getTutti()) {
            if (c.getNome().equalsIgnoreCase(n)) {
                System.out.println("Cosa vuoi modificare? \n 1. Nome \n 2. Telefono \n 3. Email");
                int s = sc.nextInt();
                sc.nextLine();
                if (s == 1) {
                    System.out.println("Nuovo nome: ");
                    c.setNome(sc.nextLine());
                } else if (s == 2) {
                    System.out.println("Nuovo telefono: ");
                    c.setTelefono(sc.nextLine());
                } else if (s == 3) {
                    System.out.println("Nuova email: ");
                    c.setEmail(sc.nextLine());
                }
            }
        }
    } 
	else if (scelta == 6) {
         System.out.println("Avvio salvataggio...");
        repository.salva(); // Chiama il metodo che abbiamo appena creato
         esci = true;
}
            esci = true; 
    }
}    
	public static void cercaContatto() {
    System.out.println("Inserire nome da cercare: ");
    String n = sc.nextLine();
    
    try {
        // Proviamo a chiamare il service
        Contatto trovato = service.cercaPerNome(n);
        trovato.stampaScheda();
    } catch (ContactNotFoundException e) {
        // Se il service lancia l'eccezione, finiamo qui dentro
        System.out.println("ERRORE: " + e.getMessage());
    }
}
	public static void aggiungiContatto() {
    String mail = "";
    boolean mailCorretta = false;   
    
    System.out.println("Nome: "); String nome = sc.nextLine();
    System.out.println("Telefono: "); String tel = sc.nextLine();
    
    while (!mailCorretta) { 
        System.out.println("Email: "); 
        mail = sc.nextLine(); 
        if (mail.contains("@")) {
            mailCorretta = true;
        } else { 
            System.out.println("Inserisci una mail corretta!");
        }
    }

    System.out.println("Conferma tipo (1. Privato / 2. Azienda):");
    int c = sc.nextInt();
    sc.nextLine();
    
    if (c == 1) {
        System.out.println("Codice Fiscale: ");
        String cf = sc.nextLine();
        service.aggiungiContatto(new ContattoPrivato(nome, tel, mail, cf));
    } else {
        System.out.println("Partita iva: ");
        String piva = sc.nextLine();
        service.aggiungiContatto(new ContattoAzienda(nome, tel, mail, piva));
    }
}
}
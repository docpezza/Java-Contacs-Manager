package service;
import model.Contatto; // 2. Importa la classe Contatto perché è in un altro package
import exception.ContactNotFoundException;

import java.util.ArrayList;
public class RubricaService {
	ArrayList<Contatto> lista = new ArrayList(); //creamo array lista
	
	public void aggiungiContatto(Contatto nuovoContatto){ //funzione che aggiunge un contatto
		lista.add(nuovoContatto);
	}
	public ArrayList<Contatto> getTutti(){
		lista.sort((c1,c2) -> c1.getNome().compareToIgnoreCase(c2.getNome()));
		return lista;
	}
	public boolean elimina(String nomeDaCancellare){
		return lista.removeIf(Contatto -> Contatto.getNome().equalsIgnoreCase(nomeDaCancellare));
}
	public Contatto cercaPerNome (String nome) throws ContactNotFoundException{
	return lista.stream()
		.filter(c -> c.getNome().equalsIgnoreCase(nome))
		.findFirst()
		.orElseThrow(() -> new ContactNotFoundException("Il contatto " + nome + "non esiste!"));
}
}
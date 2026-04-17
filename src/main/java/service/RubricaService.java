package service;
import model.Contatto; // 2. Importa la classe Contatto perché è in un altro package
import exception.ContactNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class RubricaService {
private Map<String, Contatto> rubrica = new HashMap<>();
	
	public void aggiungiContatto(Contatto nuovoContatto){ //funzione che aggiunge un contatto
		rubrica.put(nuovoContatto.getNome(), nuovoContatto);
	}
	public ArrayList<Contatto> getTutti(){
		return new ArrayList<>(rubrica.values());
	}
	public boolean elimina(String nomeDaCancellare){
		return rubrica.remove(nomeDaCancellare) != null;
	}
	public Contatto cercaPerNome (String nome) throws ContactNotFoundException{
	return rubrica.get(nome);
}
}
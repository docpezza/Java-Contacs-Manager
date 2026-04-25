package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true) // Importante per confrontare correttamente oggetti che ereditano

public class ContattoAzienda extends Contatto {
	private String partitaIva;

    // Costruttore manuale (Lombok fatica con l'ereditarietà dei costruttori del padre)
    public ContattoAzienda(String nome, String telefono, String email, String partitaIva) {
        super(nome, telefono, email);
        this.partitaIva = partitaIva;
    }
		
	@Override //richiamo stampa scheda di Contatto ma modifico dei pezzi
	public void stampaScheda() {
	super.stampaScheda();
	System.out.println("P.Iva: " + partitaIva);
	}
}
package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contatto { //costruttore
	private String nome;
	private String telefono;
	private String email;
	private LocalDate dataInserimento;

	public void stampaScheda() { //stampa a monitor la scheda contatto
	System.out.println("Nome: " + nome + "," + "Telefono: " + telefono + "," + "Email: " + email);
 }
}
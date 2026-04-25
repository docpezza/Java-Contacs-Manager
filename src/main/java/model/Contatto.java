package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class Contatto { //costruttore
	private String nome;
	private String telefono;
	private String email;

	public abstract String toCsv();

	public void stampaScheda() { //stampa a monitor la scheda contatto
	System.out.println("Nome: " + nome + "," + "Telefono: " + telefono + "," + "Email: " + email);
 }
}
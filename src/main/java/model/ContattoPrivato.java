package model;
public class ContattoPrivato extends Contatto {

	private String codiceFiscale;

	public ContattoPrivato(String nome, String telefono, String email, String codiceFiscale){

	super(nome, telefono, email);
	this.codiceFiscale = codiceFiscale;
	}
	
	public String getCodiceFiscale(){ //metodo get per passare il codice fiscale
	return codiceFiscale;
	}

	@Override
public String toCsv() {
    return String.format("%s,%s,%s,%s", getNome(), getTelefono(), getEmail(), codiceFiscale);
}

	@Override
	public void stampaScheda() {
	super.stampaScheda();
	System.out.println("C. Fiscale: " + codiceFiscale);
	}
}
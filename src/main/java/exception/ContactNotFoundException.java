package exception;

public class ContactNotFoundException extends Exception{ //creamo un eccezione personale da poter chiamare quando vogliamo
	public ContactNotFoundException(String messaggio){
	super(messaggio);
}
}
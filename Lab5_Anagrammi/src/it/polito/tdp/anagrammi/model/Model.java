package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private List<String> corrette;
	private List<String> errate;
	private String parziale;
	private AnagrammaDAO dao ;

	public Model() {
		parziale = "";
		corrette = new ArrayList<String>();
		errate = new ArrayList<String>();
		dao = new AnagrammaDAO();
	}
	
	private void recursive(String parola, String anagrammaParziale, int livello) {
		
		if(livello == parola.length()) {	//se l'anagramma è completo
			if(dao.isCorrect(anagrammaParziale)) {	//controllo che l'anagramma esiste consultando il dizionario
				corrette.add(anagrammaParziale);	// se il metodo isCorrect() ritorna true allora la parola esiste nel dizionario
			}
			else {
				errate.add(anagrammaParziale);
			}
			return;
		}
				
		for(int i =0; i< parola.length(); i++) {
			if(this.conta(parola.charAt(i), parola) > this.conta(parola.charAt(i), anagrammaParziale)) { //FILTRO
				anagrammaParziale += parola.charAt(i);
				
				this.recursive(parola, anagrammaParziale, livello+1);
				
				anagrammaParziale = anagrammaParziale.substring(0,anagrammaParziale.length()-1);  //BACKTRACKING,elimino l'ultima lettera
			}
			
		}
		
	}
	
	public int conta(Character prova, String parola ) {
		int contatore= 0 ;
		for(int i = 0; i< parola.length(); i++) {
			if(prova.equals(parola.charAt(i))) {
				contatore ++;
			}
		}
		return contatore;
	}
	
	public List<String> getAnagrammiCorretti(String parola){
		corrette.clear();
		this.recursive(parola, parziale, 0);
		return corrette;
	}
	
	public List<String> getAnagrammiErrati(String parola){
		errate.clear();
		this.recursive(parola, parziale, 0);
		return errate;
	}
	
	
	public String toString(List<String> parole ) {
		String lista = "";
		for(String s : parole) {
			if(!lista.contains(s))	//per non avere anagrammi duplicati
				lista += s +"\n";	
			
		}
		return lista.trim();
	}
}

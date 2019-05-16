package it.polito.tdp.spellchecker.model;
import java.util.*;

public class TestModel {

	public static void main(String[] args) {
		
	
		// TODO Auto-generated method stub
		Dictionary dizionario= new Dictionary();
		
		List<String> parole= new LinkedList<String>();
		
		dizionario.loadDictionary("italian");
		
		parole= dizionario.textInput("sno una pazra scatenta vediamo se funziona");
		List<RichWords> controllate= dizionario.spellCheckText(parole);;
		for(RichWords w: controllate) {
			if(w.isCorretta()==false) {
				System.out.println(w.getRichWord());
			}
		}
	}

}

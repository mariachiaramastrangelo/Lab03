package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;



public class Dictionary {
	Map<String, String> dizionario= new TreeMap<String, String>();
	
	public void loadDictionary(String language) {
		
		if(language.equals("italian")) {
			try {
				FileReader fr= new FileReader("rsc/Italian.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					dizionario.put(word, word);
				}
				
			}catch(IOException e) {
				System.out.println("Errore nel caricamento del dizionario");
			}
			
		}
		else if(language.equals("english")) {
			try {
				FileReader fr= new FileReader("rsc/English.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					dizionario.put(word, word);
				}
				
			}catch(IOException e) {
				System.out.println("Errore nel caricamento del dizionario");
			}
		}
	}

	public Map<String, String> getDizionario() {
		return dizionario;
	}

	public void setDizionario(Map<String, String> dizionario) {
		this.dizionario = dizionario;
	}
	public  List<String> textInput(String input){
		List<String> parole= new LinkedList<String>();
		input = input.replaceAll("\n", " ");
		input = input.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
		input.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String s[]= input.split(" ");
		for(String p: s) {
			parole.add(p);
		}
		return parole;
	}

	
	public List<RichWords> spellCheckText(List<String> inputTextList){
		List<RichWords> checked= new LinkedList<RichWords>();
		for(String s: inputTextList) {
			if(this.dizionario.containsKey(s)) {
				checked.add(new RichWords(s, true));
			}else {
				checked.add(new RichWords(s, false));
			}
		}
		return checked;
	}
	
	
}

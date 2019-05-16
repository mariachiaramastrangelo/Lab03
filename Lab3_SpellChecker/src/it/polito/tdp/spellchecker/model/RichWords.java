package it.polito.tdp.spellchecker.model;

public class RichWords {
	private String richWord;
	private boolean corretta;
	
	
	public RichWords(String richWord, boolean corretta) {
		super();
		this.richWord = richWord;
		this.corretta = corretta;
	}


	public String getRichWord() {
		return richWord;
	}


	public boolean isCorretta() {
		return corretta;
	}
	
	
}

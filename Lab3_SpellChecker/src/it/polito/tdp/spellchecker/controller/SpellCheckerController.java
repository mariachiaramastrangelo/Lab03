package it.polito.tdp.spellchecker.controller;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWords;


import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class SpellCheckerController {
	
	
	


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> language;

    @FXML
    private TextArea inserimento;

    @FXML
    private TextArea risultato;
    
    @FXML
    private Label errori;

    @FXML
    private Button spellCheck;
    

    @FXML
    private Button clearText;
    
    @FXML
    private Label time;
    
    
    private Dictionary dizionario= new Dictionary();;
    @SuppressWarnings("unused")
	private Dictionary model;
    private int counter;
    public void setModel(Dictionary model) {
		this.model = model;
		language.getItems().addAll("italian", "english");
		counter=0;
		this.risultato.setText("Select a language!");
	}
    @FXML
    void doActivation(ActionEvent event) {
    	if(language.getValue()==null) {
    		this.spellCheck.setDisable(true);
    		this.clearText.setDisable(true);
    		this.inserimento.setDisable(true);
    		this.risultato.clear();
    		
    	}else {
    		this.spellCheck.setDisable(false);
    		this.clearText.setDisable(false);
    		this.inserimento.setDisable(false);
    		this.risultato.setText("");
    	}
    }
	
    @FXML
    void doClearText(ActionEvent event) {
    	inserimento.clear();
    	risultato.clear();
    	language.setValue(null);
    	counter=0;
    	errori.setText("Errori");
    	time.setText("Tempo");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	if(!dizionario.loadDictionary(language.getValue())) {
    		this.risultato.setText("Errore caricamento del risultato");
    		return;
    	}
    	if(this.inserimento.getText().isEmpty()) {
    		this.risultato.setText("Scrivi qualcosa cretino per carità");
    		return;
    	}
    	
    	dizionario.loadDictionary(language.getValue());
    	//long startTime = System.nanoTime();
    	long start = System.nanoTime();
    	List<RichWords> checked= dizionario.spellCheckText(dizionario.textInput(inserimento.getText()));
		for(RichWords w: checked) {
			if(w.isCorretta()==false) {
				risultato.appendText(w.getRichWord()+"\n");
				counter++;
				
			}
		}
		long end = System.nanoTime();
		if(risultato.getText()!=null) {
			errori.setText("Errori:"+counter);
		}else {
			errori.setText("Errori: 0");
		}
		
		time.setText("Spell check completed in "+ (end-start)/ 1E9+"s");
		//this.time.setText("tempo impiegato: "+totalTime);
	  }
    
	

    @FXML
    void initialize() {
    	 assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert inserimento != null : "fx:id=\"inserimento\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert errori != null : "fx:id=\"errori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert spellCheck != null : "fx:id=\"spellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert clearText != null : "fx:id=\"clearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'SpellChecker.fxml'.";
    }
}

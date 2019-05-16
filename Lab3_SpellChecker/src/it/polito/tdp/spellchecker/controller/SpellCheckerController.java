package it.polito.tdp.spellchecker.controller;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWords;


import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class SpellCheckerController {
	
	private Dictionary model;

	public void setModel(Dictionary model) {
		this.model = model;
		language.getItems().addAll("italian", "english");
		counter=0;
	}

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


    private Dictionary dizionario= new Dictionary();;
	
    private int counter;
	
	
    @FXML
    void doClearText(ActionEvent event) {
    	inserimento.clear();
    	risultato.clear();
    	counter=0;
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	dizionario.loadDictionary(language.getValue());
    	List<RichWords> checked= dizionario.spellCheckText(dizionario.textInput(inserimento.getText()));
		for(RichWords w: checked) {
			if(w.isCorretta()==false) {
				risultato.setText(w.getRichWord()+"\n");
				counter++;
				
			}
		}
		if(risultato.getText()!=null) {
			errori.setText("Errori:"+counter);
		}else {
			errori.setText("Errori: 0");
		}
    }
    
	

    @FXML
    void initialize() {
    	 assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert inserimento != null : "fx:id=\"inserimento\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'SpellChecker.fxml'.";
         assert errori != null : "fx:id=\"errori\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}

package it.polito.tdp.spellchecker.controller;

import it.polito.tdp.spellchecker.model.Dictionary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;


public class SpellCheckerController {
	private Dictionary model;

	public void setModel(Dictionary model) {
		this.model = model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton language;

    @FXML
    private TextArea inserimento;

    @FXML
    private TextArea risultato;

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert inserimento != null : "fx:id=\"inserimento\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}

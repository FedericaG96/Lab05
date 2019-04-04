package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagramma;

    @FXML
    private TextArea txtCorrette;

    @FXML
    private TextArea txtErrate;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagramma(ActionEvent event) {
    	String parolaInserita = txtParola.getText();
    	txtCorrette.setText(model.toString(model.getAnagrammiCorretti(parolaInserita)));
    	
    	txtErrate.setText((model.toString(model.getAnagrammiErrati(parolaInserita))));
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtErrate.clear();
    	txtCorrette.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolaAnagramma != null : "fx:id=\"btnCalcolaAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorrette != null : "fx:id=\"txtCorrette\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrate != null : "fx:id=\"txtErrate\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
    	
		this.model = model;
		
	
		}
}


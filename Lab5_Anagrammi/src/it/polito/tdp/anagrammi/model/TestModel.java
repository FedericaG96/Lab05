package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {
	
	public void run() {
		Model model = new Model();
		List<String> anagrammi = new ArrayList<String>();
		
		anagrammi = model.getAnagrammiCorretti("eat");
		for (String s : anagrammi) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		TestModel main = new TestModel();
		main.run();

	}

}

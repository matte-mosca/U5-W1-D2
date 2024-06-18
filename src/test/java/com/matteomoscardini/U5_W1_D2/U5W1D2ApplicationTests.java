package com.matteomoscardini.U5_W1_D2;

import entities.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SpringBootTest
class U5W1D2ApplicationTests {

	@Autowired
	private Menu menu;


	@Test
	void contextLoads() {
	}

	@Test
	public void testStringAliments(){
		PrintStream oldOut = System.out;

		// Crea un nuovo stream di output per catturare l'output
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		try {
			// Esegue il metodo che stampa al System.out
			menu.printMenu();;
		} finally {
			// Ripristina il vecchio System.out
			System.setOut(oldOut);
		}

	}

}

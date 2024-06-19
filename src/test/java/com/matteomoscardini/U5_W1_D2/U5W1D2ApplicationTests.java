package com.matteomoscardini.U5_W1_D2;

import entities.Menu;
import entities.Table;
import entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5W1D2ApplicationTests {

	@Autowired
	private Menu menu;

	@Autowired
	ArrayList<Table> tables;

	@Value("${order.coverPrice}")
	private double coverPrice;

	@Test
	public void checkCoverPrice(){
		assertEquals(coverPrice, 1.5);
	}

	@Test
	public void testStringAliments(){
		PrintStream oldOut = System.out;

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		try {
			menu.printMenu();;
		} finally {
			System.setOut(oldOut);
		}
		String printedOutput = outContent.toString();
		long lineCount = printedOutput.lines().count();
		System.out.println("Il metodo printMenu ha stampato: " +lineCount+ " righe. Il Menu è composto di " +menu.getMenuArrayList().size() + " elementi");
		assertEquals(menu.getMenuArrayList().size(), lineCount);
	}
}

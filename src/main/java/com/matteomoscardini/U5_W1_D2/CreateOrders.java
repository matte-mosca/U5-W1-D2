package com.matteomoscardini.U5_W1_D2;

import entities.Aliment;
import entities.Menu;
import entities.Order;
import entities.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Scanner;

@Component
public class CreateOrders implements CommandLineRunner {

    @Value("${order.coverPrice}")
    private double coverPrice = 2;
    @Autowired
    private Menu menu;
    @Autowired
    ArrayList<Table> tables;

    @Override
    public void run(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean goOn = true;
            while (goOn) {
                System.out.println("Choose an option");
                System.out.println("1: Open the menu");
                System.out.println("2: Look at the tables");
                System.out.println("3: Take an order");
                System.out.println("0 exit");


                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        menu.printMenu();
                        break;
                    case "2":
                        tables.forEach(table -> System.out.println("Table number: " + table.getNumber() + table.getState()));
                    case "3":
                        System.out.println("Choose your table");
                        tables.stream()
                                .filter(table -> table.getState() == Table.state.FREE)
                                .forEach(table -> System.out.println("Table number: " + table.getNumber()));
                        int numberTable = scanner.nextInt();
                        scanner.nextLine();
                        Table choosenTable = tables.stream()
                                .filter(table -> table.getNumber() == numberTable && table.getState() == Table.state.FREE)
                                .findFirst()
                                .orElse(null);

                        if (choosenTable == null) {
                            System.out.println("The number of this table is reserved, or it doesn't exist");
                            break;
                        }
                        Order order = new Order();
                        order.setTableXOrder(choosenTable);
                        order.setOrderState(Order.OrderState.PREPARATION);

                        boolean addAliments = true;
                        while (addAliments) {
                            menu.printOrdersMenu();
                            System.out.println("Choose the number of the aliment you want to add or 0 to finish");
                            int alimentChosen = scanner.nextInt();
                            scanner.nextLine();

                            if (alimentChosen == 0) {
                                addAliments = false;
                            } else {
                                Aliment chosenALiment = menu.getAliment(alimentChosen);
                                if (chosenALiment != null) {
                                    order.addAliment(chosenALiment);
                                    System.out.println("Aliment added to order");
                                } else {
                                    System.out.println("Wrong selection");
                                }
                            }
                        }

                        double totalCost = order.checkCalculation(coverPrice);
                        System.out.println("Order completed. Cost amount = $ " + totalCost);
                        choosenTable.setState(Table.state.RESERVED);
                        break;

                    case "0":
                        goOn = false;
                        break;
                    default:
                        System.out.println("Wrong selection");
                        break;
                }
            }
        }
    }

}

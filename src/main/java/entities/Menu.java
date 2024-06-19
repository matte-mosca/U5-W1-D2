package entities;

import java.util.ArrayList;

public class Menu {
    ArrayList<Aliment> menu;

    public Menu (){
        this.menu = new ArrayList<>();
    }

    public void addAliment (Aliment aliment) {
        this.menu.add(aliment);
    }

    public void printMenu(){
        menu.forEach(aliment -> System.out.println(aliment));
    }
    public void printOrdersMenu () {
        int row = 1;
        for (Aliment aliment : menu) {
            if (!(aliment instanceof Topping)) {
                System.out.println(row + ": " + aliment);
                row++;
            }
        }
    }
    public Aliment getAliment (int alimentChosen) {
        return menu.get(alimentChosen-1);
    }
    public ArrayList<Aliment> getMenuArrayList () {
        return this.menu;
    }

    }




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

}

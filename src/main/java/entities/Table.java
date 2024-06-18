package entities;

import java.util.ArrayList;

public class Table {

    public enum state{
        FREE, RESERVED
    }
    private int number;
    ArrayList<Aliment> orders;
    private int places;
    private state state;

    public Table(int number, ArrayList<Aliment> orders, int places, Table.state state) {
        this.number = number;
        this.orders = orders;
        this.places = places;
        this.state = state;
    }

    public Table (int number, int places, Table.state state) {
        this.number = number;
        this.places = places;
        this.orders = null;
        this.state = state;
    }
    public int getNumber(int number){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Aliment> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Aliment> orders) {
        this.orders = orders;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public Table.state getState() {
        return state;
    }

    public void setState(Table.state state) {
        this.state = state;
    }
}

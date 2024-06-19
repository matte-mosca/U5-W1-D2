package entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor

public class Orders {

    private static int ordersQuantity = 0;

    public void addAliment (Aliment selectedAliment) {
        this.orders.add(selectedAliment);
    }
    public enum OrderState {
        PREPARATION, READY, SERVED;
    }

    private int orderID;
    private OrderState orderState;
    private Table tableXOrder;
    private int places;

    @Setter
    private ArrayList<Aliment> orders;

    public Orders(){
        this.orderID = ordersQuantity++;
        this.orderState = orderState.PREPARATION;
        this.orders = new ArrayList<Aliment>();
    }

    public Orders (OrderState orderState, Table tableXOrder, int places) {
        this.orderID = ordersQuantity++;
        this.orderState = orderState;
        this.tableXOrder = tableXOrder;
        this.places = places;
        this.orders = new ArrayList<>();
    }

    public double checkCalculation (double coverPrice) {
        double check = 0;
        for (Aliment aliment : this.getOrders()) {
            check += aliment.getPrice();
        }
    }

}

package entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Aliment{

    @Getter
    private List<Topping> ingredients;
    private Size size;

    public Pizza(){
        super();
    }
    public enum Size{
        SIMPLE, BIG
    }

    public Pizza (String name, Double price,int calories, List<Topping> ingredients, Size size ){
        super(name, price, calories);
        this.ingredients = new ArrayList<>(ingredients);
        this.size = size;
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + size + " "+ name + "with " +calories+ " calories";
    }
    public String getSize(){
        return this.size.toString();
    }
    public void addTopping(Topping topping) {
        this.ingredients.add(topping);
    }
}

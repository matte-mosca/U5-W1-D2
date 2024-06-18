package entities;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public abstract class Aliment {
    protected String name;
    protected Double price;
    protected int calories;

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+ " " +name+ " ,calories: "+calories+ "       "+ price+ " £";
    }

    public Aliment(){

    }
}

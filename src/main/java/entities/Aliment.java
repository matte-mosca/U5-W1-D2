package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

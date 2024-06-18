package com.matteomoscardini.U5_W1_D2;

import entities.Drink;
import entities.Menu;
import entities.Pizza;
import entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.awt.*;
import java.util.ArrayList;

@Configuration
@PropertySource("application.properties")
public class MenuConf {
    @Bean
    public Topping tomato() {
        return new Topping("tomato", 0.5, 20);
    }
    @Bean
public Topping mozzarella (){
        return new Topping("mozzarella", 0.8, 90);
    }
    @Bean
    public Topping ananas () {
        return new Topping("Ananas", 1.0, 30 ) ;
    }
    @Bean
    public Topping ham () {
        return new Topping("Ham", 0.8, 45);
    }
    @Bean
    public Topping mashroom (){
        return new Topping("Mashroom", 1.8, 50);
    }
    @Bean
    public Topping sausage () {
        return new Topping("Sausage", 1.45, 75);
    }
    @Bean
    public Topping peppers () {
        return new Topping("Peppers", 0.75, 50);
    }
    @Bean
    public Topping anchovies () {
        return new Topping("Anchovies", 1.25, 65);
    }
    @Bean
    public Topping bufalaMozzarella(){
        return new Topping("Bufala Mozzarella", 2, 90);
    }

    @Bean
    public Pizza margherita () {
        ArrayList<Topping> margheritasIngredients = new ArrayList<>();
        margheritasIngredients.add(tomato());
        margheritasIngredients.add(mozzarella());
        Pizza pizza = new Pizza("Margherita", 5.5, 1110, margheritasIngredients, Pizza.Size.SIMPLE);
        return pizza;
    }
    @Bean
    public Pizza bigMargherita(){
        ArrayList<Topping> margheritasIngredients = new ArrayList<>();
        margheritasIngredients.add(tomato());
        margheritasIngredients.add(mozzarella());
        Pizza pizza = new Pizza("Big Margherita", 9.5, 1610, margheritasIngredients, Pizza.Size.BIG);
        return pizza;
    }
    @Bean
    public Pizza hawaii() {
        ArrayList<Topping> hawaiiIngredients = new ArrayList<>();
        hawaiiIngredients.add(tomato());
        hawaiiIngredients.add(mozzarella());
        hawaiiIngredients.add(ananas());
        hawaiiIngredients.add(ham());
        Pizza pizza = new Pizza("Hawaii", 7.3, 1185, hawaiiIngredients, Pizza.Size.SIMPLE );
        return pizza;
    }

    @Bean
    public Pizza bufala () {
        ArrayList<Topping> bufalaIngredients = new ArrayList<>();
        bufalaIngredients.add(tomato());
        bufalaIngredients.add(mozzarella());
        bufalaIngredients.add(bufalaMozzarella());
        Pizza pizza = new Pizza("Bufala", 7.5, 1200, bufalaIngredients, Pizza.Size.SIMPLE);
        return pizza;
    }
    @Bean
    public Drink coke (){
        return new Drink("Coke", 2, 180);
    }
    @Bean
    public Drink water (){
        return new Drink("Water", 1.5, 0);
    }
    @Bean
    public Drink fanta (){
        return new Drink("Fanta", 2, 180);
    }
    @Bean
    public Drink beer (){
        return new Drink("Beer", 3.5, 200);
    }
   @Bean
    public Menu menu () {
        Menu menu = new Menu();
        menu.addAliment(margherita());
        menu.addAliment(bigMargherita());
        menu.addAliment(bufala());
        menu.addAliment(hawaii());
        menu.addAliment(coke());
        menu.addAliment(fanta());
        menu.addAliment(beer());
        menu.addAliment(water());
        menu.addAliment(tomato());
        menu.addAliment(mozzarella());
        menu.addAliment(bufalaMozzarella());
        menu.addAliment(ham());
        menu.addAliment(ananas());
        menu.addAliment(sausage());
        menu.addAliment(anchovies());
        menu.addAliment(peppers());
        return menu;
   }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kebsarc.cit.pizzahouse;

import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**
 * is a list for all the stuff you want to buy.
 */
public class PizzaCart extends AbstractListModel<String> {
    
    Drinks drinks = new Drinks();
    Sides sides = new Sides();
    Pizzas pizzas = new Pizzas();
    Desserts desserts = new Desserts();
    private JTextField orderTotalField;
    
    public PizzaCart() {
    }
    
    ListModel<String> getPizzas() {
        return this.pizzas;
    }
    
    void addPizza(String name) {
        this.pizzas.add(name);
        updateOrderField();
        
    }
    
    ListModel<String> getOrders() {
        return this;
    }
    
    /**
     * returning the sum of all sub carts
     */
    @Override
    public int getSize() {
        return pizzas.getSize() + sides.getSize() + drinks.getSize() + desserts.getSize();
    }
    
    /**
     * 
     * @param index is the index of the element in the cart that you want to see
     * @return the name of the item in the cart
     */
    @Override
    public String getElementAt(int index) {
        // if this index is part of the pizza list then it returns the pizza
        if (index < pizzas.getSize())  {
            return pizzas.getElementAt(index);
        }
        
        // if the index is within the sides subcart then return the cart element 
        if (index < pizzas.getSize() + sides.getSize()) {
            return this.sides.getElementAt(index - pizzas.getSize());
        }
        
        //
        if (index < pizzas.getSize() + sides.getSize() + drinks.getSize()) {
            return this.drinks.getElementAt(index - pizzas.getSize() - sides.getSize());
        }
        return this.desserts.getElementAt(index - pizzas.getSize() - sides.getSize() - drinks.getSize());
    }
    
    
    ListModel<String> getDesserts() {
        return this.desserts;
    }
    
    void addDessert(String name) {
        this.desserts.add(name);
        updateOrderField();
        
    }
    
    void addSide(String name) {
        this.sides.add(name);
        updateOrderField();
    }
    
    ListModel<String> getSides() {
        return this.sides;
        
    }
    
    void addDrink(String name) {
        this.drinks.add(name);
        updateOrderField();
    }
    
    ListModel<String> getDrinks() {
        return this.drinks;
    }
    
    /**
     * give cost of all items added to cart
     * @return 
     */
    String getTotal() {
        int total = pizzas.getSize() * 10;
        total += sides.getSize() * 5;
        total += drinks.getSize() * 3;
        total += desserts.getSize() * 7;
        
        return "$" + total + ".00";
        
    }
    
    void registerTotalField(JTextField jTextField1) {
        this.orderTotalField = jTextField1;
        updateOrderField();
    }
    
    void updateOrderField() {
        this.orderTotalField.setText(getTotal());
    }
}

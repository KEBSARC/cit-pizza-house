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
 *
 * @author kebsarc
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
    
    @Override
    public int getSize() {
        return pizzas.getSize() + sides.getSize() + drinks.getSize() + desserts.getSize();
    }
    
    @Override
    public String getElementAt(int i) {
        if (i < pizzas.getSize()) {
            return pizzas.getElementAt(i);
        }
        if (i < pizzas.getSize() + sides.getSize()) {
            return this.sides.getElementAt(i - pizzas.getSize());
        }
        if (i < pizzas.getSize() + sides.getSize() + drinks.getSize()) {
            return this.drinks.getElementAt(i - pizzas.getSize() - sides.getSize());
        }
        return this.desserts.getElementAt(i - pizzas.getSize() - sides.getSize() - drinks.getSize());
    }
    
    ListModel<String> getDesserts() {
        return this.desserts;
    }
    
    void addDessert(String name) {
        this.desserts.add(name);
        
    }
    
    void addSide(String name) {
        this.sides.add(name);
    }
    
    ListModel<String> getSides() {
        return this.sides;
        
    }
    
    void addDrink(String name) {
        this.drinks.add(name);
    }
    
    ListModel<String> getDrinks() {
        return this.drinks;
    }
    
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

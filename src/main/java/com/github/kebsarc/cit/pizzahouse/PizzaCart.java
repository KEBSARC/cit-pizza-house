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
 * the pizza cart is the model for each of the things i want to buy and it is represented by sub-carts on each page. 
 * sub-cart = sub-list
 */
public class PizzaCart extends AbstractListModel<String> {
    
    /** sub-cart for Drinks */
     
    Drinks drinks = new Drinks();
    
    /** sub-cart for Sides */
     
    Sides sides = new Sides();
    
    /** sub-cart for Pizzas */
    
    Pizzas pizzas = new Pizzas();
    
    /** sub-cart for Desserts */
    
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
    
    /** returning the sum of all sub-carts */
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
        /** if this index is part of the pizza list then it returns the pizza */
        if (index < pizzas.getSize())  {
            return pizzas.getElementAt(index);
        }
        
        /** 
        * if the index is within the sides sub-cart then return the cart element
        * because the index is over all of the sub-carts i need to takeaway the size of the pizza sub-  cart to make the index relative to the sides cart
        */
        if (index < pizzas.getSize() + sides.getSize()) {
            return this.sides.getElementAt(index - pizzas.getSize());
        }
        
        /** and so on */
        if (index < pizzas.getSize() + sides.getSize() + drinks.getSize()) {
            return this.drinks.getElementAt(index - pizzas.getSize() - sides.getSize());
        }
        return this.desserts.getElementAt(index - pizzas.getSize() - sides.getSize() - drinks.getSize());
    }
    
    
    ListModel<String> getDesserts() {
        return this.desserts;
    }
    
    /** adds a selected dessert 1 through 6 to the dessert sub-cart */
    void addDessert(String name) {
        this.desserts.add(name);
        updateOrderField();
        
    }
    
    /** adds a selected side 1 through 6 to the dessert sub-cart */
    void addSide(String name) {
        this.sides.add(name);
        updateOrderField();
    }
    
    ListModel<String> getSides() {
        return this.sides;
        
    }
    /** adds a selected drink 1 through 6 to the dessert sub-cart */
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
    
    /** */
    void registerTotalField(JTextField jTextField1) {
        this.orderTotalField = jTextField1;
        updateOrderField();
    }
    /** sets the current total order(all 4 sub-carts) to be the total of cart*/
    void updateOrderField() {
        this.orderTotalField.setText(getTotal());
    } 
}

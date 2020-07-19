/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kebsarc.cit.pizzahouse;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

/**
 *
 * @author kebsarc
 */
public class PizzaCart extends AbstractListModel<String> {

    Sides sides = new Sides();
    Pizzas pizzas = new Pizzas();
    Desserts desserts = new Desserts();

    public PizzaCart() {
    }

    ListModel<String> getPizzas() {
        return this.pizzas;
    }

    void addPizza(String name) {
        this.pizzas.add(name);
    }

    ListModel<String> getOrders() {
        return this;
    }

    @Override
    public int getSize() {
        return pizzas.getSize() + sides.getSize() + desserts.getSize();
    }

    @Override
    public String getElementAt(int i) {
        if (i < pizzas.getSize()) {
            return pizzas.getElementAt(i);
        }
        if (i < pizzas.getSize() + sides.getSize()) {
            return this.sides.getElementAt(i - pizzas.getSize());
        }
        return this.desserts.getElementAt(i - pizzas.getSize() - sides.getSize());
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

}

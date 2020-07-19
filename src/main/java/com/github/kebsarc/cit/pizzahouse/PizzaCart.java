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

    Pizzas pizzas = new Pizzas();

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
        return pizzas.getSize();
    }

    @Override
    public String getElementAt(int i) {
        return pizzas.getElementAt(i);
    }

}
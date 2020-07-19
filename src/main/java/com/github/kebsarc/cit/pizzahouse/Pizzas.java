/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kebsarc.cit.pizzahouse;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author kebsarc
 */
class Pizzas extends AbstractListModel<String> {

    List<String> pizzas = new ArrayList<>();

    @Override
    public int getSize() {
        return pizzas.size();
    }

    @Override
    public String getElementAt(int i) {
        return pizzas.get(i);
    }

    void add(String name) {
        if (pizzas.add(name)) {
            fireContentsChanged(this, pizzas.size(), pizzas.size());
        } else {
            throw new RuntimeException("failed to add pizza " + name);
        }
    }

}

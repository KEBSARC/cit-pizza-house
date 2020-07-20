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
class Drinks extends AbstractListModel<String> {

    List<String> drinks = new ArrayList<>();

    @Override
    public int getSize() {
        return drinks.size();
    }

    @Override
    public String getElementAt(int i) {
        return drinks.get(i);
    }

    void add(String name) {
        if (drinks.add(name)) {
            fireContentsChanged(this, drinks.size(), drinks.size());
        } else {
            throw new RuntimeException("failed to add drinks " + name);
        }
    }

}


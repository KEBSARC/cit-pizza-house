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
class Desserts extends AbstractListModel<String> {

    List<String> desserts = new ArrayList<>();

    @Override
    public int getSize() {
        return desserts.size();
    }

    @Override
    public String getElementAt(int i) {
        return desserts.get(i);
    }

    void add(String name) {
        if (desserts.add(name)) {
            fireContentsChanged(this, desserts.size(), desserts.size());
        } else {
            throw new RuntimeException("failed to add dessert " + name);
        }
    }

}